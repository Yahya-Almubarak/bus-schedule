package com.example.programmer.tamperelinjat.rest.itsfactory;

import com.example.programmer.tamperelinjat.model.detailedvehicleactivity.VehicleActivities;
import com.example.programmer.tamperelinjat.model.journeypattern.JourneyPatterns;
import com.example.programmer.tamperelinjat.model.journeys.Journeys;
import com.example.programmer.tamperelinjat.model.journeys.Municipality;
import com.example.programmer.tamperelinjat.model.lines.Lines;
import com.example.programmer.tamperelinjat.model.routes.Routes;
import com.example.programmer.tamperelinjat.model.stoppoint.StopPoints;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Programmer on 11/15/2017.
 */

public interface ApiInterface {
    @GET("lines")
    Call<Lines> getLinesResponse(@Query("id") String id, @Query("description") String description);

    @GET("lines")
    Call<Lines> getLinesResponseById(@Query("id") String id);

    @GET("lines")
    Call<Lines> getLinesResponseByDescription(@Query("description") String description);

    @GET("lines")
    Call<Lines> getAllLinesResponse();

    @GET("routes")
    Call<Routes> getRouteResponse(@Query("lineId") String lineId, @Query("name") String name);

    @GET("routes")
    Call<Routes> getRouteResponse(@Query("lineId") String lineId);

    @GET("journey-patterns")
    Call<JourneyPatterns> getJourneyPatternResponse(@Query("lineId") String lineId, @Query("name") String name,
                                                    @Query("firstStopPointId") String firstStopPointId,
                                                    @Query("lastStopPointId") String lastStopPointId,
                                                    @Query("stopPointId") String stopPointId);

    @GET("journey-patterns/{journeyPatternRef}")
    Call<JourneyPatterns> getJourneyPatternResponse(@Path("journeyPatternRef") String journeyPatternRef);

    @GET("journeys")
    Call<Journeys> getJourneyResponse(@Query("lineId") String lineId, @Query("routeId") String routeId,
                                      @Query("journeyPatternId") String journeyPatternId,
                                      @Query("dayTypes") String dayTypes,
                                      @Query("departureTime") String departureTime,
                                      @Query("arrivalTime") String arrivalTime,
                                      @Query("firstStopPointId") String firstStopPointId,
                                      @Query("lastStopPointId") String lastStopPointId,
                                      @Query("stopPointId") String stopPointId,
                                      @Query("gtfsTripId") String gtfsTripId);

    @GET("journeys/{journeyRef}")
    Call<Journeys> getJourneyResponse(@Path("journeyRef") String journeyRef);

    @GET("journeys")
    Call<Journeys> getJourneysPassingStopPoint(@Query("stopPointId") String stopId);

    @GET("stop-points")
    Call<StopPoints> getStopPointResponse(@Query("name") String name,
                                          @Query("location") String location,
                                          @Query("tariffZone") String tariffZone,
                                          @Query("municipalityName") String municipalityName);

    @GET("stop-points")
    Call<StopPoints> getStopPointResponse(@Query("location") String location);

    @GET("stop-points/{stopId}")
    Call<StopPoints> getStopPoint(@Path("stopId") String stopId);

    @GET("municipalities")
    Call<Municipality> getMunicipalitiesResponse(@Query("name") String name, @Query("shortName") String shortName);


    @GET("vehicle-activity")
    Call<VehicleActivities> getDetailedActivity(@Query("vehicleRef") String vehicleRef);

    @GET("vehicle-activity")
    Call<VehicleActivities> getDetailedActivity();

    //@GET("stop-monitoring") TODO
    //Call<StopMointoring> getVehicleFromStopMonitoring(@Query("stopPointId") String stopId);
}
