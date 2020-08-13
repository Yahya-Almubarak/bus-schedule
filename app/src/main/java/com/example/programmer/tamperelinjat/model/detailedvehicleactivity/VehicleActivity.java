package com.example.programmer.tamperelinjat.model.detailedvehicleactivity;

/**
 * Created by Programmer on 11/30/2017.
 */

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehicleActivity implements Serializable, Parcelable
{

    @SerializedName("recordedAtTime")
    @Expose
    private String recordedAtTime;
    @SerializedName("validUntilTime")
    @Expose
    private String validUntilTime;
    @SerializedName("monitoredVehicleJourney")
    @Expose
    private MonitoredVehicleJourney monitoredVehicleJourney;
    public final static Parcelable.Creator<VehicleActivity> CREATOR = new Creator<VehicleActivity>() {


        @SuppressWarnings({
                "unchecked"
        })
        public VehicleActivity createFromParcel(Parcel in) {
            return new VehicleActivity(in);
        }

        public VehicleActivity[] newArray(int size) {
            return (new VehicleActivity[size]);
        }

    }
            ;
    private final static long serialVersionUID = 7038942789776918287L;

    protected VehicleActivity(Parcel in) {
        this.recordedAtTime = ((String) in.readValue((String.class.getClassLoader())));
        this.validUntilTime = ((String) in.readValue((String.class.getClassLoader())));
        this.monitoredVehicleJourney = ((MonitoredVehicleJourney) in.readValue((MonitoredVehicleJourney.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public VehicleActivity() {
    }

    /**
     *
     * @param monitoredVehicleJourney
     * @param recordedAtTime
     * @param validUntilTime
     */
    public VehicleActivity(String recordedAtTime, String validUntilTime, MonitoredVehicleJourney monitoredVehicleJourney) {
        super();
        this.recordedAtTime = recordedAtTime;
        this.validUntilTime = validUntilTime;
        this.monitoredVehicleJourney = monitoredVehicleJourney;
    }

    public String getRecordedAtTime() {
        return recordedAtTime;
    }

    public void setRecordedAtTime(String recordedAtTime) {
        this.recordedAtTime = recordedAtTime;
    }

    public String getValidUntilTime() {
        return validUntilTime;
    }

    public void setValidUntilTime(String validUntilTime) {
        this.validUntilTime = validUntilTime;
    }

    public MonitoredVehicleJourney getMonitoredVehicleJourney() {
        return monitoredVehicleJourney;
    }

    public void setMonitoredVehicleJourney(MonitoredVehicleJourney monitoredVehicleJourney) {
        this.monitoredVehicleJourney = monitoredVehicleJourney;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(recordedAtTime);
        dest.writeValue(validUntilTime);
        dest.writeValue(monitoredVehicleJourney);
    }

    public int describeContents() {
        return 0;
    }

}