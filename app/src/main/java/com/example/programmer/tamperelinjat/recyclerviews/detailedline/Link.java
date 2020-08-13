package com.example.programmer.tamperelinjat.recyclerviews.detailedline;

import com.example.programmer.tamperelinjat.model.stoppoint.StopPoint;

/**
 * Created by Programmer on 12/2/2017.
 */

public class Link {
    private StopPoint stopPoint;
    private String  timeTableUrl;

    public Link(StopPoint stopPoint) {
        this.stopPoint = stopPoint;
        // Todo get timeTable Link from TRE Api
    }

    public StopPoint getStopPoint() {
        return stopPoint;
    }

    public void setStopPoint(StopPoint stopPoint) {
        this.stopPoint = stopPoint;
    }

    public String getTimeTableUrl() {
        return timeTableUrl;
    }

    public void setTimeTableUrl(String timeTableUrl) {
        this.timeTableUrl = timeTableUrl;
    }
}
