package com.example.programmer.tamperelinjat.model.streetaddresses;

/**
 * Created by Programmer on 12/19/2017.
 */

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Crs implements Serializable, Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("properties")
    @Expose
    private Properties_ properties;
    public final static Parcelable.Creator<Crs> CREATOR = new Creator<Crs>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Crs createFromParcel(Parcel in) {
            return new Crs(in);
        }

        public Crs[] newArray(int size) {
            return (new Crs[size]);
        }

    }
            ;
    private final static long serialVersionUID = 4486890472732072138L;

    protected Crs(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.properties = ((Properties_) in.readValue((Properties_.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Crs() {
    }

    /**
     *
     * @param properties
     * @param type
     */
    public Crs(String type, Properties_ properties) {
        super();
        this.type = type;
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties_ getProperties() {
        return properties;
    }

    public void setProperties(Properties_ properties) {
        this.properties = properties;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(properties);
    }

    public int describeContents() {
        return 0;
    }

}