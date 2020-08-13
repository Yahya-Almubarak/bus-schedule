package com.example.programmer.tamperelinjat.util;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by Programmer on 11/26/2017.
 */

public class BottomNavigationViewExHelper {
    private static final String TAG = "com.example.programmer.tamperelinjat.util.BottomNavigationViewExHelper";

    public static void setupBottomNavigationViewEx(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }
}
