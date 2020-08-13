package com.example.programmer.tamperelinjat.model.journeypattern;

/**
 * Created by Programmer on 11/27/2017.
 */

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StopPoint implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("tariffZone")
    @Expose
    private String tariffZone;
    @SerializedName("municipality")
    @Expose
    private Municipality municipality;
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
    private final static long serialVersionUID = -5303251010431319624L;

    protected StopPoint(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.shortName = ((String) in.readValue((String.class.getClassLoader())));
        this.tariffZone = ((String) in.readValue((String.class.getClassLoader())));
        this.municipality = ((Municipality) in.readValue((Municipality.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public StopPoint() {
    }

    /**
     *
     * @param location
     * @param name
     * @param municipality
     * @param tariffZone
     * @param shortName
     * @param url
     */
    public StopPoint(String url, String location, String name, String shortName, String tariffZone, Municipality municipality) {
        super();
        this.url = url;
        this.location = location;
        this.name = name;
        this.shortName = shortName;
        this.tariffZone = tariffZone;
        this.municipality = municipality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTariffZone() {
        return tariffZone;
    }

    public void setTariffZone(String tariffZone) {
        this.tariffZone = tariffZone;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(location);
        dest.writeValue(name);
        dest.writeValue(shortName);
        dest.writeValue(tariffZone);
        dest.writeValue(municipality);
    }

    public int describeContents() {
        return 0;
    }

}
