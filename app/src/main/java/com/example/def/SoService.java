package com.example.def;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static com.example.def.RetrofitClient.ASSISTANT_ID;
import static com.example.def.RetrofitClient.BASE_URL;
import static com.example.def.RetrofitClient.SERVICE_PATH;
import static com.example.def.RetrofitClient.VERSION;

public interface SoService {

    @POST(BASE_URL+SERVICE_PATH+"?"+VERSION)
    Call<ResponseBody> getAnsware();




    /*/v2/assistants/1880bf85-0bcd-4b77-917d-ddb4f3ed8df0/sessions?version=2018-11-08*/


    //@POST("/apikey/syRUmO5OizoHJM-Ur99kW923Zoz8iK6bE6I7qFyNHt2v/63e30edf-9ba2-44d0-87d7-4b37551956d0")



    /*@GET("/answare?order=desc&sort=activity&site=stackoverflow")
    Call<Response> getAnsware2(@Query("tagged") String s);*/
}
