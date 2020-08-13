package com.example.programmer.tamperelinjat.model.journeys;

/**
 * Created by Programmer on 11/27/2017.
 */

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Journeys implements Serializable, Parcelable
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
    public final static Parcelable.Creator<Journeys> CREATOR = new Creator<Journeys>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Journeys createFromParcel(Parcel in) {
            return new Journeys(in);
        }

        public Journeys[] newArray(int size) {
            return (new Journeys[size]);
        }

    }
            ;
    private final static long serialVersionUID = 9002516864167578816L;

    protected Journeys(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
        in.readList(this.body, (com.example.programmer.tamperelinjat.model.journeys.Body.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Journeys() {
    }

    /**
     *
     * @param body
     * @param status
     * @param data
     */
    public Journeys(String status, Data data, List<Body> body) {
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
