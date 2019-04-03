package com.example.def.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    String URL = "https://gateway-lon.watsonplatform.net/assistant/api/v2/assistants/";

    @POST("1880bf85-0bcd-4b77-917d-ddb4f3ed8df0/sessions")
    @Headers({ "Content-Type: application/json","X-Watson-Learning-Opt-Out: true", "grant_type: urn:ibm:params:oauth:grant-type:apikey" })
    Call<Authorization> createSession(@Header("Authorization") String authKey,
                                      @Query("version") String version);

    @POST("1880bf85-0bcd-4b77-917d-ddb4f3ed8df0/sessions/{sessionToken}")
    @Headers({ "Accept: application/json", "Content-Type: application/json","X-Watson-Learning-Opt-Out: true", "grant_type: urn:ibm:params:oauth:grant-type:apikey" })
    Call<MessageResponse> sendMessage(@Path("sessionToken") String sessionToken,
                                    @Query("version") String version,
                                    @Body String message);

    @DELETE("1880bf85-0bcd-4b77-917d-ddb4f3ed8df0/sessions/{sessionToken}")
    @Headers({ "Content-Type: application/json","X-Watson-Learning-Opt-Out: true", "grant_type: urn:ibm:params:oauth:grant-type:apikey" })
    Call<String> deleteSession(@Path("sessionToken") String sessionToken,
                               @Query("version") String version);

}