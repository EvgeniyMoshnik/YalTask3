package com.example.evgeniy.yaltask3.rest;

import com.example.evgeniy.yaltask3.data.AppealEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Evgeniy
 */
public interface ApiService {

    @GET("tickets?state=0,9,5,7,8")
    Call<List<AppealEntity>> getInProgress();

    @GET("tickets?state=10,6")
    Call<List<AppealEntity>> getDone();

    @GET("tickets?state=1,3,4")
    Call<List<AppealEntity>> getPending();

    @GET("tickets")
    Call<List<AppealEntity>> getAll();

}
