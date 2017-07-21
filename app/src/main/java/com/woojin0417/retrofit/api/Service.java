package com.woojin0417.retrofit.api;

import com.woojin0417.retrofit.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ash on 2017-07-20.
 */

public interface Service {
    @GET("/ordinary")
    Call<ItemResponse>getItems();
}
