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

public class FramedVehicleJourneyRef implements Serializable, Parcelable
{

    @SerializedName("dateFrameRef")
    @Expose
    private String dateFrameRef;
    @SerializedName("datedVehicleJourneyRef")
    @Expose
    private String datedVehicleJourneyRef;
    public final static Parcelable.Creator<FramedVehicleJourneyRef> CREATOR = new Creator<FramedVehicleJourneyRef>() {


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
    private final static long serialVersionUID = 6470159493261326463L;

    protected FramedVehicleJourneyRef(Parcel in) {
        this.dateFrameRef = ((String) in.readValue((String.class.getClassLoader())));
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
     * @param dateFrameRef
     */
    public FramedVehicleJourneyRef(String dateFrameRef, String datedVehicleJourneyRef) {
        super();
        this.dateFrameRef = dateFrameRef;
        this.datedVehicleJourneyRef = datedVehicleJourneyRef;
    }

    public String getDateFrameRef() {
        return dateFrameRef;
    }

    public void setDateFrameRef(String dateFrameRef) {
        this.dateFrameRef = dateFrameRef;
    }

    public String getDatedVehicleJourneyRef() {
        return datedVehicleJourneyRef;
    }

    public void setDatedVehicleJourneyRef(String datedVehicleJourneyRef) {
        this.datedVehicleJourneyRef = datedVehicleJourneyRef;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dateFrameRef);
        dest.writeValue(datedVehicleJourneyRef);
    }

    public int describeContents() {
        return 0;
    }

}
