package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Vehicles implements Serializable, Parcelable
{

    @SerializedName("Siri")
    @Expose
    private Siri siri;
    public final static Creator<Vehicles> CREATOR = new Creator<Vehicles>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Vehicles createFromParcel(Parcel in) {
            return new Vehicles(in);
        }

        public Vehicles[] newArray(int size) {
            return (new Vehicles[size]);
        }

    }
            ;
    private final static long serialVersionUID = -3526686686103751409L;

    protected Vehicles(Parcel in) {
        this.siri = ((Siri) in.readValue((Siri.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Vehicles() {
    }

    /**
     *
     * @param siri
     */
    public Vehicles(Siri siri) {
        super();
        this.siri = siri;
    }

    public Siri getSiri() {
        return siri;
    }

    public void setSiri(Siri siri) {
        this.siri = siri;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(siri);
    }

    public int describeContents() {
        return 0;
    }

}