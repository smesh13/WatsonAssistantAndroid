package com.example.def;

import retrofit2.Retrofit;

public class ApiUtils {

    public static final String BASE_URL = "https://gateway-lon.watsonplatform.net/assistant/api";

    public static SoService getSoService(){

        return RetrofitClient.getClient(BASE_URL).create(SoService.class);
    }
}
