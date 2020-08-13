package com.example.programmer.tamperelinjat.model.detailedvehicleactivity;

/**
 * Created by Programmer on 11/30/2017.
 */

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paging implements Serializable, Parcelable
{

    @SerializedName("startIndex")
    @Expose
    private long startIndex;
    @SerializedName("pageSize")
    @Expose
    private long pageSize;
    @SerializedName("moreData")
    @Expose
    private boolean moreData;
    public final static Parcelable.Creator<Paging> CREATOR = new Creator<Paging>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Paging createFromParcel(Parcel in) {
            return new Paging(in);
        }

        public Paging[] newArray(int size) {
            return (new Paging[size]);
        }

    }
            ;
    private final static long serialVersionUID = -1890196550400236533L;

    protected Paging(Parcel in) {
        this.startIndex = ((long) in.readValue((long.class.getClassLoader())));
        this.pageSize = ((long) in.readValue((long.class.getClassLoader())));
        this.moreData = ((boolean) in.readValue((boolean.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Paging() {
    }

    /**
     *
     * @param startIndex
     * @param moreData
     * @param pageSize
     */
    public Paging(long startIndex, long pageSize, boolean moreData) {
        super();
        this.startIndex = startIndex;
        this.pageSize = pageSize;
        this.moreData = moreData;
    }

    public long getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(long startIndex) {
        this.startIndex = startIndex;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isMoreData() {
        return moreData;
    }

    public void setMoreData(boolean moreData) {
        this.moreData = moreData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(startIndex);
        dest.writeValue(pageSize);
        dest.writeValue(moreData);
    }

    public int describeContents() {
        return 0;
    }

}
