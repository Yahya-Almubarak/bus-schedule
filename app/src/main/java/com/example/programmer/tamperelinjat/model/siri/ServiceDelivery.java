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

public class ServiceDelivery implements Serializable, Parcelable
{

    @SerializedName("ResponseTimestamp")
    @Expose
    private long responseTimestamp;
    @SerializedName("ProducerRef")
    @Expose
    private ProducerRef producerRef;
    @SerializedName("Status")
    @Expose
    private boolean status;
    @SerializedName("MoreData")
    @Expose
    private boolean moreData;
    @SerializedName("VehicleMonitoringDelivery")
    @Expose
    private List<VehicleMonitoringDelivery> vehicleMonitoringDelivery = null;
    public final static Creator<ServiceDelivery> CREATOR = new Creator<ServiceDelivery>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ServiceDelivery createFromParcel(Parcel in) {
            return new ServiceDelivery(in);
        }

        public ServiceDelivery[] newArray(int size) {
            return (new ServiceDelivery[size]);
        }

    }
            ;
    private final static long serialVersionUID = -1414041461582094298L;

    protected ServiceDelivery(Parcel in) {
        this.responseTimestamp = ((long) in.readValue((long.class.getClassLoader())));
        this.producerRef = ((ProducerRef) in.readValue((ProducerRef.class.getClassLoader())));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.moreData = ((boolean) in.readValue((boolean.class.getClassLoader())));
        in.readList(this.vehicleMonitoringDelivery, (com.example.programmer.tamperelinjat.model.siri.VehicleMonitoringDelivery.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public ServiceDelivery() {
    }

    /**
     *
     * @param moreData
     * @param status
     * @param vehicleMonitoringDelivery
     * @param responseTimestamp
     * @param producerRef
     */
    public ServiceDelivery(long responseTimestamp, ProducerRef producerRef, boolean status, boolean moreData, List<VehicleMonitoringDelivery> vehicleMonitoringDelivery) {
        super();
        this.responseTimestamp = responseTimestamp;
        this.producerRef = producerRef;
        this.status = status;
        this.moreData = moreData;
        this.vehicleMonitoringDelivery = vehicleMonitoringDelivery;
    }

    public long getResponseTimestamp() {
        return responseTimestamp;
    }

    public void setResponseTimestamp(long responseTimestamp) {
        this.responseTimestamp = responseTimestamp;
    }

    public ProducerRef getProducerRef() {
        return producerRef;
    }

    public void setProducerRef(ProducerRef producerRef) {
        this.producerRef = producerRef;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isMoreData() {
        return moreData;
    }

    public void setMoreData(boolean moreData) {
        this.moreData = moreData;
    }

    public List<VehicleMonitoringDelivery> getVehicleMonitoringDelivery() {
        return vehicleMonitoringDelivery;
    }

    public void setVehicleMonitoringDelivery(List<VehicleMonitoringDelivery> vehicleMonitoringDelivery) {
        this.vehicleMonitoringDelivery = vehicleMonitoringDelivery;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(responseTimestamp);
        dest.writeValue(producerRef);
        dest.writeValue(status);
        dest.writeValue(moreData);
        dest.writeList(vehicleMonitoringDelivery);
    }

    public int describeContents() {
        return 0;
    }

}