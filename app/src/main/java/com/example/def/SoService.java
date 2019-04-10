package com.example.def;

import android.support.annotation.StringRes;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import static com.example.def.RetrofitClient.SERVICE_PATH;
import static com.example.def.RetrofitClient.SERVICE_PATH2;
import static com.example.def.RetrofitClient.URL2;
import static com.example.def.RetrofitClient.VERSION;



public interface SoService {
    //String BASE_URL = "https://gateway-lon.watsonplatform.net/assistant/api/";

    @POST(SERVICE_PATH+"?"+VERSION)
    Call<SessionId> getAnsware();


//    @POST(SERVICE_PATH2+"/message?"+VERSION)
//    Call<MessageOutputBot> getAnsware2();

    /*/v2/assistants/1880bf85-0bcd-4b77-917d-ddb4f3ed8df0/sessions?version=2018-11-08*/
}
