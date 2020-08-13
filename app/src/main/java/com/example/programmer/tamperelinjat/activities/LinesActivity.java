package com.example.programmer.tamperelinjat.activities;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.programmer.tamperelinjat.R;
import com.example.programmer.tamperelinjat.model.journeypattern.JourneyPatterns;
import com.example.programmer.tamperelinjat.model.journeypattern.StopPoint;
import com.example.programmer.tamperelinjat.model.lines.Line;
import com.example.programmer.tamperelinjat.model.lines.Lines;
import com.example.programmer.tamperelinjat.model.routes.Route;
import com.example.programmer.tamperelinjat.model.routes.Routes;
import com.example.programmer.tamperelinjat.recyclerviews.departures.DeparturesInfoObject;
import com.example.programmer.tamperelinjat.recyclerviews.detailedline.LineInfoObject;
import com.example.programmer.tamperelinjat.recyclerviews.journeypattern.StopsInfoObject;
import com.example.programmer.tamperelinjat.recyclerviews.journeypattern.StopsItemFragment;
import com.example.programmer.tamperelinjat.recyclerviews.lines.LinesGroup;
import com.example.programmer.tamperelinjat.recyclerviews.lines.LinesInfoObject;
import com.example.programmer.tamperelinjat.recyclerviews.lines.LinesItemFragment;
import com.example.programmer.tamperelinjat.rest.itsfactory.ApiClient;
import com.example.programmer.tamperelinjat.rest.itsfactory.ApiInterface;
import com.example.programmer.tamperelinjat.util.ApiUtil;
import com.example.programmer.tamperelinjat.util.BottomNavigationViewExHelper;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LinesActivity extends AppCompatActivity  implements LinesItemFragment.OnListFragmentInteractionListener, StopsItemFragment.OnListFragmentInteractionListener,
        OnMapReadyCallback{

    private static final String TAG = LinesActivity.class.getSimpleName();
    private static final String LINES_LIST_FRAGMENT_TAG = "LINES_LIST_FRAGMENT_TAG";
    private static final String MAP_FRAGMENT_TAG = "MAP_FRAGMENT";
    private static final String STOPS_LIST_FRAGMENT_TAG = "STOPS_LIST_FRAGMENT_TAG";

    private BottomNavigationViewEx.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new NavigationViewListener(this);
    private List<Line> allLinesList;
    private LinesItemFragment linesFragment;
    private List<LatLng> journeyPatternlatLngList;
    private GoogleMap mMap;
    Routes routes;
    List<Route> routesList;
    private LatLngBounds mBound;
    private JourneyPatterns journeyPatterns;

    public Map<String, StopPoint> stopPointsIndexedByMarkerId = new HashMap<>();
    private List<Marker> stopPointsMarkers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeBottomNavigationView();
        LineInfoObject.ITEMS.clear();
        readLinesFromFavourite();
        readLinesFromNearbyStops();
        readLinesFromHistory();
        readAllLines();
    }

    private void readLinesFromFavourite() {
        // Todo
        List<Line> list = new ArrayList<>();
        list.add(new Line("http://178.217.134.14/journeys/api/1/lines/13", "13", "Hermia - Lamminpää - Ylöjärvi"));
        list.add(new Line("http://178.217.134.14/journeys/api/1/lines/13", "15", "Hermia - Lamminpää - Ylöjärvi"));
        list.add(new Line("http://178.217.134.14/journeys/api/1/lines/13", "70", "Hermia - Lamminpää - Ylöjärvi"));
        list.add(new Line("http://178.217.134.14/journeys/api/1/lines/13", "9", "Hermia - Lamminpää - Ylöjärvi"));
        LinesInfoObject.ITEMS.add(LinesGroup.FAVOURITE);
        LinesInfoObject.ITEMS.addAll(list);
    }

    private void readLinesFromNearbyStops() {
        // Todo
        List<Line> list = new ArrayList<>();
        list.add(new Line("http://178.217.134.14/journeys/api/1/lines/13", "22", "Hermia - Lamminpää - Ylöjärvi"));
        list.add(new Line("http://178.217.134.14/journeys/api/1/lines/13", "5", "Hermia - Lamminpää - Ylöjärvi"));
        list.add(new Line("http://178.217.134.14/journeys/api/1/lines/13", "18", "Hermia - Lamminpää - Ylöjärvi"));
        list.add(new Line("http://178.217.134.14/journeys/api/1/lines/13", "61", "Hermia - Lamminpää - Ylöjärvi"));
        LinesInfoObject.ITEMS.add(LinesGroup.BUS_STOP);
        LinesInfoObject.ITEMS.addAll(list);
    }

    private void readLinesFromHistory() {
        // Todo
        List<Line> list = new ArrayList<>();
        list.add(new Line("http://178.217.134.14/journeys/api/1/lines/13", "7", "Hermia - Lamminpää - Ylöjärvi"));
        list.add(new Line("http://178.217.134.14/journeys/api/1/lines/13", "21", "Hermia - Lamminpää - Ylöjärvi"));
        list.add(new Line("http://178.217.134.14/journeys/api/1/lines/13", "9", "Hermia - Lamminpää - Ylöjärvi"));
        list.add(new Line("http://178.217.134.14/journeys/api/1/lines/13", "40", "Hermia - Lamminpää - Ylöjärvi"));
        LinesInfoObject.ITEMS.add(LinesGroup.HISTORY);
        LinesInfoObject.ITEMS.addAll(list);
    }

    private void readAllLines() {
        ApiInterface ApiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Lines> call = ApiService.getAllLinesResponse();
        Log.i("Lines Request ", call.request().toString());
        call.enqueue(new Callback<Lines>() {
            @Override
            public void onResponse(Call<Lines> call, Response<Lines> response) {
                allLinesList = response.body().getBody();
                LinesInfoObject.ITEMS.add(LinesGroup.ALL);
                LinesInfoObject.ITEMS.addAll(allLinesList);
                Log.i("Lines Size", String.valueOf(allLinesList.size()));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //fragmentTransaction.remove(fragmentManager.findFragmentByTag(MAP_FRAGMENT_TAG));
                linesFragment = new LinesItemFragment();
                fragmentTransaction.add(R.id.main_layout_first_holder, linesFragment, LINES_LIST_FRAGMENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }

            @Override
            public void onFailure(Call<Lines> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

    private void initializeBottomNavigationView() {
        BottomNavigationViewEx navigation = (BottomNavigationViewEx) findViewById(R.id.navigation);
        BottomNavigationViewExHelper.setupBottomNavigationViewEx(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onListFragmentInteraction(Object item, int position) {
        if (item == LinesGroup.ALL ){
           LinesInfoObject.ITEMS.removeAll(allLinesList);
            ((RecyclerView) linesFragment.getView()).getAdapter().notifyDataSetChanged();
        } else if (item instanceof Line) {
            readRouteForLineName((Line) item, position);
        } else if (item instanceof Route){
            String coordProjection = ((Route) item).getGeographicCoordinateProjection();
            journeyPatternlatLngList = ApiUtil.latLngsFromCoordProjection(coordProjection);
            mBound = ApiUtil.getBoundsFronLatLngList(journeyPatternlatLngList, 40);
            Log.i("Size of latlng", String.valueOf(journeyPatternlatLngList.size()));
            Log.i("latLngList", journeyPatternlatLngList.toString());
            readJourneyPattern((Route) item);
        }


    }




    private void readJourneyPattern(Route item) {
        ApiInterface ApiService = ApiClient.getClient().create(ApiInterface.class);
        String url = item.getJourneyPatterns().get(0).getUrl();
        Call<JourneyPatterns> call = ApiService.getJourneyPatternResponse(ApiUtil.getLastStringFromUrl(url));
        Log.i("Request", call.request().toString());
        call.enqueue(new Callback<JourneyPatterns>() {
            @Override
            public void onResponse(Call<JourneyPatterns> call, Response<JourneyPatterns> response) {
                journeyPatterns = response.body();
                deployMap();

                //((RecyclerView) fragment.getView()).getAdapter().notifyDataSetChanged();
                Log.i("LinesActivity", "routes list size " + String.valueOf(routesList.size()));
            }

            @Override
            public void onFailure(Call<JourneyPatterns> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

    public void deployMap() {
        // execution from readJourneyPattern(Route item)
        SupportMapFragment mapFragment = new MainMapFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragmentManager.findFragmentByTag(LINES_LIST_FRAGMENT_TAG));
        fragmentTransaction.add(R.id.main_layout_first_holder,  mapFragment, MAP_FRAGMENT_TAG);
        fragmentTransaction.commitAllowingStateLoss();
        mapFragment.getMapAsync(this);
        // execution moves to onMapReady()
    }



    private void readRouteForLineName(Line line, final int position) {

        ApiInterface ApiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Routes> call = ApiService.getRouteResponse(line.getName());
        Log.i("Request", call.request().toString());
        call.enqueue(new Callback<Routes>() {
            @Override
            public void onResponse(Call<Routes> call, Response<Routes> response) {
                routes = response.body();
                routesList = routes.getRoute();
                LinesInfoObject.ITEMS.addAll(position + 1, routesList);
                ((RecyclerView) linesFragment.getView()).getAdapter().notifyDataSetChanged();
                Log.i("LinesActivity", "routes list size" + String.valueOf(routesList.size()));
            }

            @Override
            public void onFailure(Call<Routes> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .color(Color.BLUE)
                .width(4.0f)
                .addAll(journeyPatternlatLngList));
        LatLngBounds.Builder builder = LatLngBounds.builder();
        for (LatLng latLng: journeyPatternlatLngList){
            builder.include(latLng);
        }
        LatLngBounds bounds = builder.build();
        mBound = bounds;
        addStopPointMarkers(journeyPatterns.getJournyPattern().get(0).getStopPoints());
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 40));
        //showStopPointButton();
        showStopsListFragment();
       // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mBound.getCenter(), 10));

    }

    private void showStopsListFragment() {
        StopsInfoObject.ITEMS.clear();
        StopsInfoObject.ITEMS.addAll(journeyPatterns.getJournyPattern().get(0).getStopPoints());
        Log.i("ITEMS", String.valueOf(StopsInfoObject.ITEMS.size()));
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.remove(fragmentManager.findFragmentByTag(MAP_FRAGMENT_TAG));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.height = 400;

        fragmentManager.findFragmentByTag(MAP_FRAGMENT_TAG).getView().setLayoutParams(layoutParams);
        StopsItemFragment stopsFragment = new StopsItemFragment();
        fragmentTransaction.add(R.id.main_layout_second_holder, stopsFragment, STOPS_LIST_FRAGMENT_TAG);

        //linesFragment = new LinesItemFragment();
        //fragmentTransaction.add(R.id.main_layout_second_holder, linesFragment, LINES_LIST_FRAGMENT_TAG);

        fragmentTransaction.commit();
    }

    private void showStopPointButton() {
        Button button = new Button(this);
        int direction = Integer.parseInt(journeyPatterns.getJournyPattern().get(0).getDirection());
        String origin = journeyPatterns.getJournyPattern().get(0).getOriginStop();
        String destination = journeyPatterns.getJournyPattern().get(0).getDestinationStop();
        String buttonText;
        if (direction == 2){
            buttonText = destination + " : " + origin;
        } else {
            buttonText = origin + " : " + destination;
        }
        button.setText(buttonText);
        FrameLayout layout = (FrameLayout) findViewById(R.id.main_layout_second_holder);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(layoutParams);
        Toast.makeText(this, "botton", Toast.LENGTH_SHORT).show();
        layout.addView(button);

    }

    private void addStopPointMarkers(List<StopPoint> stopPointList) {
        if (stopPointList == null){ return;}
        Marker marker;
        for (int i = 0; i < stopPointsMarkers.size(); i++){
            marker = stopPointsMarkers.get(i);
            marker.remove();
        }

        stopPointsIndexedByMarkerId.clear();
        stopPointsMarkers.clear();

        Log.i("stopPointAddMarker", String.valueOf(stopPointList.size()));

        StopPoint stop;
        for (int i = 0; i < stopPointList.size(); i++){
            stop = stopPointList.get(i);
            marker = addStopPointMarker(stop);
            if(marker != null) {
                stopPointsIndexedByMarkerId.put(marker.getId(), stop);
                stopPointsMarkers.add(marker);
            }
        }
        if (!stopPointsMarkers.isEmpty()){
           // mBusPointsNeedsRedraw = false;
        }
    }

    private Marker addStopPointMarker(StopPoint stop) {
        LatLng stopLatLng = ApiUtil.latLngFromCoordinates(stop.getLocation());
        if(mMap !=null && stopLatLng != null) {

            MarkerOptions markerOptions = new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_stop))
                    .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                    .position(stopLatLng);
            Marker marker = mMap.addMarker(markerOptions);
            String id = marker.getId();
            Log.i(TAG, "add stop marker with id= " + id);
            return marker;
        } else {
            return null;
        }

    }

    @Override
    public void onListFragmentInteraction(Object item) {
        com.example.programmer.tamperelinjat.model.stoppoint.StopPoint stopPoint = (com.example.programmer.tamperelinjat.model.stoppoint.StopPoint) item;
        showStopPointDepartures(item);

    }

    private void showStopPointDepartures(Object item) {

        // Todo read departures and add them to fragment holder 2
        // see MainActivity.readApprochingVehiclesFromJourneys(...
        // )
    }
}
