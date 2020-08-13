package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VehicleLocation implements Serializable, Parcelable
{

    @SerializedName("Longitude")
    @Expose
    private double longitude;
    @SerializedName("Latitude")
    @Expose
    private double latitude;
    public final static Creator<VehicleLocation> CREATOR = new Creator<VehicleLocation>() {


        @SuppressWarnings({
                "unchecked"
        })
        public VehicleLocation createFromParcel(Parcel in) {
            return new VehicleLocation(in);
        }

        public VehicleLocation[] newArray(int size) {
            return (new VehicleLocation[size]);
        }

    }
            ;
    private final static long serialVersionUID = -1640265998822537288L;

    protected VehicleLocation(Parcel in) {
        this.longitude = ((double) in.readValue((double.class.getClassLoader())));
        this.latitude = ((double) in.readValue((double.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public VehicleLocation() {
    }

    /**
     *
     * @param longitude
     * @param latitude
     */
    public VehicleLocation(double longitude, double latitude) {
        super();
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(longitude);
        dest.writeValue(latitude);
    }

    public int describeContents() {
        return 0;
    }

}