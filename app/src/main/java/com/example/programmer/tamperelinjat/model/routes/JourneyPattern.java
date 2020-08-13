package com.example.programmer.tamperelinjat.model.routes;

/**
 * Created by Programmer on 12/7/2017.
 */

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JourneyPattern implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("originStop")
    @Expose
    private String originStop;
    @SerializedName("destinationStop")
    @Expose
    private String destinationStop;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("direction")
    @Expose
    private String direction;
    public final static Parcelable.Creator<JourneyPattern> CREATOR = new Creator<JourneyPattern>() {


        @SuppressWarnings({
                "unchecked"
        })
        public JourneyPattern createFromParcel(Parcel in) {
            return new JourneyPattern(in);
        }

        public JourneyPattern[] newArray(int size) {
            return (new JourneyPattern[size]);
        }

    }
            ;
    private final static long serialVersionUID = -517851737558915292L;

    protected JourneyPattern(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.originStop = ((String) in.readValue((String.class.getClassLoader())));
        this.destinationStop = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.direction = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public JourneyPattern() {
    }

    /**
     *
     * @param destinationStop
     * @param direction
     * @param name
     * @param originStop
     * @param url
     */
    public JourneyPattern(String url, String originStop, String destinationStop, String name, String direction) {
        super();
        this.url = url;
        this.originStop = originStop;
        this.destinationStop = destinationStop;
        this.name = name;
        this.direction = direction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOriginStop() {
        return originStop;
    }

    public void setOriginStop(String originStop) {
        this.originStop = originStop;
    }

    public String getDestinationStop() {
        return destinationStop;
    }

    public void setDestinationStop(String destinationStop) {
        this.destinationStop = destinationStop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(originStop);
        dest.writeValue(destinationStop);
        dest.writeValue(name);
        dest.writeValue(direction);
    }

    public int describeContents() {
        return 0;
    }

}