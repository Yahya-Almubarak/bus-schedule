package com.example.programmer.tamperelinjat.recyclerviews.departures;

import com.example.programmer.tamperelinjat.model.journeys.Body;
import com.example.programmer.tamperelinjat.model.stoppoint.StopPoint;

/**
 * Created by Programmer on 12/2/2017.
 */

public class Departure {
    private String line;
    private String headSign;
    private String arrivalTime;
    private Body body;

    public Departure(String line, String headSign, String arrivalTime, Body body) {
        this.line = line;
        this.headSign = headSign;
        this.arrivalTime = arrivalTime;
        this.body = body;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getHeadSign() {
        return headSign;
    }

    public void setHeadSign(String headSign) {
        this.headSign = headSign;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
