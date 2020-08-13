package com.example.programmer.tamperelinjat.model.journeypattern;

/**
 * Created by Programmer on 11/27/2017.
 */


import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JournyPattern implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("routeUrl")
    @Expose
    private String routeUrl;
    @SerializedName("lineUrl")
    @Expose
    private String lineUrl;
    @SerializedName("originStop")
    @Expose
    private String originStop;
    @SerializedName("destinationStop")
    @Expose
    private String destinationStop;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("stopPoints")
    @Expose
    private List<StopPoint> stopPoints = null;
    @SerializedName("journeys")
    @Expose
    private List<Journey> journeys = null;
    public final static Parcelable.Creator<JournyPattern> CREATOR = new Creator<JournyPattern>() {


        @SuppressWarnings({
                "unchecked"
        })
        public JournyPattern createFromParcel(Parcel in) {
            return new JournyPattern(in);
        }

        public JournyPattern[] newArray(int size) {
            return (new JournyPattern[size]);
        }

    }
            ;
    private final static long serialVersionUID = 1864228836091646062L;

    protected JournyPattern(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.routeUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.lineUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.originStop = ((String) in.readValue((String.class.getClassLoader())));
        this.destinationStop = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.direction = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.stopPoints, (com.example.programmer.tamperelinjat.model.journeypattern.StopPoint.class.getClassLoader()));
        in.readList(this.journeys, (com.example.programmer.tamperelinjat.model.journeypattern.Journey.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public JournyPattern() {
    }

    /**
     *
     * @param journeys
     * @param routeUrl
     * @param destinationStop
     * @param direction
     * @param name
     * @param stopPoints
     * @param originStop
     * @param lineUrl
     * @param url
     */
    public JournyPattern(String url, String routeUrl, String lineUrl, String originStop, String destinationStop, String name, String direction, List<StopPoint> stopPoints, List<Journey> journeys) {
        super();
        this.url = url;
        this.routeUrl = routeUrl;
        this.lineUrl = lineUrl;
        this.originStop = originStop;
        this.destinationStop = destinationStop;
        this.name = name;
        this.direction = direction;
        this.stopPoints = stopPoints;
        this.journeys = journeys;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRouteUrl() {
        return routeUrl;
    }

    public void setRouteUrl(String routeUrl) {
        this.routeUrl = routeUrl;
    }

    public String getLineUrl() {
        return lineUrl;
    }

    public void setLineUrl(String lineUrl) {
        this.lineUrl = lineUrl;
    }

    public String getOriginStop() {
        return originStop;
    }

    public void setOriginStop(String originStop) {
        this.originStop = originStop;
    }

    public String getDestinationStop() {
        return destinationStop;
    }

    public void setDestinationStop(String destinationStop) {
        this.destinationStop = destinationStop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<StopPoint> getStopPoints() {
        return stopPoints;
    }

    public void setStopPoints(List<StopPoint> stopPoints) {
        this.stopPoints = stopPoints;
    }

    public List<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(routeUrl);
        dest.writeValue(lineUrl);
        dest.writeValue(originStop);
        dest.writeValue(destinationStop);
        dest.writeValue(name);
        dest.writeValue(direction);
        dest.writeList(stopPoints);
        dest.writeList(journeys);
    }

    public int describeContents() {
        return 0;
    }

}
