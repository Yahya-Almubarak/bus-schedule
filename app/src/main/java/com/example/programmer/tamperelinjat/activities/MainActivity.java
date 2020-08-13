package com.example.programmer.tamperelinjat.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.programmer.tamperelinjat.R;
import com.example.programmer.tamperelinjat.model.detailedvehicleactivity.MonitoredVehicleJourney;
import com.example.programmer.tamperelinjat.model.detailedvehicleactivity.VehicleActivities;
//import com.example.programmer.tamperelinjat.model.siri.LineRef;
//import com.example.programmer.tamperelinjat.model.siri.VehicleActivity;
import com.example.programmer.tamperelinjat.model.detailedvehicleactivity.VehicleActivity;
import com.example.programmer.tamperelinjat.model.journeys.Body;
import com.example.programmer.tamperelinjat.model.journeys.Journeys;
import com.example.programmer.tamperelinjat.model.stoppoint.StopPoint;
import com.example.programmer.tamperelinjat.model.stoppoint.StopPoints;
import com.example.programmer.tamperelinjat.recyclerviews.departures.Departure;
import com.example.programmer.tamperelinjat.recyclerviews.departures.DepartureItemFragment;
import com.example.programmer.tamperelinjat.recyclerviews.departures.DeparturesInfoObject;
import com.example.programmer.tamperelinjat.recyclerviews.detailedline.LineInfoObject;
import com.example.programmer.tamperelinjat.recyclerviews.detailedline.LineItemFragment;
import com.example.programmer.tamperelinjat.rest.itsfactory.ApiClient;
import com.example.programmer.tamperelinjat.rest.itsfactory.ApiInterface;
import com.example.programmer.tamperelinjat.util.ApiUtil;
import com.example.programmer.tamperelinjat.util.BottomNavigationViewExHelper;
import com.example.programmer.tamperelinjat.views.StopMarkerInfoWindow;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks,
        LocationListener,
        OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnInfoWindowClickListener,
        GoogleMap.OnCameraMoveListener,
        GoogleMap.OnCameraIdleListener,
        DepartureItemFragment.OnListFragmentInteractionListener,
        LineItemFragment.OnListFragmentInteractionListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String MAP_FRAGMENT_TAG = "MAP_FRAGMENT";
    private static final String DEPARTURE_LIST_FRAGMENT_TAG = "DEPARTURE_LIST_FRAGMENT_TAG";
    private static final String LINE_LIST_FRAGMENT_TAG = "LINE_LIST_FRAGMENT_TAG";

    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationCallback mLocationCallback;

    private Location mCurrentLocation;
    private LatLng mCurrentLatLng;
    private LatLngBounds mMapbound;
    public GoogleMap mMap;


    List<StopPoint> mNearbyStopsList;
    public Map<String, StopPoint> stopPointsIndexedByMarkerId = new HashMap<>();
    private List<Marker> stopPointsMarkers = new ArrayList<>();

    private Map<String, VehicleActivity> vehicleActivityIndexedByMarkerId = new HashMap<>();
    private List<Marker> vehicleActivityMarkers = new ArrayList<>();
    private List<Departure> departures = new ArrayList<>();

    private boolean mCameraMoved;

    private Handler handler = new Handler();
    private boolean mPause = false;

    private boolean mBusPointsNeedsRedraw;

    private BottomNavigationViewEx.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new NavigationViewListener(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationViewEx bnve = (BottomNavigationViewEx) findViewById(R.id.navigation);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);
        bnve.enableAnimation(false);
        initializeBottomNavigationView();
        setPreferredPreferences();
        startGoogleService();
        startLocationService();
        deployMap();
        mBusPointsNeedsRedraw = true;
        handler.post(runnablecode);
        readLines();

    }

    public void deployMap() {
        SupportMapFragment mapFragment = new MainMapFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_layout_first_holder,  mapFragment, MAP_FRAGMENT_TAG);
        fragmentTransaction.commit();
        mapFragment.getMapAsync(this);
    }

    public void removeMap() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager.findFragmentByTag("MainMapFragment");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(mapFragment);
        fragmentTransaction.commit();

    }

    private void readLines() {

    }

    private void setPreferredPreferences() {

    }

    private void startGoogleService() {
        // Check if Google services are available
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (googleApiAvailability.isGooglePlayServicesAvailable(this) != ConnectionResult.SUCCESS) {
            googleApiAvailability.getErrorDialog(this, googleApiAvailability.isGooglePlayServicesAvailable(this), 0);
        }
        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .addApi(Places.GEO_DATA_API)
                    .addApi(Places.PLACE_DETECTION_API)
                    .enableAutoManage(this, this)
                    .build();
        }

    }

    private void startLocationService() {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (checkLocationPermission()) return;
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            mCurrentLocation = location;
                            mCurrentLatLng = new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mCurrentLatLng, 15));
                            // startNearbyStopsIntentService(mCurrentLatLng, 10000);
                            Log.i("mCurrentLatLng", mCurrentLatLng.toString());
                        }
                    }
                });

    }



    private boolean checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return true;
        }
        return false;
    }

    private void initializeBottomNavigationView() {
        BottomNavigationViewEx navigation = (BottomNavigationViewEx) findViewById(R.id.navigation);
        BottomNavigationViewExHelper.setupBottomNavigationViewEx(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);

        // Configure the search info and add any event listeners...
        // Define the listener
        MenuItemCompat.OnActionExpandListener expandListener = new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(getBaseContext(), "Action Search is colapsed", Toast.LENGTH_SHORT).show();
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                Toast.makeText(getBaseContext(), "Action Search is Expanded", Toast.LENGTH_SHORT).show();
                return true;  // Return true to expand action view
            }
        };

        // Get the MenuItem for the action item
        MenuItem actionMenuItem = menu.findItem(R.id.action_search);

        // Assign the listener to that action item
        MenuItemCompat.setOnActionExpandListener(actionMenuItem, expandListener);

        // Any other things you have to do when creating the options menu…


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
    }

    public LatLng getmCurrentLatLng() {
        Log.i("getmCurrentLat", mCurrentLatLng == null? "NULL" : mCurrentLatLng.toString());
        return mCurrentLatLng;
//        return  new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        mCurrentLocation = location;
        mCurrentLatLng = new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());
        if (mMap != null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mCurrentLatLng, 15));
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnCameraMoveListener(this);
        if (checkLocationPermission()) return;
        mMap.setMyLocationEnabled(true);
        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(this);
        mMap.setInfoWindowAdapter(new StopMarkerInfoWindow(this));
        mBusPointsNeedsRedraw = true;

    }



    @Override
    public void onInfoWindowClick(Marker marker) {
        //readApprochingVehiclesFromStopMontoring(marker);
        readApprochingVehiclesFromJourneys(marker);

    }

    private void readApprochingVehiclesFromStopMontoring(Marker marker) { // ToDo
        /*final StopPoint stopPoint = stopPointsIndexedByMarkerId.get(marker.getId());
        final String stopPointId = stopPoint.getShortName();


        ApiInterface ApiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Journeys> call = ApiService.getJourneysPassingStopPoint(stopPointId);
        Log.i("Journeys Request ", call.request().toString());
        call.enqueue(new Callback<Journeys>() {
            @Override
            public void onResponse(Call<Journeys> call, Response<Journeys> response) {
                com.example.programmer.tamperelinjat.model.journeys.Call journeyCall;
                List<Line> bodyList = response.body().getRoute();
                List<com.example.programmer.tamperelinjat.model.journeys.Call> calls;

                Line journeyBody;
                String line;
                String departureTime;
                String headSign;

                for (int i = 0; i < bodyList.size(); i++){
                    journeyBody = bodyList.get(i);
                    calls = journeyBody.getCalls();
                    for (int j = 0; j < calls.size(); j++){
                        journeyCall = calls.get(j);
                        departureTime = journeyCall.getDepartureTime();
                        //if (journeyCall.getStopPoint().getShortName().equals(stopPointId) && ApiUtil.isTimeAfterNow(departureTime)){
                        if (journeyCall.getStopPoint().getShortName().equals(stopPointId)){
                            line = ApiUtil.getLastStringFromUrl(journeyBody.getLineUrl());
                            headSign = journeyBody.getHeadSign();
                            departures.add(new Departure(line, departureTime, headSign, journeyBody));
                        }
                    }
                }

                LinesInfoObject.ITEMS.clear();
                LinesInfoObject.ITEMS.add(stopPoint);
                LinesInfoObject.ITEMS.addAll(departures);

                Log.i("Departures Size", String.valueOf(departures.size()));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(fragmentManager.findFragmentByTag(MAP_FRAGMENT_TAG));
                fragmentTransaction.add(R.id.main_layout_first_holder, new LinesItemFragment(), DEPARTURE_LIST_FRAGMENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }

            @Override
            public void onFailure(Call<Journeys> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        }); */
    }

    private void readApprochingVehiclesFromJourneys(Marker marker) {
        final StopPoint stopPoint = stopPointsIndexedByMarkerId.get(marker.getId());
        final String stopPointId = stopPoint.getShortName();


        ApiInterface ApiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Journeys> call = ApiService.getJourneysPassingStopPoint(stopPointId);
        Log.i("Journeys Request ", call.request().toString());
        call.enqueue(new Callback<Journeys>() {
            @Override
            public void onResponse(Call<Journeys> call, Response<Journeys> response) {
                com.example.programmer.tamperelinjat.model.journeys.Call journeyCall;
                List<Body> bodyList = response.body().getBody();
                List<com.example.programmer.tamperelinjat.model.journeys.Call> calls;

                Body journeyBody;
                String line;
                String departureTime;
                String headSign;

                for (int i = 0; i < bodyList.size(); i++){
                    journeyBody = bodyList.get(i);
                    calls = journeyBody.getCalls();
                    for (int j = 0; j < calls.size(); j++){
                        journeyCall = calls.get(j);
                        departureTime = journeyCall.getDepartureTime();
                        //if (journeyCall.getStopPoint().getShortName().equals(stopPointId) && ApiUtil.isTimeAfterNow(departureTime)){
                            if (journeyCall.getStopPoint().getShortName().equals(stopPointId)){
                            line = ApiUtil.getLastStringFromUrl(journeyBody.getLineUrl());
                            headSign = journeyBody.getHeadSign();
                            departures.add(new Departure(line, departureTime, headSign, journeyBody));
                        }
                    }
                }

                DeparturesInfoObject.ITEMS.clear();
                DeparturesInfoObject.ITEMS.add(stopPoint);
                DeparturesInfoObject.ITEMS.addAll(departures);

                Log.i("Departures Size", String.valueOf(departures.size()));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(fragmentManager.findFragmentByTag(MAP_FRAGMENT_TAG));
                fragmentTransaction.add(R.id.main_layout_first_holder, new DepartureItemFragment(), DEPARTURE_LIST_FRAGMENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }

            @Override
            public void onFailure(Call<Journeys> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if(stopPointsMarkers.contains(marker)) {
            marker.showInfoWindow();
        } else if (vehicleActivityMarkers.contains(marker)){
           VehicleActivity vehicleActivity = vehicleActivityIndexedByMarkerId.get(marker.getId());
           readDetailedVehicleActivity(vehicleActivity);
        }
        return true;
    }


    VehicleActivities vehicleActivities;


    private void readDetailedVehicleActivity(final VehicleActivity vehicleActivity) {
       MonitoredVehicleJourney monitoredVehicleJourney = vehicleActivity.getMonitoredVehicleJourney();
        //String datedVehicleJourneyRef = vehicleActivity.getMonitoredVehicleJourney().getFramedVehicleJourneyRef().getDatedVehicleJourneyRef();
        String journeyRef = monitoredVehicleJourney.getJourneyPatternRef() + "_" +
                monitoredVehicleJourney.getOriginAimedDepartureTime() + "_" +
                monitoredVehicleJourney.getDestinationShortName() + "_" +
                monitoredVehicleJourney.getOriginShortName();
        Log.i("JournerRef Request ", journeyRef);
        ApiInterface ApiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Journeys> call = ApiService.getJourneyResponse(journeyRef);
        Log.i("Journeys Request ", call.request().toString());
        call.enqueue(new Callback<Journeys>() {
            @Override
            public void onResponse(Call<Journeys> call, Response<Journeys> response) {
                List<com.example.programmer.tamperelinjat.model.journeys.Call> calls = response.body().getBody().get(0).getCalls();
                Log.i("Calls Size", String.valueOf(calls.size()));
                LineInfoObject.ITEMS.clear();
                LineInfoObject.ITEMS.add(vehicleActivity);
                LineInfoObject.ITEMS.addAll(calls);

                Log.i("Departures Size", String.valueOf(calls.size()));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(fragmentManager.findFragmentByTag(MAP_FRAGMENT_TAG));
                fragmentTransaction.add(R.id.main_layout_first_holder, new LineItemFragment(), LINE_LIST_FRAGMENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();

            }

            @Override
            public void onFailure(Call<Journeys> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

    @Override
    public void onCameraMove() {
        mBusPointsNeedsRedraw = true;
    }

    @Override
    public void onCameraIdle() {
        mBusPointsNeedsRedraw = true;
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
            mBusPointsNeedsRedraw = false;
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

    private void addVehicleActivityMarker(List<VehicleActivity> vehicleActivityList) {
        for (Marker marker: vehicleActivityMarkers){
            marker.remove();
        }
        vehicleActivityIndexedByMarkerId.clear();
        vehicleActivityMarkers.clear();
        Marker marker;
        for (int i = 0; i < vehicleActivityList.size(); i++) {
            VehicleActivity vehicleActivity = vehicleActivityList.get(i);
            double latitude = Double.parseDouble(vehicleActivity.getMonitoredVehicleJourney().getVehicleLocation().getLatitude());
            double longitude = Double.parseDouble(vehicleActivity.getMonitoredVehicleJourney().getVehicleLocation().getLongitude());
            LatLng latLng = new LatLng(latitude, longitude);
            if (! mMap.getProjection().getVisibleRegion().latLngBounds.contains(latLng)){
                continue;
            }
            String lineRef = vehicleActivity.getMonitoredVehicleJourney().getLineRef();
            long bearing = Math.round(Float.parseFloat(vehicleActivity.getMonitoredVehicleJourney().getBearing()));
            Bitmap bitmap = getMarkerBitmap(lineRef, bearing, 50);
            MarkerOptions markerOptions = new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromBitmap(bitmap))
                    .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                    .position(latLng);
            marker = mMap.addMarker(markerOptions);
            vehicleActivityMarkers.add(marker);
            vehicleActivityIndexedByMarkerId.put(marker.getId(), vehicleActivity);
        }
        Log.i("sizeVehicleMarker", String.valueOf(vehicleActivityMarkers.size()));
    }
    private Bitmap getMarkerBitmap(String lineCode, long bearing, int width) {


        Bitmap returnedBitmap = Bitmap.createBitmap(width, width,
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        int px = width / 2;
        int py = width / 2;

        int radius = Math.min(px, py);
        Resources r = this.getResources();

        Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(r.getColor(R.color.circle_color));
        circlePaint.setStrokeWidth(1);
        circlePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        Paint headerCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        headerCirclePaint.setColor(r.getColor(R.color.header_circle_color));
        headerCirclePaint.setStrokeWidth(1);
        headerCirclePaint.setStyle(Paint.Style.FILL);

        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(r.getColor(R.color.text_color));

        canvas.drawCircle(px, py, radius, circlePaint);
        canvas.rotate(bearing, px, py);
        int arrowheaderRadius = (int)(1.0 * radius/ 10.0);
        canvas.drawCircle(px, arrowheaderRadius, arrowheaderRadius, headerCirclePaint);
        float tilt = (float)  (2.0 * 18 / Math.PI );
        canvas.rotate(- tilt, px, py);
        canvas.drawCircle(px, arrowheaderRadius, arrowheaderRadius, headerCirclePaint);
        canvas.rotate(2*tilt, px, py);
        canvas.drawCircle(px, arrowheaderRadius, arrowheaderRadius, headerCirclePaint);
        canvas.rotate(-tilt, px, py);
        headerCirclePaint.setStrokeWidth(1);
        headerCirclePaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(px, py, radius - 2 * arrowheaderRadius, headerCirclePaint);
        canvas.save();
        canvas.rotate(- bearing, px, py);
        textPaint.setTextSize(getSuitableFontSize(lineCode, radius));
        Rect bounds = new Rect();
        textPaint.getTextBounds(lineCode, 0, lineCode.length(), bounds);
        int textWidth = Math.abs(bounds.left - bounds.right);
        int textHeight = Math.abs(bounds.bottom - bounds.top);
        int cardinalX = px - textWidth / 2;
        int cardinalY = py + textHeight / 2;
        canvas.drawText(lineCode, cardinalX, cardinalY, textPaint);
        canvas.restore();
        canvas.save();
        return returnedBitmap;
    }

    private int getSuitableFontSize(String text, int radius){
        int fontSize;
        if (text.length() == 1) {
            fontSize = (int)(radius * 1.3);
        } else if (text.length() == 2){
            fontSize = (int)(radius * 1);
        } else if (text.length() == 3){
            fontSize =  (int)(radius * 0.8);
        } else {
            fontSize = (int)(radius * 0.6);
        }
        return fontSize;

    }

    /*private class VehicleActivityReader extends AsyncTask<VehicleActivity, Void, VehicleActivities> {

        VehicleActivities vehicleActivities;

        @Override
        protected VehicleActivities doInBackground(VehicleActivity... vehicleActivities) {
            VehicleActivity vehicleActivity = vehicleActivities[0];
            String vehicleRef = vehicleActivity.getMonitoredVehicleJourney().getVehicleRef().getValue();
            ApiInterface ApiService = ApiClient.getClient().create(ApiInterface.class);
            Call<VehicleActivities> call = ApiService.getDetailedActivity(vehicleRef);
            call.enqueue(new Callback<VehicleActivities>() {
                @Override
                public void onResponse(Call<VehicleActivities> call, Response<VehicleActivities> response) {
                    VehicleActivityReader.this.vehicleActivities = response.body();
                }

                @Override
                public void onFailure(Call<VehicleActivities> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });
            return this.vehicleActivities;
        }

        @Override
        protected void onPostExecute(VehicleActivities vehicleActivities) {
            super.onPostExecute(vehicleActivities);
        }
    } */

    private Runnable runnablecode = new Runnable() {
        ApiInterface ApiService = ApiClient.getClient().create(ApiInterface.class);
        List<VehicleActivity> vehicleActivityList;
        @Override
        public void run() {
            if (mMap == null || mCurrentLatLng == null){
                handler.postDelayed(runnablecode, 500);
                return;
            }
            LatLngBounds mapbound = mMap.getProjection().getVisibleRegion().latLngBounds;

            // Draw StopPoint markers
            if(mBusPointsNeedsRedraw){
            String location = ApiUtil.getStringBoundFromLatLngBound(mapbound);
            Call<StopPoints> call = ApiService.getStopPointResponse(location);
            Log.i("StopPoints Request ", call.request().toString());
            call.enqueue(new Callback<StopPoints>() {
                @Override
                public void onResponse(Call<StopPoints> call, Response<StopPoints> response) {
                    int statusCode = response.code();
                    mNearbyStopsList = response.body().getStopPoint();

                }
                @Override
                public void onFailure(Call<StopPoints> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });
            if(mNearbyStopsList != null) {
                Log.i("stopPoints", String.valueOf(mNearbyStopsList.size()));
                addStopPointMarkers(mNearbyStopsList);
            }
           // mBusPointsNeedsRedraw = false;
            }

            // end of StopPoint marker drawing

            // Draw Lines Marker
/*   Drawing using Siri Info
            SiriApiInterface siriApiService = SiriApiClient.getClient().create(SiriApiInterface.class);
                       
                Call<Vehicles> call = siriApiService.getSiriResponse();
                Log.i("Request", call.request().toString());
                call.enqueue(new Callback<Vehicles>() {
                    @Override
                    public void onResponse(Call<Vehicles> call, Response<Vehicles> response) {
                        int statusCode = response.code();
                        Siri siri = response.body().getSiri();
                        ServiceDelivery serviceDelivery = siri.getServiceDelivery();
                        List<VehicleMonitoringDelivery> vehicleMonitoringDeliveryList = serviceDelivery.getVehicleMonitoringDelivery();
                        VehicleMonitoringDelivery vehicleMonitoringDelivery = vehicleMonitoringDeliveryList.get(0);
                        vehicleActivityList =  vehicleMonitoringDelivery.getVehicleActivity();
                        Log.i("vehicleAvtivityList", String.valueOf(vehicleActivityList.size()));
                    }
                    @Override
                    public void onFailure(Call<Vehicles> call, Throwable t) {
                        // Log error here since request failed
                        Log.e(TAG, t.toString());
                    }
                });
                
                if (vehicleActivityList != null){
                   addVehicleActivityMarker(vehicleActivityList);
                }*/

            ApiInterface ApiService = ApiClient.getClient().create(ApiInterface.class);
            Call<VehicleActivities> call = ApiService.getDetailedActivity();
            Log.i("Request", call.request().toString());
            call.enqueue(new Callback<VehicleActivities>() {
                @Override
                public void onResponse(Call<VehicleActivities> call, Response<VehicleActivities> response) {
                    vehicleActivities = response.body();
                    vehicleActivityList = vehicleActivities.getVehicleActivity();
                    Log.i("vehicleAvtivityList", String.valueOf(vehicleActivityList.size()));
                }

                @Override
                public void onFailure(Call<VehicleActivities> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });
            if (vehicleActivityList != null){
                addVehicleActivityMarker(vehicleActivityList);
            }

            if(!mPause) {
                handler.postDelayed(this, 2500);
            }


        }
    };


    @Override
    public void onListFragmentInteraction(Object item) {

    }

    //************** Life Cycle methods
    @Override
    protected void onStart() {
        if(mGoogleApiClient!=null){
            mGoogleApiClient.connect();
        }
        super.onStart();
    }

    @Override
    protected void onStop() {
        if(mGoogleApiClient!=null){
            if(mGoogleApiClient.isConnected()){
                mGoogleApiClient.disconnect();
            }
        }

        super.onStop();
    }

    @Override
    protected void onPause() {
        mPause = true;
        super.onPause();
    }
}
