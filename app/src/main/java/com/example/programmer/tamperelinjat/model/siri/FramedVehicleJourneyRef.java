package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FramedVehicleJourneyRef implements Serializable, Parcelable
{

    @SerializedName("DataFrameRef")
    @Expose
    private DataFrameRef dataFrameRef;
    @SerializedName("DatedVehicleJourneyRef")
    @Expose
    private String datedVehicleJourneyRef;
    public final static Creator<FramedVehicleJourneyRef> CREATOR = new Creator<FramedVehicleJourneyRef>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FramedVehicleJourneyRef createFromParcel(Parcel in) {
            return new FramedVehicleJourneyRef(in);
        }

        public FramedVehicleJourneyRef[] newArray(int size) {
            return (new FramedVehicleJourneyRef[size]);
        }

    }
            ;
    private final static long serialVersionUID = 4663798801504803291L;

    protected FramedVehicleJourneyRef(Parcel in) {
        this.dataFrameRef = ((DataFrameRef) in.readValue((DataFrameRef.class.getClassLoader())));
        this.datedVehicleJourneyRef = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public FramedVehicleJourneyRef() {
    }

    /**
     *
     * @param datedVehicleJourneyRef
     * @param dataFrameRef
     */
    public FramedVehicleJourneyRef(DataFrameRef dataFrameRef, String datedVehicleJourneyRef) {
        super();
        this.dataFrameRef = dataFrameRef;
        this.datedVehicleJourneyRef = datedVehicleJourneyRef;
    }

    public DataFrameRef getDataFrameRef() {
        return dataFrameRef;
    }

    public void setDataFrameRef(DataFrameRef dataFrameRef) {
        this.dataFrameRef = dataFrameRef;
    }

    public String getDatedVehicleJourneyRef() {
        return datedVehicleJourneyRef;
    }

    public void setDatedVehicleJourneyRef(String datedVehicleJourneyRef) {
        this.datedVehicleJourneyRef = datedVehicleJourneyRef;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dataFrameRef);
        dest.writeValue(datedVehicleJourneyRef);
    }

    public int describeContents() {
        return 0;
    }

}