package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OriginName implements Serializable, Parcelable
{

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("lang")
    @Expose
    private String lang;
    public final static Creator<OriginName> CREATOR = new Creator<OriginName>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OriginName createFromParcel(Parcel in) {
            return new OriginName(in);
        }

        public OriginName[] newArray(int size) {
            return (new OriginName[size]);
        }

    }
            ;
    private final static long serialVersionUID = 4666220741759201239L;

    protected OriginName(Parcel in) {
        this.value = ((String) in.readValue((String.class.getClassLoader())));
        this.lang = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public OriginName() {
    }

    /**
     *
     * @param value
     * @param lang
     */
    public OriginName(String value, String lang) {
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
