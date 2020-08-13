package com.example.programmer.tamperelinjat.model.detailedvehicleactivity;

/**
 * Created by Programmer on 11/30/2017.
 */

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OnwardCall implements Serializable, Parcelable
{

    @SerializedName("expectedArrivalTime")
    @Expose
    private String expectedArrivalTime;
    @SerializedName("expectedDepartureTime")
    @Expose
    private String expectedDepartureTime;
    @SerializedName("stopPointRef")
    @Expose
    private String stopPointRef;
    @SerializedName("order")
    @Expose
    private String order;
    public final static Parcelable.Creator<OnwardCall> CREATOR = new Creator<OnwardCall>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OnwardCall createFromParcel(Parcel in) {
            return new OnwardCall(in);
        }

        public OnwardCall[] newArray(int size) {
            return (new OnwardCall[size]);
        }

    }
            ;
    private final static long serialVersionUID = 5507895241159816667L;

    protected OnwardCall(Parcel in) {
        this.expectedArrivalTime = ((String) in.readValue((String.class.getClassLoader())));
        this.expectedDepartureTime = ((String) in.readValue((String.class.getClassLoader())));
        this.stopPointRef = ((String) in.readValue((String.class.getClassLoader())));
        this.order = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public OnwardCall() {
    }

    /**
     *
     * @param expectedArrivalTime
     * @param expectedDepartureTime
     * @param order
     * @param stopPointRef
     */
    public OnwardCall(String expectedArrivalTime, String expectedDepartureTime, String stopPointRef, String order) {
        super();
        this.expectedArrivalTime = expectedArrivalTime;
        this.expectedDepartureTime = expectedDepartureTime;
        this.stopPointRef = stopPointRef;
        this.order = order;
    }

    public String getExpectedArrivalTime() {
        return expectedArrivalTime;
    }

    public void setExpectedArrivalTime(String expectedArrivalTime) {
        this.expectedArrivalTime = expectedArrivalTime;
    }

    public String getExpectedDepartureTime() {
        return expectedDepartureTime;
    }

    public void setExpectedDepartureTime(String expectedDepartureTime) {
        this.expectedDepartureTime = expectedDepartureTime;
    }

    public String getStopPointRef() {
        return stopPointRef;
    }

    public void setStopPointRef(String stopPointRef) {
        this.stopPointRef = stopPointRef;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(expectedArrivalTime);
        dest.writeValue(expectedDepartureTime);
        dest.writeValue(stopPointRef);
        dest.writeValue(order);
    }

    public int describeContents() {
        return 0;
    }

}