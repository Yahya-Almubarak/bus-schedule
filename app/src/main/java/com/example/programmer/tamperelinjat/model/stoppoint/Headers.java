package com.example.programmer.tamperelinjat.model.stoppoint;

/**
 * Created by Programmer on 11/27/2017.
 */

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Headers implements Serializable, Parcelable
{

    @SerializedName("paging")
    @Expose
    private Paging paging;
    public final static Parcelable.Creator<Headers> CREATOR = new Creator<Headers>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Headers createFromParcel(Parcel in) {
            return new Headers(in);
        }

        public Headers[] newArray(int size) {
            return (new Headers[size]);
        }

    }
            ;
    private final static long serialVersionUID = 6689018508764838017L;

    protected Headers(Parcel in) {
        this.paging = ((Paging) in.readValue((Paging.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Headers() {
    }

    /**
     *
     * @param paging
     */
    public Headers(Paging paging) {
        super();
        this.paging = paging;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(paging);
    }

    public int describeContents() {
        return 0;
    }

}
