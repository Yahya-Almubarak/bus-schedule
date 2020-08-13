package com.example.programmer.tamperelinjat.model.journeys;

/**
 * Created by Programmer on 11/27/2017.
 */

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Call implements Serializable, Parcelable
{

    @SerializedName("arrivalTime")
    @Expose
    private String arrivalTime;
    @SerializedName("departureTime")
    @Expose
    private String departureTime;
    @SerializedName("stopPoint")
    @Expose
    private StopPoint stopPoint;
    public final static Parcelable.Creator<Call> CREATOR = new Creator<Call>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Call createFromParcel(Parcel in) {
            return new Call(in);
        }

        public Call[] newArray(int size) {
            return (new Call[size]);
        }

    }
            ;
    private final static long serialVersionUID = -8763214891037018515L;

    protected Call(Parcel in) {
        this.arrivalTime = ((String) in.readValue((String.class.getClassLoader())));
        this.departureTime = ((String) in.readValue((String.class.getClassLoader())));
        this.stopPoint = ((StopPoint) in.readValue((StopPoint.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Call() {
    }

    /**
     *
     * @param arrivalTime
     * @param departureTime
     * @param stopPoint
     */
    public Call(String arrivalTime, String departureTime, StopPoint stopPoint) {
        super();
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stopPoint = stopPoint;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public StopPoint getStopPoint() {
        return stopPoint;
    }

    public void setStopPoint(StopPoint stopPoint) {
        this.stopPoint = stopPoint;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(arrivalTime);
        dest.writeValue(departureTime);
        dest.writeValue(stopPoint);
    }

    public int describeContents() {
        return 0;
    }

}
