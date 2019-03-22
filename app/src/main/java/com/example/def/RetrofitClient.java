package com.example.def;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class RetrofitClient {
    public static final String BASE_URL = "https://gateway-lon.watsonplatform.net/assistant/api/";
    public static final String USER = "apikey";
    public static final String ASSISTANT_ID = "1880bf85-0bcd-4b77-917d-ddb4f3ed8df0";
    public static final String PASSWORD = "syRUmO5OizoHJM-Ur99kW923Zoz8iK6bE6I7qFyNHt2v";
    public static final String VERSION = "version=2018-11-08";
    public static final String SERVICE_PATH = "v2/assistants/" + ASSISTANT_ID + "/sessions";
    public static final String URL = String.format("%s/%s/%s", BASE_URL, SERVICE_PATH, VERSION);


    public static Retrofit retrofit ;

    public static Retrofit getClient(String baseUrl) {

        Interceptor autenticate = new AutenticateInterceptor(USER, PASSWORD);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(autenticate).build();


      //  if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        //}
        return retrofit;
    }

}

