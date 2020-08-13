package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataFrameRef implements Serializable, Parcelable
{

    @SerializedName("value")
    @Expose
    private String value;
    public final static Creator<DataFrameRef> CREATOR = new Creator<DataFrameRef>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DataFrameRef createFromParcel(Parcel in) {
            return new DataFrameRef(in);
        }

        public DataFrameRef[] newArray(int size) {
            return (new DataFrameRef[size]);
        }

    }
            ;
    private final static long serialVersionUID = 1717163867788616334L;

    protected DataFrameRef(Parcel in) {
        this.value = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public DataFrameRef() {
    }

    /**
     *
     * @param value
     */
    public DataFrameRef(String value) {
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