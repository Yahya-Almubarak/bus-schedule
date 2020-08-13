package com.example.programmer.tamperelinjat.model.detailedvehicleactivity;

/**
 * Created by Programmer on 11/30/2017.
 */
import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MonitoredVehicleJourney implements Serializable, Parcelable
{

    @SerializedName("lineRef")
    @Expose
    private String lineRef;
    @SerializedName("directionRef")
    @Expose
    private String directionRef;
    @SerializedName("framedVehicleJourneyRef")
    @Expose
    private FramedVehicleJourneyRef framedVehicleJourneyRef;
    @SerializedName("vehicleLocation")
    @Expose
    private VehicleLocation vehicleLocation;
    @SerializedName("operatorRef")
    @Expose
    private String operatorRef;
    @SerializedName("bearing")
    @Expose
    private String bearing;
    @SerializedName("delay")
    @Expose
    private String delay;
    @SerializedName("vehicleRef")
    @Expose
    private String vehicleRef;
    @SerializedName("journeyPatternRef")
    @Expose
    private String journeyPatternRef;
    @SerializedName("originShortName")
    @Expose
    private String originShortName;
    @SerializedName("destinationShortName")
    @Expose
    private String destinationShortName;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("originAimedDepartureTime")
    @Expose
    private String originAimedDepartureTime;
    @SerializedName("onwardCalls")
    @Expose
    private List<OnwardCall> onwardCalls = null;
    public final static Parcelable.Creator<MonitoredVehicleJourney> CREATOR = new Creator<MonitoredVehicleJourney>() {


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
    private final static long serialVersionUID = -2874107675041907206L;

    protected MonitoredVehicleJourney(Parcel in) {
        this.lineRef = ((String) in.readValue((String.class.getClassLoader())));
        this.directionRef = ((String) in.readValue((String.class.getClassLoader())));
        this.framedVehicleJourneyRef = ((FramedVehicleJourneyRef) in.readValue((FramedVehicleJourneyRef.class.getClassLoader())));
        this.vehicleLocation = ((VehicleLocation) in.readValue((VehicleLocation.class.getClassLoader())));
        this.operatorRef = ((String) in.readValue((String.class.getClassLoader())));
        this.bearing = ((String) in.readValue((String.class.getClassLoader())));
        this.delay = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleRef = ((String) in.readValue((String.class.getClassLoader())));
        this.journeyPatternRef = ((String) in.readValue((String.class.getClassLoader())));
        this.originShortName = ((String) in.readValue((String.class.getClassLoader())));
        this.destinationShortName = ((String) in.readValue((String.class.getClassLoader())));
        this.speed = ((String) in.readValue((String.class.getClassLoader())));
        this.originAimedDepartureTime = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.onwardCalls, (com.example.programmer.tamperelinjat.model.detailedvehicleactivity.OnwardCall.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MonitoredVehicleJourney() {
    }

    /**
     *
     * @param operatorRef
     * @param vehicleRef
     * @param speed
     * @param originAimedDepartureTime
     * @param directionRef
     * @param journeyPatternRef
     * @param onwardCalls
     * @param framedVehicleJourneyRef
     * @param vehicleLocation
     * @param originShortName
     * @param bearing
     * @param destinationShortName
     * @param delay
     * @param lineRef
     */
    public MonitoredVehicleJourney(String lineRef, String directionRef, FramedVehicleJourneyRef framedVehicleJourneyRef, VehicleLocation vehicleLocation, String operatorRef, String bearing, String delay, String vehicleRef, String journeyPatternRef, String originShortName, String destinationShortName, String speed, String originAimedDepartureTime, List<OnwardCall> onwardCalls) {
        super();
        this.lineRef = lineRef;
        this.directionRef = directionRef;
        this.framedVehicleJourneyRef = framedVehicleJourneyRef;
        this.vehicleLocation = vehicleLocation;
        this.operatorRef = operatorRef;
        this.bearing = bearing;
        this.delay = delay;
        this.vehicleRef = vehicleRef;
        this.journeyPatternRef = journeyPatternRef;
        this.originShortName = originShortName;
        this.destinationShortName = destinationShortName;
        this.speed = speed;
        this.originAimedDepartureTime = originAimedDepartureTime;
        this.onwardCalls = onwardCalls;
    }

    public String getLineRef() {
        return lineRef;
    }

    public void setLineRef(String lineRef) {
        this.lineRef = lineRef;
    }

    public String getDirectionRef() {
        return directionRef;
    }

    public void setDirectionRef(String directionRef) {
        this.directionRef = directionRef;
    }

    public FramedVehicleJourneyRef getFramedVehicleJourneyRef() {
        return framedVehicleJourneyRef;
    }

    public void setFramedVehicleJourneyRef(FramedVehicleJourneyRef framedVehicleJourneyRef) {
        this.framedVehicleJourneyRef = framedVehicleJourneyRef;
    }

    public VehicleLocation getVehicleLocation() {
        return vehicleLocation;
    }

    public void setVehicleLocation(VehicleLocation vehicleLocation) {
        this.vehicleLocation = vehicleLocation;
    }

    public String getOperatorRef() {
        return operatorRef;
    }

    public void setOperatorRef(String operatorRef) {
        this.operatorRef = operatorRef;
    }

    public String getBearing() {
        return bearing;
    }

    public void setBearing(String bearing) {
        this.bearing = bearing;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getVehicleRef() {
        return vehicleRef;
    }

    public void setVehicleRef(String vehicleRef) {
        this.vehicleRef = vehicleRef;
    }

    public String getJourneyPatternRef() {
        return journeyPatternRef;
    }

    public void setJourneyPatternRef(String journeyPatternRef) {
        this.journeyPatternRef = journeyPatternRef;
    }

    public String getOriginShortName() {
        return originShortName;
    }

    public void setOriginShortName(String originShortName) {
        this.originShortName = originShortName;
    }

    public String getDestinationShortName() {
        return destinationShortName;
    }

    public void setDestinationShortName(String destinationShortName) {
        this.destinationShortName = destinationShortName;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getOriginAimedDepartureTime() {
        return originAimedDepartureTime;
    }

    public void setOriginAimedDepartureTime(String originAimedDepartureTime) {
        this.originAimedDepartureTime = originAimedDepartureTime;
    }

    public List<OnwardCall> getOnwardCalls() {
        return onwardCalls;
    }

    public void setOnwardCalls(List<OnwardCall> onwardCalls) {
        this.onwardCalls = onwardCalls;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lineRef);
        dest.writeValue(directionRef);
        dest.writeValue(framedVehicleJourneyRef);
        dest.writeValue(vehicleLocation);
        dest.writeValue(operatorRef);
        dest.writeValue(bearing);
        dest.writeValue(delay);
        dest.writeValue(vehicleRef);
        dest.writeValue(journeyPatternRef);
        dest.writeValue(originShortName);
        dest.writeValue(destinationShortName);
        dest.writeValue(speed);
        dest.writeValue(originAimedDepartureTime);
        dest.writeList(onwardCalls);
    }

    public int describeContents() {
        return 0;
    }

}
