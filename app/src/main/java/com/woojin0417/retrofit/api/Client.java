package com.woojin0417.retrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ash on 2017-07-20.
 */

public class Client {

    public static final String BASE_URL="http://ec2-52-26-144-160.us-west-2.compute.amazonaws.com:3000";
    public static Retrofit retrofit=null;
    public static Retrofit getClient(){
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
