package com.example.def;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


import static com.example.def.RetrofitClient.SERVICE_PATH;
import static com.example.def.RetrofitClient.SERVICE_PATH2;
//import static com.example.def.RetrofitClient.URL2;
import static com.example.def.RetrofitClient.VERSION;



public interface SoService {
//first api call

    @POST(SERVICE_PATH+"?"+VERSION)
    Call<SessionId> getAnsware();

// second api call

    @POST(SERVICE_PATH2+"{session_id}/message?"+VERSION)
    Call<Obj1> getAnsware2(@Path("session_id") String sessiondID,@Body String mMessage1);//,@Path("message") String message);
}
