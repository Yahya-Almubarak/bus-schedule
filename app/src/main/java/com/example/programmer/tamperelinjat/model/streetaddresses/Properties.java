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

public class Properties implements Serializable, Parcelable
{

    @SerializedName("KADUNNIMI")
    @Expose
    private String kADUNNIMI;
    @SerializedName("NUMERO")
    @Expose
    private String nUMERO;
    @SerializedName("TYYPPI")
    @Expose
    private String tYYPPI;
    @SerializedName("TARKKUUS")
    @Expose
    private String tARKKUUS;
    @SerializedName("ALKUPERAKOODI")
    @Expose
    private String aLKUPERAKOODI;
    @SerializedName("HISTORIA_PVM")
    @Expose
    private Object hISTORIAPVM;
    @SerializedName("LUONTI_PVM")
    @Expose
    private Object lUONTIPVM;
    @SerializedName("MUOKKAUS_PVM")
    @Expose
    private String mUOKKAUSPVM;
    @SerializedName("OLOTILA")
    @Expose
    private String oLOTILA;
    @SerializedName("ROTATION")
    @Expose
    private String rOTATION;
    public final static Parcelable.Creator<Properties> CREATOR = new Creator<Properties>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Properties createFromParcel(Parcel in) {
            return new Properties(in);
        }

        public Properties[] newArray(int size) {
            return (new Properties[size]);
        }

    }
            ;
    private final static long serialVersionUID = -6025950365267069312L;

    protected Properties(Parcel in) {
        this.kADUNNIMI = ((String) in.readValue((String.class.getClassLoader())));
        this.nUMERO = ((String) in.readValue((String.class.getClassLoader())));
        this.tYYPPI = ((String) in.readValue((String.class.getClassLoader())));
        this.tARKKUUS = ((String) in.readValue((String.class.getClassLoader())));
        this.aLKUPERAKOODI = ((String) in.readValue((String.class.getClassLoader())));
        this.hISTORIAPVM = ((Object) in.readValue((Object.class.getClassLoader())));
        this.lUONTIPVM = ((Object) in.readValue((Object.class.getClassLoader())));
        this.mUOKKAUSPVM = ((String) in.readValue((String.class.getClassLoader())));
        this.oLOTILA = ((String) in.readValue((String.class.getClassLoader())));
        this.rOTATION = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Properties() {
    }

    /**
     *
     * @param oLOTILA
     * @param tYYPPI
     * @param nUMERO
     * @param aLKUPERAKOODI
     * @param rOTATION
     * @param lUONTIPVM
     * @param hISTORIAPVM
     * @param kADUNNIMI
     * @param mUOKKAUSPVM
     * @param tARKKUUS
     */
    public Properties(String kADUNNIMI, String nUMERO, String tYYPPI, String tARKKUUS, String aLKUPERAKOODI, Object hISTORIAPVM, Object lUONTIPVM, String mUOKKAUSPVM, String oLOTILA, String rOTATION) {
        super();
        this.kADUNNIMI = kADUNNIMI;
        this.nUMERO = nUMERO;
        this.tYYPPI = tYYPPI;
        this.tARKKUUS = tARKKUUS;
        this.aLKUPERAKOODI = aLKUPERAKOODI;
        this.hISTORIAPVM = hISTORIAPVM;
        this.lUONTIPVM = lUONTIPVM;
        this.mUOKKAUSPVM = mUOKKAUSPVM;
        this.oLOTILA = oLOTILA;
        this.rOTATION = rOTATION;
    }

    public String getKADUNNIMI() {
        return kADUNNIMI;
    }

    public void setKADUNNIMI(String kADUNNIMI) {
        this.kADUNNIMI = kADUNNIMI;
    }

    public String getNUMERO() {
        return nUMERO;
    }

    public void setNUMERO(String nUMERO) {
        this.nUMERO = nUMERO;
    }

    public String getTYYPPI() {
        return tYYPPI;
    }

    public void setTYYPPI(String tYYPPI) {
        this.tYYPPI = tYYPPI;
    }

    public String getTARKKUUS() {
        return tARKKUUS;
    }

    public void setTARKKUUS(String tARKKUUS) {
        this.tARKKUUS = tARKKUUS;
    }

    public String getALKUPERAKOODI() {
        return aLKUPERAKOODI;
    }

    public void setALKUPERAKOODI(String aLKUPERAKOODI) {
        this.aLKUPERAKOODI = aLKUPERAKOODI;
    }

    public Object getHISTORIAPVM() {
        return hISTORIAPVM;
    }

    public void setHISTORIAPVM(Object hISTORIAPVM) {
        this.hISTORIAPVM = hISTORIAPVM;
    }

    public Object getLUONTIPVM() {
        return lUONTIPVM;
    }

    public void setLUONTIPVM(Object lUONTIPVM) {
        this.lUONTIPVM = lUONTIPVM;
    }

    public String getMUOKKAUSPVM() {
        return mUOKKAUSPVM;
    }

    public void setMUOKKAUSPVM(String mUOKKAUSPVM) {
        this.mUOKKAUSPVM = mUOKKAUSPVM;
    }

    public String getOLOTILA() {
        return oLOTILA;
    }

    public void setOLOTILA(String oLOTILA) {
        this.oLOTILA = oLOTILA;
    }

    public String getROTATION() {
        return rOTATION;
    }

    public void setROTATION(String rOTATION) {
        this.rOTATION = rOTATION;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(kADUNNIMI);
        dest.writeValue(nUMERO);
        dest.writeValue(tYYPPI);
        dest.writeValue(tARKKUUS);
        dest.writeValue(aLKUPERAKOODI);
        dest.writeValue(hISTORIAPVM);
        dest.writeValue(lUONTIPVM);
        dest.writeValue(mUOKKAUSPVM);
        dest.writeValue(oLOTILA);
        dest.writeValue(rOTATION);
    }

    public int describeContents() {
        return 0;
    }

}
