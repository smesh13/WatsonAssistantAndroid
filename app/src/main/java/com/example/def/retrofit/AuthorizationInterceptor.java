package com.example.def.retrofit;

import android.util.Base64;

import com.example.def.application.App;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthorizationInterceptor implements Interceptor {
    public static final String VERSION = "2019-02-28";
    private App theApp;
    private Session session;

    public AuthorizationInterceptor(App apiService, Session session) {
        this.theApp = apiService;
        this.session = session;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Headers chainheaders = chain.request().headers();
        Request.Builder chainbuilder = chain.request().newBuilder();//.header("Authorization", session.getToken()).
//                            method(mainRequest.method(), mainRequest.body());
        String authKey = getAuthorizationHeader(session.getUserId(), session.getPassword());
        for(String name:chainheaders.names()){
            String value = chainheaders.get(name);
            chainbuilder.header(name,value);
        }
        chainbuilder.header("Authorization",authKey);
//        chainbuilder.url(chain.request().url().url().toString()+"/"+session.getToken());
        chainbuilder.method(chain.request().method(), chain.request().body());
        Request mainRequest = chainbuilder.build();
        Response mainResponse = chain.proceed(mainRequest);

        if (session.isLoggedIn()) {
            //if response code is 401 or 403 or 404, 'mainRequest' has encountered authentication error
            if (mainResponse.code() == 401 || mainResponse.code() == 403 || mainResponse.code() == 404) {
//                String authKey = getAuthorizationHeader(session.getUserId(), session.getPassword());
                // request to login API to get fresh token
                // synchronously calling login API
                retrofit2.Response<Authorization> createSessionResponse = theApp.getApiService().createSession(authKey,VERSION).execute();

                if (createSessionResponse.isSuccessful()) {
                    // login request succeed, new token generated
                    Authorization authorization = createSessionResponse.body();
                    // save the new token
                    session.saveToken(authorization.getSessionId());
                    // retry the 'mainRequest' which encountered an authentication error
                    // add new token into 'mainRequest' header and request again
                    RequestBody body = mainRequest.body();
                    Headers headers = mainRequest.headers();
                    Request.Builder builder = mainRequest.newBuilder();//.header("Authorization", session.getToken()).
//                            method(mainRequest.method(), mainRequest.body());
                    String oldurl = chain.request().url().url().toString();
                    int index1 = oldurl.indexOf("/sessions/");
                    int indexSIdFrom = index1 + 10;
                    int indexSIdTo = oldurl.indexOf("/",indexSIdFrom);
                    if(indexSIdTo<1)indexSIdTo = oldurl.indexOf("?",indexSIdFrom);
                    String newurl = oldurl.substring(0,indexSIdFrom)+session.getToken()+oldurl.substring(indexSIdTo);
                    builder.url(newurl);
                    for(String name:headers.names()){
                        String value = headers.get(name);
                        builder.header(name,value);
                    }
                    builder.method(mainRequest.method(), mainRequest.body());
                    mainResponse = chain.proceed(builder.build());
                }
            }
        }

        return mainResponse;
    }

    /**
     * this method is API implemetation specific
     * might not work with other APIs
     **/
    public static String getAuthorizationHeader(String userId, String password) {
        String credential = userId + ":" + password;
        String auth = "Basic " + Base64.encodeToString(credential.getBytes(), Base64.DEFAULT);
        int length = auth.length();
        return auth.substring(0,length-1);
    }
}