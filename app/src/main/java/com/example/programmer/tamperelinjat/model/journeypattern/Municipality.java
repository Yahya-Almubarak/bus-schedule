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

public class Municipality implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<Municipality> CREATOR = new Creator<Municipality>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Municipality createFromParcel(Parcel in) {
            return new Municipality(in);
        }

        public Municipality[] newArray(int size) {
            return (new Municipality[size]);
        }

    }
            ;
    private final static long serialVersionUID = 7829322621365093992L;

    protected Municipality(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.shortName = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Municipality() {
    }

    /**
     *
     * @param name
     * @param shortName
     * @param url
     */
    public Municipality(String url, String shortName, String name) {
        super();
        this.url = url;
        this.shortName = shortName;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(shortName);
        dest.writeValue(name);
    }

    public int describeContents() {
        return 0;
    }

}
