package com.example.programmer.tamperelinjat.rest.siri;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Programmer on 11/8/2017.
 */

public class SiriApiClient {

    public static final String BASE_URL = "http://data.itsfactory.fi/siriaccess/vm/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
