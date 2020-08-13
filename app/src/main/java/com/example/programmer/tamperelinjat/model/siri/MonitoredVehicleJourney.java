package com.example.programmer.tamperelinjat.model.siri;

/**
 * Created by Programmer on 11/19/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MonitoredVehicleJourney implements Serializable, Parcelable
{

    @SerializedName("LineRef")
    @Expose
    private LineRef lineRef;
    @SerializedName("DirectionRef")
    @Expose
    private DirectionRef directionRef;
    @SerializedName("FramedVehicleJourneyRef")
    @Expose
    private FramedVehicleJourneyRef framedVehicleJourneyRef;
    @SerializedName("OperatorRef")
    @Expose
    private OperatorRef operatorRef;
    @SerializedName("OriginName")
    @Expose
    private OriginName originName;
    @SerializedName("DestinationName")
    @Expose
    private DestinationName destinationName;
    @SerializedName("Monitored")
    @Expose
    private boolean monitored;
    @SerializedName("VehicleLocation")
    @Expose
    private VehicleLocation vehicleLocation;
    @SerializedName("Bearing")
    @Expose
    private double bearing;
    @SerializedName("Delay")
    @Expose
    private String delay;
    @SerializedName("VehicleRef")
    @Expose
    private VehicleRef vehicleRef;
    public final static Creator<MonitoredVehicleJourney> CREATOR = new Creator<MonitoredVehicleJourney>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MonitoredVehicleJourney createFromParcel(Parcel in) {
            return new MonitoredVehicleJourney(in);
        }

        public MonitoredVehicleJourney[] newArray(int size) {
            return (new MonitoredVehicleJourney[size]);
        }

    }
            ;
    private final static long serialVersionUID = -6489222107829572864L;

    protected MonitoredVehicleJourney(Parcel in) {
        this.lineRef = ((LineRef) in.readValue((LineRef.class.getClassLoader())));
        this.directionRef = ((DirectionRef) in.readValue((DirectionRef.class.getClassLoader())));
        this.framedVehicleJourneyRef = ((FramedVehicleJourneyRef) in.readValue((FramedVehicleJourneyRef.class.getClassLoader())));
        this.operatorRef = ((OperatorRef) in.readValue((OperatorRef.class.getClassLoader())));
        this.originName = ((OriginName) in.readValue((OriginName.class.getClassLoader())));
        this.destinationName = ((DestinationName) in.readValue((DestinationName.class.getClassLoader())));
        this.monitored = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.vehicleLocation = ((VehicleLocation) in.readValue((VehicleLocation.class.getClassLoader())));
        this.bearing = ((double) in.readValue((double.class.getClassLoader())));
        this.delay = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleRef = ((VehicleRef) in.readValue((VehicleRef.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MonitoredVehicleJourney() {
    }

    /**
     *
     * @param vehicleRef
     * @param operatorRef
     * @param framedVehicleJourneyRef
     * @param vehicleLocation
     * @param bearing
     * @param delay
     * @param destinationName
     * @param monitored
     * @param directionRef
     * @param originName
     * @param lineRef
     */
    public MonitoredVehicleJourney(LineRef lineRef, DirectionRef directionRef, FramedVehicleJourneyRef framedVehicleJourneyRef, OperatorRef operatorRef, OriginName originName, DestinationName destinationName, boolean monitored, VehicleLocation vehicleLocation, double bearing, String delay, VehicleRef vehicleRef) {
        super();
        this.lineRef = lineRef;
        this.directionRef = directionRef;
        this.framedVehicleJourneyRef = framedVehicleJourneyRef;
        this.operatorRef = operatorRef;
        this.originName = originName;
        this.destinationName = destinationName;
        this.monitored = monitored;
        this.vehicleLocation = vehicleLocation;
        this.bearing = bearing;
        this.delay = delay;
        this.vehicleRef = vehicleRef;
    }

    public LineRef getLineRef() {
        return lineRef;
    }

    public void setLineRef(LineRef lineRef) {
        this.lineRef = lineRef;
    }

    public DirectionRef getDirectionRef() {
        return directionRef;
    }

    public void setDirectionRef(DirectionRef directionRef) {
        this.directionRef = directionRef;
    }

    public FramedVehicleJourneyRef getFramedVehicleJourneyRef() {
        return framedVehicleJourneyRef;
    }

    public void setFramedVehicleJourneyRef(FramedVehicleJourneyRef framedVehicleJourneyRef) {
        this.framedVehicleJourneyRef = framedVehicleJourneyRef;
    }

    public OperatorRef getOperatorRef() {
        return operatorRef;
    }

    public void setOperatorRef(OperatorRef operatorRef) {
        this.operatorRef = operatorRef;
    }

    public OriginName getOriginName() {
        return originName;
    }

    public void setOriginName(OriginName originName) {
        this.originName = originName;
    }

    public DestinationName getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(DestinationName destinationName) {
        this.destinationName = destinationName;
    }

    public boolean isMonitored() {
        return monitored;
    }

    public void setMonitored(boolean monitored) {
        this.monitored = monitored;
    }

    public VehicleLocation getVehicleLocation() {
        return vehicleLocation;
    }

    public void setVehicleLocation(VehicleLocation vehicleLocation) {
        this.vehicleLocation = vehicleLocation;
    }

    public double getBearing() {
        return bearing;
    }

    public void setBearing(double bearing) {
        this.bearing = bearing;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public VehicleRef getVehicleRef() {
        return vehicleRef;
    }

    public void setVehicleRef(VehicleRef vehicleRef) {
        this.vehicleRef = vehicleRef;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lineRef);
        dest.writeValue(directionRef);
        dest.writeValue(framedVehicleJourneyRef);
        dest.writeValue(operatorRef);
        dest.writeValue(originName);
        dest.writeValue(destinationName);
        dest.writeValue(monitored);
        dest.writeValue(vehicleLocation);
        dest.writeValue(bearing);
        dest.writeValue(delay);
        dest.writeValue(vehicleRef);
    }

    public int describeContents() {
        return 0;
    }

}