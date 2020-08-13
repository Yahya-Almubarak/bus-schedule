package com.example.programmer.tamperelinjat.model.routes;

/**
 * Created by Programmer on 11/27/2017.
 */

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Route implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("lineUrl")
    @Expose
    private String lineUrl;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("journeyPatterns")
    @Expose
    private List<JourneyPattern> journeyPatterns = null;
    @SerializedName("journeys")
    @Expose
    private List<Journey> journeys = null;
    @SerializedName("geographicCoordinateProjection")
    @Expose
    private String geographicCoordinateProjection;
    public final static Parcelable.Creator<Route> CREATOR = new Creator<Route>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Route createFromParcel(Parcel in) {
            return new Route(in);
        }

        public Route[] newArray(int size) {
            return (new Route[size]);
        }

    }
            ;
    private final static long serialVersionUID = -411719691082109969L;

    protected Route(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.lineUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.journeyPatterns, (com.example.programmer.tamperelinjat.model.routes.JourneyPattern.class.getClassLoader()));
        in.readList(this.journeys, (com.example.programmer.tamperelinjat.model.routes.Journey.class.getClassLoader()));
        this.geographicCoordinateProjection = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Route() {
    }

    /**
     *
     * @param journeys
     * @param geographicCoordinateProjection
     * @param journeyPatterns
     * @param name
     * @param lineUrl
     * @param url
     */
    public Route(String url, String lineUrl, String name, List<JourneyPattern> journeyPatterns, List<Journey> journeys, String geographicCoordinateProjection) {
        super();
        this.url = url;
        this.lineUrl = lineUrl;
        this.name = name;
        this.journeyPatterns = journeyPatterns;
        this.journeys = journeys;
        this.geographicCoordinateProjection = geographicCoordinateProjection;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLineUrl() {
        return lineUrl;
    }

    public void setLineUrl(String lineUrl) {
        this.lineUrl = lineUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JourneyPattern> getJourneyPatterns() {
        return journeyPatterns;
    }

    public void setJourneyPatterns(List<JourneyPattern> journeyPatterns) {
        this.journeyPatterns = journeyPatterns;
    }

    public List<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
    }

    public String getGeographicCoordinateProjection() {
        return geographicCoordinateProjection;
    }

    public void setGeographicCoordinateProjection(String geographicCoordinateProjection) {
        this.geographicCoordinateProjection = geographicCoordinateProjection;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(lineUrl);
        dest.writeValue(name);
        dest.writeList(journeyPatterns);
        dest.writeList(journeys);
        dest.writeValue(geographicCoordinateProjection);
    }

    public int describeContents() {
        return 0;
    }
}
