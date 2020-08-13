package com.example.programmer.tamperelinjat.rest.itsfactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Programmer on 11/15/2017.
 */

public class ApiClient {
    public static final String BASE_URL = "http://data.itsfactory.fi/journeys/api/1/";
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
