package com.example.programmer.tamperelinjat.views;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.programmer.tamperelinjat.R;
import com.example.programmer.tamperelinjat.activities.MainActivity;
import com.example.programmer.tamperelinjat.model.stoppoint.StopPoint;
import com.example.programmer.tamperelinjat.util.ApiUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.Map;

/**
 * Created by Programmer on 11/13/2017.
 */

public class StopMarkerInfoWindow implements GoogleMap.InfoWindowAdapter {
    private  Map<String, StopPoint> stopsIndexedByMarkerID;
    private  Context context;
    private LatLng mCurrentLatLng;

    public StopMarkerInfoWindow(Context context) {
        this.context = context;
        stopsIndexedByMarkerID = ((MainActivity) context).stopPointsIndexedByMarkerId;
        mCurrentLatLng = ((MainActivity) context).getmCurrentLatLng();

    }

    @Override
    public View getInfoWindow(Marker marker) {
        String id = marker.getId();
        StopPoint stop = stopsIndexedByMarkerID.get(id);
        String title = "";
        String code = "";
        String timeTo = "";

            title = stop.getName();
            code = stop.getShortName();

        Log.i("mCurrentLatLng", mCurrentLatLng== null? "Null mCurrentLatLng": mCurrentLatLng.toString());
          //  double  distance = ApiUtil.distanceBetweenTwoPoints(mCurrentLatLng, ApiUtil.latLngFromCoordinates(stop.getLocation()));
            double distance = 150;   // TODO
            long time = Math.round(distance * 60 / 4000);
            if (time <= 60 ){
                timeTo = String.valueOf(time) + " min";
            } else {
                int hours =  (int)time / 60;
                int minutes = (int) time% 60;
                timeTo = "" + hours + " h " + minutes + " min";
            }

        View view = ((Activity)context).getLayoutInflater().inflate(R.layout.info_window, null);
        ((TextView) view.findViewById(R.id.title)).setText(title);
        ((TextView) view.findViewById(R.id.snippet)).setText(code);
        ((TextView) view.findViewById(R.id.time_to_reach)).setText (timeTo);

        return view;

    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}


