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

public class Addresses implements Serializable, Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("totalFeatures")
    @Expose
    private long totalFeatures;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;
    @SerializedName("crs")
    @Expose
    private Crs crs;
    public final static Parcelable.Creator<Addresses> CREATOR = new Creator<Addresses>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Addresses createFromParcel(Parcel in) {
            return new Addresses(in);
        }

        public Addresses[] newArray(int size) {
            return (new Addresses[size]);
        }

    }
            ;
    private final static long serialVersionUID = 20624711927185233L;

    protected Addresses(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.totalFeatures = ((long) in.readValue((long.class.getClassLoader())));
        in.readList(this.features, (com.example.programmer.tamperelinjat.model.streetaddresses.Feature.class.getClassLoader()));
        this.crs = ((Crs) in.readValue((Crs.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Addresses() {
    }

    /**
     *
     * @param crs
     * @param features
     * @param type
     * @param totalFeatures
     */
    public Addresses(String type, long totalFeatures, List<Feature> features, Crs crs) {
        super();
        this.type = type;
        this.totalFeatures = totalFeatures;
        this.features = features;
        this.crs = crs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTotalFeatures() {
        return totalFeatures;
    }

    public void setTotalFeatures(long totalFeatures) {
        this.totalFeatures = totalFeatures;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Crs getCrs() {
        return crs;
    }

    public void setCrs(Crs crs) {
        this.crs = crs;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(totalFeatures);
        dest.writeList(features);
        dest.writeValue(crs);
    }

    public int describeContents() {
        return 0;
    }

}