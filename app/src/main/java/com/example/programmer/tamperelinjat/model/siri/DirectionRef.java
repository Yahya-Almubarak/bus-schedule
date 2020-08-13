package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DirectionRef implements Serializable, Parcelable
{

    @SerializedName("value")
    @Expose
    private String value;
    public final static Creator<DirectionRef> CREATOR = new Creator<DirectionRef>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DirectionRef createFromParcel(Parcel in) {
            return new DirectionRef(in);
        }

        public DirectionRef[] newArray(int size) {
            return (new DirectionRef[size]);
        }

    }
            ;
    private final static long serialVersionUID = 3815303258088953704L;

    protected DirectionRef(Parcel in) {
        this.value = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public DirectionRef() {
    }

    /**
     *
     * @param value
     */
    public DirectionRef(String value) {
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
