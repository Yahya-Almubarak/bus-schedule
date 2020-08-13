package com.example.programmer.tamperelinjat.model.vehicleactivity;

/**
 * Created by Programmer on 11/27/2017.
 */

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StopPoint implements Serializable, Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("body")
    @Expose
    private List<Body> body = null;
    public final static Parcelable.Creator<StopPoint> CREATOR = new Creator<StopPoint>() {


        @SuppressWarnings({
                "unchecked"
        })
        public StopPoint createFromParcel(Parcel in) {
            return new StopPoint(in);
        }

        public StopPoint[] newArray(int size) {
            return (new StopPoint[size]);
        }

    }
            ;
    private final static long serialVersionUID = -3270582765462499894L;

    protected StopPoint(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
        in.readList(this.body, (com.example.programmer.tamperelinjat.model.stoppoint.StopPoint.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public StopPoint() {
    }

    /**
     *
     * @param body
     * @param status
     * @param data
     */
    public StopPoint(String status, Data data, List<Body> body) {
        super();
        this.status = status;
        this.data = data;
        this.body = body;
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

    public List<Body> getBody() {
        return body;
    }

    public void setBody(List<Body> body) {
        this.body = body;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(data);
        dest.writeList(body);
    }

    public int describeContents() {
        return 0;
    }

}
