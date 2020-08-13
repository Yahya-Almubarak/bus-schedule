package com.example.programmer.tamperelinjat.model.journeypattern;

/**
 * Created by Programmer on 11/27/2017.
 */

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gtfs implements Serializable, Parcelable
{

    @SerializedName("tripId")
    @Expose
    private String tripId;
    public final static Parcelable.Creator<Gtfs> CREATOR = new Creator<Gtfs>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Gtfs createFromParcel(Parcel in) {
            return new Gtfs(in);
        }

        public Gtfs[] newArray(int size) {
            return (new Gtfs[size]);
        }

    }
            ;
    private final static long serialVersionUID = -3524285082703014809L;

    protected Gtfs(Parcel in) {
        this.tripId = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Gtfs() {
    }

    /**
     *
     * @param tripId
     */
    public Gtfs(String tripId) {
        super();
        this.tripId = tripId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tripId);
    }

    public int describeContents() {
        return 0;
    }

}
