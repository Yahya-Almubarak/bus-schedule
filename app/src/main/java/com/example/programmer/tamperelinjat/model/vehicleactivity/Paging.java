package com.example.programmer.tamperelinjat.model.vehicleactivity;

/**
 * Created by Programmer on 11/27/2017.
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
    private int startIndex;
    @SerializedName("pageSize")
    @Expose
    private int pageSize;
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
    private final static long serialVersionUID = 2665143079469923234L;

    protected Paging(Parcel in) {
        this.startIndex = ((int) in.readValue((int.class.getClassLoader())));
        this.pageSize = ((int) in.readValue((int.class.getClassLoader())));
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
    public Paging(int startIndex, int pageSize, boolean moreData) {
        super();
        this.startIndex = startIndex;
        this.pageSize = pageSize;
        this.moreData = moreData;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
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
