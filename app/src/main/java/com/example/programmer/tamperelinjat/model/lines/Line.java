package com.example.programmer.tamperelinjat.model.lines;

/**
 * Created by Programmer on 11/27/2017.
 */


import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Line implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    public final static Parcelable.Creator<Line> CREATOR = new Creator<Line>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Line createFromParcel(Parcel in) {
            return new Line(in);
        }

        public Line[] newArray(int size) {
            return (new Line[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2432888926451279729L;

    protected Line(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Line() {
    }

    /**
     *
     * @param description
     * @param name
     * @param url
     */
    public Line(String url, String name, String description) {
        super();
        this.url = url;
        this.name = name;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(name);
        dest.writeValue(description);
    }

    public int describeContents() {
        return 0;
    }

}