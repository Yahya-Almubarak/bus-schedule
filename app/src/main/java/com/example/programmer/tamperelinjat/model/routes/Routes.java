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

public class Routes implements Serializable, Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("body")
    @Expose
    private List<Route> route = null;
    public final static Parcelable.Creator<Routes> CREATOR = new Creator<Routes>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Routes createFromParcel(Parcel in) {
            return new Routes(in);
        }

        public Routes[] newArray(int size) {
            return (new Routes[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2551181872669461623L;

    protected Routes(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
        in.readList(this.route, (Route.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Routes() {
    }

    /**
     *
     * @param route
     * @param status
     * @param data
     */
    public Routes(String status, Data data, List<Route> route) {
        super();
        this.status = status;
        this.data = data;
        this.route = route;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<Route> getRoute() {
        return route;
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(data);
        dest.writeList(route);
    }

    public int describeContents() {
        return 0;
    }

}
