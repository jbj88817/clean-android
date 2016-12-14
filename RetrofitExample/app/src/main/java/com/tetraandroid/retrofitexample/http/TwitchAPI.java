package com.tetraandroid.retrofitexample.http;

import com.tetraandroid.retrofitexample.http.apimodel.APISS;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface TwitchAPI {

    @GET("games/top")
    Call<APISS> getTopGames(@Header("Client-Id") String clientId);

}
