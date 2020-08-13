package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VehicleRef implements Serializable, Parcelable
{

    @SerializedName("value")
    @Expose
    private String value;
    public final static Creator<VehicleRef> CREATOR = new Creator<VehicleRef>() {


        @SuppressWarnings({
                "unchecked"
        })
        public VehicleRef createFromParcel(Parcel in) {
            return new VehicleRef(in);
        }

        public VehicleRef[] newArray(int size) {
            return (new VehicleRef[size]);
        }

    }
            ;
    private final static long serialVersionUID = -738335379722957666L;

    protected VehicleRef(Parcel in) {
        this.value = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public VehicleRef() {
    }

    /**
     *
     * @param value
     */
    public VehicleRef(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(value);
    }

    public int describeContents() {
        return 0;
    }

}