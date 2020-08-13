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

public class VehicleLocation implements Serializable, Parcelable
{

    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    public final static Parcelable.Creator<VehicleLocation> CREATOR = new Creator<VehicleLocation>() {


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
    private final static long serialVersionUID = 4503780281459918982L;

    protected VehicleLocation(Parcel in) {
        this.longitude = ((String) in.readValue((String.class.getClassLoader())));
        this.latitude = ((String) in.readValue((String.class.getClassLoader())));
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
    public VehicleLocation(String longitude, String latitude) {
        super();
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
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