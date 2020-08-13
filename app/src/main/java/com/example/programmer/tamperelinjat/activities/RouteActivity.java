package com.example.programmer.tamperelinjat.activities;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.programmer.tamperelinjat.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RouteActivity extends AppCompatActivity implements RouteSearchFragment.OnFragmentInteractionListener{
    private static final String TAG = RouteActivity.class.getSimpleName();
    List<String> addressesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationViewEx bnve = (BottomNavigationViewEx) findViewById(R.id.navigation);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);
        bnve.enableAnimation(false);

        populateSearchView();
    }


    private void readAddresses() {
        Resources resources = getResources();
        InputStream inputStream = resources.openRawResource(R.raw.addresses);
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()){
            addressesList.add(scanner.nextLine());
        }


    }

    private void populateSearchView() {
        Fragment fragment = new RouteSearchFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_layout_first_holder, fragment, TAG);
        fragmentTransaction.commit();
    }

    public void searchRoute(View view){
        Log.i("RouteActivity", "Button Clicked");
        readAddresses();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
