package com.example.def;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class AutenticateInterceptor implements Interceptor {
    private String credentials;
//checks that the user and password credentials are correct, and asks for their authentication
    public AutenticateInterceptor(String user, String password) {
        this.credentials = Credentials.basic(user, password);
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request;
        request = chain.request();
        Request authenticatedRequest = request.newBuilder()
                .header("Authorization", credentials).build();
        return chain.proceed(authenticatedRequest);

    }
}
