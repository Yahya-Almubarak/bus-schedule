package com.example.programmer.tamperelinjat.model.lines;

/**
 * Created by Programmer on 11/27/2017.
 */

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lines implements Serializable, Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("body")
    @Expose
    private List<Line> body = null;
    public final static Parcelable.Creator<Lines> CREATOR = new Creator<Lines>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Lines createFromParcel(Parcel in) {
            return new Lines(in);
        }

        public Lines[] newArray(int size) {
            return (new Lines[size]);
        }

    }
            ;
    private final static long serialVersionUID = -1696176484279203030L;

    protected Lines(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
        in.readList(this.body, (Line.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Lines() {
    }

    /**
     *
     * @param body
     * @param status
     * @param data
     */
    public Lines(String status, Data data, List<Line> body) {
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

    public List<Line> getBody() {
        return body;
    }

    public void setBody(List<Line> body) {
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
