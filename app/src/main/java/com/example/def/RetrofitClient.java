package com.example.def;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null ;

    public  static Retrofit getClient(String baseUrl) {
        if ( retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://gateway-lon.watsonplatform.net/assistant/api")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
            return retrofit;
    }
}
