package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class VehicleMonitoringDelivery implements Serializable, Parcelable
{

    @SerializedName("VehicleActivity")
    @Expose
    private List<VehicleActivity> vehicleActivity = null;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("ResponseTimestamp")
    @Expose
    private long responseTimestamp;
    @SerializedName("Status")
    @Expose
    private boolean status;
    public final static Creator<VehicleMonitoringDelivery> CREATOR = new Creator<VehicleMonitoringDelivery>() {


        @SuppressWarnings({
                "unchecked"
        })
        public VehicleMonitoringDelivery createFromParcel(Parcel in) {
            return new VehicleMonitoringDelivery(in);
        }

        public VehicleMonitoringDelivery[] newArray(int size) {
            return (new VehicleMonitoringDelivery[size]);
        }

    }
            ;
    private final static long serialVersionUID = 6847475206327754523L;

    protected VehicleMonitoringDelivery(Parcel in) {
        in.readList(this.vehicleActivity, (com.example.programmer.tamperelinjat.model.siri.VehicleActivity.class.getClassLoader()));
        this.version = ((String) in.readValue((String.class.getClassLoader())));
        this.responseTimestamp = ((long) in.readValue((long.class.getClassLoader())));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public VehicleMonitoringDelivery() {
    }

    /**
     *
     * @param status
     * @param vehicleActivity
     * @param responseTimestamp
     * @param version
     */
    public VehicleMonitoringDelivery(List<VehicleActivity> vehicleActivity, String version, long responseTimestamp, boolean status) {
        super();
        this.vehicleActivity = vehicleActivity;
        this.version = version;
        this.responseTimestamp = responseTimestamp;
        this.status = status;
    }

    public List<VehicleActivity> getVehicleActivity() {
        return vehicleActivity;
    }

    public void setVehicleActivity(List<VehicleActivity> vehicleActivity) {
        this.vehicleActivity = vehicleActivity;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getResponseTimestamp() {
        return responseTimestamp;
    }

    public void setResponseTimestamp(long responseTimestamp) {
        this.responseTimestamp = responseTimestamp;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(vehicleActivity);
        dest.writeValue(version);
        dest.writeValue(responseTimestamp);
        dest.writeValue(status);
    }

    public int describeContents() {
        return 0;
    }

}