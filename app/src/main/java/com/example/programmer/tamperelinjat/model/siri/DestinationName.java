package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DestinationName implements Serializable, Parcelable
{

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("lang")
    @Expose
    private String lang;
    public final static Creator<DestinationName> CREATOR = new Creator<DestinationName>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DestinationName createFromParcel(Parcel in) {
            return new DestinationName(in);
        }

        public DestinationName[] newArray(int size) {
            return (new DestinationName[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2609339501736067934L;

    protected DestinationName(Parcel in) {
        this.value = ((String) in.readValue((String.class.getClassLoader())));
        this.lang = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public DestinationName() {
    }

    /**
     *
     * @param value
     * @param lang
     */
    public DestinationName(String value, String lang) {
        super();
        this.value = value;
        this.lang = lang;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(value);
        dest.writeValue(lang);
    }

    public int describeContents() {
        return 0;
    }

}
