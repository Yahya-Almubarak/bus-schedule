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

public class Properties_ implements Serializable, Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<Properties_> CREATOR = new Creator<Properties_>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Properties_ createFromParcel(Parcel in) {
            return new Properties_(in);
        }

        public Properties_[] newArray(int size) {
            return (new Properties_[size]);
        }

    }
            ;
    private final static long serialVersionUID = 8816198560454276642L;

    protected Properties_(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Properties_() {
    }

    /**
     *
     * @param name
     */
    public Properties_(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
    }

    public int describeContents() {
        return 0;
    }

}
