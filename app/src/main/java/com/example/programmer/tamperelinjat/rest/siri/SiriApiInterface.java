package com.example.programmer.tamperelinjat.rest.siri;


import com.example.programmer.tamperelinjat.model.siri.ServiceDelivery;
import com.example.programmer.tamperelinjat.model.siri.Siri;
import com.example.programmer.tamperelinjat.model.siri.Vehicles;
import com.example.programmer.tamperelinjat.model.stoppoint.StopPoints;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Programmer on 11/8/2017.
 */

public interface SiriApiInterface {
    @GET("json")
    Call<Vehicles> getSiriResponse();

}
