package com.example.programmer.tamperelinjat.model.streetaddresses;

/**
 * Created by Programmer on 12/19/2017.
 */

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geometry implements Serializable, Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("coordinates")
    @Expose
    private List<Double> coordinates = null;
    public final static Parcelable.Creator<Geometry> CREATOR = new Creator<Geometry>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Geometry createFromParcel(Parcel in) {
            return new Geometry(in);
        }

        public Geometry[] newArray(int size) {
            return (new Geometry[size]);
        }

    }
            ;
    private final static long serialVersionUID = 7562193186433896603L;

    protected Geometry(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.coordinates, (java.lang.Double.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Geometry() {
    }

    /**
     *
     * @param type
     * @param coordinates
     */
    public Geometry(String type, List<Double> coordinates) {
        super();
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeList(coordinates);
    }

    public int describeContents() {
        return 0;
    }

}