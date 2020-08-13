package com.example.programmer.tamperelinjat.model.stoppoint;

/**
 * Created by Programmer on 11/27/2017.
 */

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StopPoints implements Serializable, Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("body")
    @Expose
    private List<StopPoint> stopPoint = null;
    public final static Parcelable.Creator<StopPoints> CREATOR = new Creator<StopPoints>() {


        @SuppressWarnings({
                "unchecked"
        })
        public StopPoints createFromParcel(Parcel in) {
            return new StopPoints(in);
        }

        public StopPoints[] newArray(int size) {
            return (new StopPoints[size]);
        }

    }
            ;
    private final static long serialVersionUID = -3270582765462499894L;

    protected StopPoints(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
        in.readList(this.stopPoint, (StopPoint.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public StopPoints() {
    }

    /**
     *
     * @param stopPoint
     * @param status
     * @param data
     */
    public StopPoints(String status, Data data, List<StopPoint> stopPoint) {
        super();
        this.status = status;
        this.data = data;
        this.stopPoint = stopPoint;
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

    public List<StopPoint> getStopPoint() {
        return stopPoint;
    }

    public void setStopPoint(List<StopPoint> stopPoint) {
        this.stopPoint = stopPoint;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(data);
        dest.writeList(stopPoint);
    }

    public int describeContents() {
        return 0;
    }

}
