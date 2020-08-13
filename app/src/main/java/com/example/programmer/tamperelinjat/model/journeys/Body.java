package com.example.programmer.tamperelinjat.model.journeys;

/**
 * Created by Programmer on 11/27/2017.
 */

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Body implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("activityUrl")
    @Expose
    private String activityUrl;
    @SerializedName("routeUrl")
    @Expose
    private String routeUrl;
    @SerializedName("lineUrl")
    @Expose
    private String lineUrl;
    @SerializedName("journeyPatternUrl")
    @Expose
    private String journeyPatternUrl;
    @SerializedName("departureTime")
    @Expose
    private String departureTime;
    @SerializedName("arrivalTime")
    @Expose
    private String arrivalTime;
    @SerializedName("headSign")
    @Expose
    private String headSign;
    @SerializedName("directionId")
    @Expose
    private String directionId;
    @SerializedName("wheelchairAccessible")
    @Expose
    private boolean wheelchairAccessible;
    @SerializedName("gtfs")
    @Expose
    private Gtfs gtfs;
    @SerializedName("dayTypes")
    @Expose
    private List<String> dayTypes = null;
    @SerializedName("dayTypeExceptions")
    @Expose
    private List<DayTypeException> dayTypeExceptions = null;
    @SerializedName("calls")
    @Expose
    private List<Call> calls = null;
    public final static Parcelable.Creator<Body> CREATOR = new Creator<Body>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Body createFromParcel(Parcel in) {
            return new Body(in);
        }

        public Body[] newArray(int size) {
            return (new Body[size]);
        }

    }
            ;
    private final static long serialVersionUID = -7140263414389222737L;

    protected Body(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.activityUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.routeUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.lineUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.journeyPatternUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.departureTime = ((String) in.readValue((String.class.getClassLoader())));
        this.arrivalTime = ((String) in.readValue((String.class.getClassLoader())));
        this.headSign = ((String) in.readValue((String.class.getClassLoader())));
        this.directionId = ((String) in.readValue((String.class.getClassLoader())));
        this.wheelchairAccessible = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.gtfs = ((Gtfs) in.readValue((Gtfs.class.getClassLoader())));
        in.readList(this.dayTypes, (java.lang.String.class.getClassLoader()));
        in.readList(this.dayTypeExceptions, (com.example.programmer.tamperelinjat.model.journeys.DayTypeException.class.getClassLoader()));
        in.readList(this.calls, (com.example.programmer.tamperelinjat.model.journeys.Call.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Body() {
    }

    /**
     *
     * @param activityUrl
     * @param routeUrl
     * @param directionId
     * @param gtfs
     * @param departureTime
     * @param wheelchairAccessible
     * @param lineUrl
     * @param calls
     * @param url
     * @param journeyPatternUrl
     * @param arrivalTime
     * @param dayTypeExceptions
     * @param headSign
     * @param dayTypes
     */
    public Body(String url, String activityUrl, String routeUrl, String lineUrl, String journeyPatternUrl, String departureTime, String arrivalTime, String headSign, String directionId, boolean wheelchairAccessible, Gtfs gtfs, List<String> dayTypes, List<DayTypeException> dayTypeExceptions, List<Call> calls) {
        super();
        this.url = url;
        this.activityUrl = activityUrl;
        this.routeUrl = routeUrl;
        this.lineUrl = lineUrl;
        this.journeyPatternUrl = journeyPatternUrl;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.headSign = headSign;
        this.directionId = directionId;
        this.wheelchairAccessible = wheelchairAccessible;
        this.gtfs = gtfs;
        this.dayTypes = dayTypes;
        this.dayTypeExceptions = dayTypeExceptions;
        this.calls = calls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getActivityUrl() {
        return activityUrl;
    }

    public void setActivityUrl(String activityUrl) {
        this.activityUrl = activityUrl;
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

    public String getJourneyPatternUrl() {
        return journeyPatternUrl;
    }

    public void setJourneyPatternUrl(String journeyPatternUrl) {
        this.journeyPatternUrl = journeyPatternUrl;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getHeadSign() {
        return headSign;
    }

    public void setHeadSign(String headSign) {
        this.headSign = headSign;
    }

    public String getDirectionId() {
        return directionId;
    }

    public void setDirectionId(String directionId) {
        this.directionId = directionId;
    }

    public boolean isWheelchairAccessible() {
        return wheelchairAccessible;
    }

    public void setWheelchairAccessible(boolean wheelchairAccessible) {
        this.wheelchairAccessible = wheelchairAccessible;
    }

    public Gtfs getGtfs() {
        return gtfs;
    }

    public void setGtfs(Gtfs gtfs) {
        this.gtfs = gtfs;
    }

    public List<String> getDayTypes() {
        return dayTypes;
    }

    public void setDayTypes(List<String> dayTypes) {
        this.dayTypes = dayTypes;
    }

    public List<DayTypeException> getDayTypeExceptions() {
        return dayTypeExceptions;
    }

    public void setDayTypeExceptions(List<DayTypeException> dayTypeExceptions) {
        this.dayTypeExceptions = dayTypeExceptions;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(activityUrl);
        dest.writeValue(routeUrl);
        dest.writeValue(lineUrl);
        dest.writeValue(journeyPatternUrl);
        dest.writeValue(departureTime);
        dest.writeValue(arrivalTime);
        dest.writeValue(headSign);
        dest.writeValue(directionId);
        dest.writeValue(wheelchairAccessible);
        dest.writeValue(gtfs);
        dest.writeList(dayTypes);
        dest.writeList(dayTypeExceptions);
        dest.writeList(calls);
    }

    public int describeContents() {
        return 0;
    }

}
