package com.example.programmer.tamperelinjat.model.journeypattern;

/**
 * Created by Programmer on 11/27/2017.
 */

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JourneyPatterns implements Serializable, Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("body")
    @Expose
    private List<JournyPattern> journyPattern = null;
    public final static Parcelable.Creator<JourneyPatterns> CREATOR = new Creator<JourneyPatterns>() {


        @SuppressWarnings({
                "unchecked"
        })
        public JourneyPatterns createFromParcel(Parcel in) {
            return new JourneyPatterns(in);
        }

        public JourneyPatterns[] newArray(int size) {
            return (new JourneyPatterns[size]);
        }

    }
            ;
    private final static long serialVersionUID = 6385394167661825888L;

    protected JourneyPatterns(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
        in.readList(this.journyPattern, (JournyPattern.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public JourneyPatterns() {
    }

    /**
     *
     * @param journyPattern
     * @param status
     * @param data
     */
    public JourneyPatterns(String status, Data data, List<JournyPattern> journyPattern) {
        super();
        this.status = status;
        this.data = data;
        this.journyPattern = journyPattern;
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

    public List<JournyPattern> getJournyPattern() {
        return journyPattern;
    }

    public void setJournyPattern(List<JournyPattern> journyPattern) {
        this.journyPattern = journyPattern;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(data);
        dest.writeList(journyPattern);
    }

    public int describeContents() {
        return 0;
    }

}
