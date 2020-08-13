package com.example.programmer.tamperelinjat.recyclerviews.journeypattern;

import com.example.programmer.tamperelinjat.model.detailedvehicleactivity.VehicleActivity;
import com.example.programmer.tamperelinjat.model.journeypattern.StopPoint;
import com.example.programmer.tamperelinjat.model.journeys.Call;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class StopsInfoObject {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Object> ITEMS = new ArrayList<Object>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Object> ITEM_MAP = new HashMap<String, Object>();

    private static final int COUNT = 25;


    private static void addItem(Object item) {
        if (item instanceof StopPoint) {
           ITEM_MAP.put(((StopPoint) item).getShortName(), item);
            ITEMS.add(item);
        } else if (item instanceof String) {
            ITEM_MAP.put(((String) item).toString(), item);
            ITEMS.add(item);
        }
    }


    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }


}
