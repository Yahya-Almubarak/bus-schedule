package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProducerRef implements Serializable, Parcelable
{

    @SerializedName("value")
    @Expose
    private String value;
    public final static Creator<ProducerRef> CREATOR = new Creator<ProducerRef>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ProducerRef createFromParcel(Parcel in) {
            return new ProducerRef(in);
        }

        public ProducerRef[] newArray(int size) {
            return (new ProducerRef[size]);
        }

    }
            ;
    private final static long serialVersionUID = 3067339678108139476L;

    protected ProducerRef(Parcel in) {
        this.value = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public ProducerRef() {
    }

    /**
     *
     * @param value
     */
    public ProducerRef(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(value);
    }

    public int describeContents() {
        return 0;
    }

}