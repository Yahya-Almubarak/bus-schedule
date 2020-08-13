package com.example.programmer.tamperelinjat.model.streetaddresses;

/**
 * Created by Programmer on 12/19/2017.
 */

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feature implements Serializable, Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("geometry")
    @Expose
    private Geometry geometry;
    @SerializedName("geometry_name")
    @Expose
    private String geometryName;
    @SerializedName("properties")
    @Expose
    private Properties properties;
    public final static Parcelable.Creator<Feature> CREATOR = new Creator<Feature>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Feature createFromParcel(Parcel in) {
            return new Feature(in);
        }

        public Feature[] newArray(int size) {
            return (new Feature[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2762385671428075597L;

    protected Feature(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.geometry = ((Geometry) in.readValue((Geometry.class.getClassLoader())));
        this.geometryName = ((String) in.readValue((String.class.getClassLoader())));
        this.properties = ((Properties) in.readValue((Properties.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Feature() {
    }

    /**
     *
     * @param id
     * @param properties
     * @param geometryName
     * @param type
     * @param geometry
     */
    public Feature(String type, String id, Geometry geometry, String geometryName, Properties properties) {
        super();
        this.type = type;
        this.id = id;
        this.geometry = geometry;
        this.geometryName = geometryName;
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getGeometryName() {
        return geometryName;
    }

    public void setGeometryName(String geometryName) {
        this.geometryName = geometryName;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(id);
        dest.writeValue(geometry);
        dest.writeValue(geometryName);
        dest.writeValue(properties);
    }

    public int describeContents() {
        return 0;
    }

}