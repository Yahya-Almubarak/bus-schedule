package com.example.programmer.tamperelinjat.util;

import android.util.Log;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.SphericalUtil;
import com.google.maps.android.geometry.Bounds;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Programmer on 11/27/2017.
 */

public class ApiUtil {

    public static String getStringBoundFromLatLngBound(LatLngBounds latLngBounds){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(latLngBounds.southwest.latitude)
                .append(",")
                .append(latLngBounds.southwest.longitude)
                .append(":")
                 .append(latLngBounds.northeast.latitude)
                    .append(",")
                    .append(latLngBounds.northeast.longitude)

                    ; // TODO Check relation between southeast and uppercorner etc.
        return stringBuilder.toString();
    }

    public static LatLng latLngFromCoordinates(String coordinates){
        StringTokenizer tokenzer = new StringTokenizer(coordinates, ",");
        double latitude = Double.parseDouble(tokenzer.nextToken());
        double longitude = Double.parseDouble(tokenzer.nextToken());
        return new LatLng(latitude, longitude);
    }

    /*public static String distanceBetweenTwoPointsString(LatLng loc1, LatLng loc2){
           int distance = Math.floor(SphericalUtil.computeDistanceBetween(loc1, loc2));

           if (distance < 1000) {
               return String.valueOf(distance) + " m.";
           } else if (distance < 10000) {
               return String.valueOf(Math.round(distance/1000)) + " km " + String.valueOf(distance%1000) + " m";
           } else {
               return String.valueOf(Math.round(distance/1000));
           }
    } */

    public static double distanceBetweenTwoPoints(LatLng loc1, LatLng loc2){
        return SphericalUtil.computeDistanceBetween(loc1, loc2);
    }

    public static String getLastStringFromUrl(String url){
        StringTokenizer tokenizer = new StringTokenizer(url, "/");
        String string = "";
        while (tokenizer.hasMoreTokens()){
            string = tokenizer.nextToken();
        }
        return string;
    }

    public static boolean isTimeAfterNow(String time){
        Calendar calendarNow = GregorianCalendar.getInstance();


        int hourOfDayNow = calendarNow.get(Calendar.HOUR_OF_DAY);
        int minutesNow = calendarNow.get(Calendar.MINUTE);
        int secondsNow = calendarNow.get(Calendar.SECOND);
        Log.i("Time", "" + hourOfDayNow + " : " + minutesNow + " : " + secondsNow);



       // Calendar calendarEntered = GregorianCalendar.getInstance();
        StringTokenizer tokenizer = new StringTokenizer(time, ":");
        int hours = Integer.parseInt(tokenizer.nextToken());
        int minutes = Integer.parseInt(tokenizer.nextToken());
        int seconds = Integer.parseInt(tokenizer.nextToken());
        Log.i("Time Entered", "" + hours + " : " + minutes + " : " + seconds);

       /* calendarEntered.set(Calendar.HOUR_OF_DAY,hours);
        calendarEntered.set(Calendar.MINUTE, minutes);
        calendarEntered.set(Calendar.SECOND, seconds);
        calendarEntered.add(Calendar.MINUTE, -5);
        return calendarEntered.after(calendarNow);*/
       if(hourOfDayNow < hours) {
           return true;
       } else if (hourOfDayNow == hours && minutesNow < minutes + 3){
           return true;
       } else {
           return false;
       }

    }

    public static List<LatLng> latLngsFromCoordProjection(String coordProjection) {
        final double divider = 100000.0;
        List<LatLng> latLngList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(coordProjection, ":");
        StringTokenizer pairTokenizer;
        String coordPair = "";
        List<String> latRawList = new ArrayList<>();
        List<String> lngRawList = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            coordPair = tokenizer.nextToken();
            pairTokenizer = new StringTokenizer(coordPair, ",");
            if (pairTokenizer.countTokens() != 2){
                return null;
            }
                latRawList.add(pairTokenizer.nextToken());
                lngRawList.add(pairTokenizer.nextToken());
        }

        List<Double> latDoubleList = new ArrayList<>();
        List<Double> lngDoubleList = new ArrayList<>();

        double latitude = Long.parseLong(latRawList.get(0));
        double longitude = Long.parseLong(lngRawList.get(0));
        latDoubleList.add(latitude);
        lngDoubleList.add(longitude);

        for (int i = 0; i < latRawList.size() - 1; i++){
            latitude = latitude - Long.parseLong(latRawList.get(i + 1));
            longitude = longitude - Long.parseLong(lngRawList.get(i + 1));
            latDoubleList.add(latitude);
            lngDoubleList.add(longitude);
        }
        for (int i = 0; i < latDoubleList.size(); i++){
            latLngList.add(new LatLng(latDoubleList.get(i)/ divider, lngDoubleList.get(i)/divider));
        }
        return latLngList;
    }

    public static LatLngBounds  getBoundsFronLatLngList(List<LatLng> latLngList, double percentage){
        percentage = (1 + percentage / 100);
        double east = 0;
        double west = 0;
        double north = 0;
        double south = 0;
        LatLng latLng;
        for (int i = 0; i < latLngList.size(); i++){
            latLng = latLngList.get(i);
            if (east > latLng.latitude) east = latLng.latitude;
            if (west < latLng.latitude) west = latLng.latitude;
            if (north < latLng.longitude) north = latLng.longitude;
            if (south > latLng.longitude) south = latLng.longitude;
        }
        return null;
       // return new LatLngBounds( new LatLng(west *percentage, south*percentage), new LatLng(east* percentage, north*percentage));

    }
}
