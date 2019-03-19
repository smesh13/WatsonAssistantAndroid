package com.example.def;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SoService {

    @GET("/answare?order=desc&sort=activity&site=stackoverflow")
    Call<Response> getAnsware();

    @GET("/answare?order=desc&sort=activity&site=stackoverflow")
    Call<Response> getAnsware(@Query("tagged") String s);
}
