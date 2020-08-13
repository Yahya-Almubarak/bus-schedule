package com.example.programmer.tamperelinjat.model.detailedvehicleactivity;

/**
 * Created by Programmer on 11/30/2017.
 */

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehicleActivities implements Serializable, Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("body")
    @Expose
    private List<VehicleActivity> vehicleActivity = null;
    public final static Parcelable.Creator<VehicleActivities> CREATOR = new Creator<VehicleActivities>() {


        @SuppressWarnings({
                "unchecked"
        })
        public VehicleActivities createFromParcel(Parcel in) {
            return new VehicleActivities(in);
        }

        public VehicleActivities[] newArray(int size) {
            return (new VehicleActivities[size]);
        }

    }
            ;
    private final static long serialVersionUID = 5973700853337562531L;

    protected VehicleActivities(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
        in.readList(this.vehicleActivity, (VehicleActivity.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public VehicleActivities() {
    }

    /**
     *
     * @param vehicleActivity
     * @param status
     * @param data
     */
    public VehicleActivities(String status, Data data, List<VehicleActivity> vehicleActivity) {
        super();
        this.status = status;
        this.data = data;
        this.vehicleActivity = vehicleActivity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<VehicleActivity> getVehicleActivity() {
        return vehicleActivity;
    }

    public void setVehicleActivity(List<VehicleActivity> vehicleActivity) {
        this.vehicleActivity = vehicleActivity;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(data);
        dest.writeList(vehicleActivity);
    }

    public int describeContents() {
        return 0;
    }

}
