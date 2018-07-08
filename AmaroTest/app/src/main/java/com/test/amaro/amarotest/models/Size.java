
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
    private String productSize;
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
        return productSize;
    }

    public void setSize(String size) {
        this.productSize = size;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.available);
        dest.writeString(this.productSize);
        dest.writeString(this.sku);
    }

    private Size(Parcel in) {
        this.available = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.productSize = in.readString();
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
