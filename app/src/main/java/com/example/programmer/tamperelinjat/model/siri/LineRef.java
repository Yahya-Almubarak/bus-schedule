package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LineRef implements Serializable, Parcelable
{

    @SerializedName("value")
    @Expose
    private String value;
    public final static Creator<LineRef> CREATOR = new Creator<LineRef>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LineRef createFromParcel(Parcel in) {
            return new LineRef(in);
        }

        public LineRef[] newArray(int size) {
            return (new LineRef[size]);
        }

    }
            ;
    private final static long serialVersionUID = 748056979974803119L;

    protected LineRef(Parcel in) {
        this.value = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public LineRef() {
    }

    /**
     *
     * @param value
     */
    public LineRef(String value) {
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