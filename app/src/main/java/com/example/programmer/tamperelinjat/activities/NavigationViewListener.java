package com.example.programmer.tamperelinjat.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;

import com.example.programmer.tamperelinjat.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by Programmer on 11/26/2017.
 */

public class NavigationViewListener  implements BottomNavigationViewEx.OnNavigationItemSelectedListener  {

    private Context context;

    public NavigationViewListener(Context context){
        this.context = context;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_map:
                ((MainActivity) context).deployMap();
                return true;
            case R.id.navigation_lines:
                    ((Activity)context).startActivity(new Intent(context, LinesActivity.class));
                return true;
            case R.id.navigation_routes:
                ((Activity)context).startActivity(new Intent(context, RouteActivity.class));
                return true;
            case R.id.navigation_favorite:

                return true;
            case R.id.navigation_more:

                return true;
        }
        return false;
    }
}
