package com.example.peretz.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("products")
    Call<List<ResponseData>> getDataPeretz( @Query( "category" ) Integer category , @Query ( "key" ) String key);

}
