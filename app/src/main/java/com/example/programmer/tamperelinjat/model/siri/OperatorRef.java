package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OperatorRef implements Serializable, Parcelable
{

    @SerializedName("value")
    @Expose
    private String value;
    public final static Creator<OperatorRef> CREATOR = new Creator<OperatorRef>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OperatorRef createFromParcel(Parcel in) {
            return new OperatorRef(in);
        }

        public OperatorRef[] newArray(int size) {
            return (new OperatorRef[size]);
        }

    }
            ;
    private final static long serialVersionUID = 1916443920468871411L;

    protected OperatorRef(Parcel in) {
        this.value = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public OperatorRef() {
    }

    /**
     *
     * @param value
     */
    public OperatorRef(String value) {
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
