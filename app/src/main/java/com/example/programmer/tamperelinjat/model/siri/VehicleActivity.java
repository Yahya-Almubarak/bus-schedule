package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VehicleActivity implements Serializable, Parcelable
{

    @SerializedName("ValidUntilTime")
    @Expose
    private long validUntilTime;
    @SerializedName("MonitoredVehicleJourney")
    @Expose
    private MonitoredVehicleJourney monitoredVehicleJourney;
    @SerializedName("RecordedAtTime")
    @Expose
    private long recordedAtTime;
    public final static Creator<VehicleActivity> CREATOR = new Creator<VehicleActivity>() {


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
    private final static long serialVersionUID = -4738190893256577481L;

    protected VehicleActivity(Parcel in) {
        this.validUntilTime = ((long) in.readValue((long.class.getClassLoader())));
        this.monitoredVehicleJourney = ((MonitoredVehicleJourney) in.readValue((MonitoredVehicleJourney.class.getClassLoader())));
        this.recordedAtTime = ((long) in.readValue((long.class.getClassLoader())));
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
    public VehicleActivity(long validUntilTime, MonitoredVehicleJourney monitoredVehicleJourney, long recordedAtTime) {
        super();
        this.validUntilTime = validUntilTime;
        this.monitoredVehicleJourney = monitoredVehicleJourney;
        this.recordedAtTime = recordedAtTime;
    }

    public long getValidUntilTime() {
        return validUntilTime;
    }

    public void setValidUntilTime(long validUntilTime) {
        this.validUntilTime = validUntilTime;
    }

    public MonitoredVehicleJourney getMonitoredVehicleJourney() {
        return monitoredVehicleJourney;
    }

    public void setMonitoredVehicleJourney(MonitoredVehicleJourney monitoredVehicleJourney) {
        this.monitoredVehicleJourney = monitoredVehicleJourney;
    }

    public long getRecordedAtTime() {
        return recordedAtTime;
    }

    public void setRecordedAtTime(long recordedAtTime) {
        this.recordedAtTime = recordedAtTime;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(validUntilTime);
        dest.writeValue(monitoredVehicleJourney);
        dest.writeValue(recordedAtTime);
    }

    public int describeContents() {
        return 0;
    }

}