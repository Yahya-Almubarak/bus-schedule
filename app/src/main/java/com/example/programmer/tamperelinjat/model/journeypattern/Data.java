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

public class Data implements Serializable, Parcelable
{

    @SerializedName("headers")
    @Expose
    private Headers headers;
    public final static Parcelable.Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
            ;
    private final static long serialVersionUID = -8503307829445670123L;

    protected Data(Parcel in) {
        this.headers = ((Headers) in.readValue((Headers.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Data() {
    }

    /**
     *
     * @param headers
     */
    public Data(Headers headers) {
        super();
        this.headers = headers;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(headers);
    }

    public int describeContents() {
        return 0;
    }

}
