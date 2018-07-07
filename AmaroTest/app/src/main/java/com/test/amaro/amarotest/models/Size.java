
package com.test.amaro.amarotest.models;

import android.os.Parcel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Size implements android.os.Parcelable {

    @SerializedName("available")
    @Expose
    private Boolean available;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("sku")
    @Expose
    private String sku;

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.available);
        dest.writeString(this.size);
        dest.writeString(this.sku);
    }

    public Size() {
    }

    protected Size(Parcel in) {
        this.available = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.size = in.readString();
        this.sku = in.readString();
    }

    public static final Creator<Size> CREATOR = new Creator<Size>() {
        @Override
        public Size createFromParcel(Parcel source) {
            return new Size(source);
        }

        @Override
        public Size[] newArray(int size) {
            return new Size[size];
        }
    };
}
