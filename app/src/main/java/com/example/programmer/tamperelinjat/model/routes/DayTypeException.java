package com.example.programmer.tamperelinjat.model.routes;

/**
 * Created by Programmer on 11/27/2017.
 */


import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DayTypeException implements Serializable, Parcelable
{

    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("runs")
    @Expose
    private String runs;
    public final static Parcelable.Creator<DayTypeException> CREATOR = new Creator<DayTypeException>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DayTypeException createFromParcel(Parcel in) {
            return new DayTypeException(in);
        }

        public DayTypeException[] newArray(int size) {
            return (new DayTypeException[size]);
        }

    }
            ;
    private final static long serialVersionUID = 7062807312530771543L;

    protected DayTypeException(Parcel in) {
        this.from = ((String) in.readValue((String.class.getClassLoader())));
        this.to = ((String) in.readValue((String.class.getClassLoader())));
        this.runs = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public DayTypeException() {
    }

    /**
     *
     * @param to
     * @param runs
     * @param from
     */
    public DayTypeException(String from, String to, String runs) {
        super();
        this.from = from;
        this.to = to;
        this.runs = runs;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(from);
        dest.writeValue(to);
        dest.writeValue(runs);
    }

    public int describeContents() {
        return 0;
    }

}
