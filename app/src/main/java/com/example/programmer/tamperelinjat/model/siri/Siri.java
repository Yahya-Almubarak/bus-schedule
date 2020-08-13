package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Siri implements Serializable, Parcelable
{

    @SerializedName("ServiceDelivery")
    @Expose
    private ServiceDelivery serviceDelivery;
    @SerializedName("version")
    @Expose
    private String version;
    public final static Creator<Siri> CREATOR = new Creator<Siri>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Siri createFromParcel(Parcel in) {
            return new Siri(in);
        }

        public Siri[] newArray(int size) {
            return (new Siri[size]);
        }

    }
            ;
    private final static long serialVersionUID = 703360775386309932L;

    protected Siri(Parcel in) {
        this.serviceDelivery = ((ServiceDelivery) in.readValue((ServiceDelivery.class.getClassLoader())));
        this.version = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Siri() {
    }

    /**
     *
     * @param serviceDelivery
     * @param version
     */
    public Siri(ServiceDelivery serviceDelivery, String version) {
        super();
        this.serviceDelivery = serviceDelivery;
        this.version = version;
    }

    public ServiceDelivery getServiceDelivery() {
        return serviceDelivery;
    }

    public void setServiceDelivery(ServiceDelivery serviceDelivery) {
        this.serviceDelivery = serviceDelivery;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(serviceDelivery);
        dest.writeValue(version);
    }

    public int describeContents() {
        return 0;
    }

}