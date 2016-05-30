package com.example.evgeniy.yaltask3.utils;

import com.example.evgeniy.yaltask3.data.model.AppealEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Evgeniy
 */
public interface TicketService {

    //    @GET("tickets?state=0,9,5,7,8")
//    Call<List<IssueEntity>> getInProgress();
//
//    @GET("tickets?state=10,6")
//    Call<List<IssueEntity>> getDone();
//
//    @GET("tickets?state=1,3,4")
//    Call<List<IssueEntity>> getPending();

   // @GET("tickets")
 //   Call<List<AppealEntity>> getListByStateFilter(@Query("state") String filter);

 //   @GET("tickets")
  //  Call<List<AppealEntity>> getAll();



    @GET("tickets")
    Call<List<AppealEntity>> getListByStateFilter(@Query("state") String filter);

    @GET("tickets")
    Call<List<AppealEntity>> getListByStateFilter(@Query("state") String filter,
                                                  @Query("amount") int amount,
                                                  @Query("offset") int offset);


    @GET("tickets")
    Call<List<AppealEntity>> getAll(@Query("amount") int amount, @Query("offset") int offset);
}
