package com.amaro.bruno.amarochallenge.catalogue.products.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Size implements Parcelable {

    public static final String SIZE_NUMBER_GG = "44";
    public static final String SIZE_NUMBER_G = "42";
    public static final String SIZE_NUMBER_M = "40";
    public static final String SIZE_NUMBER_P = "38";
    public static final String SIZE_NUMBER_PP = "36";

    public static final String SIZE_GG = "GG";
    public static final String SIZE_G = "G";
    public static final String SIZE_M = "M";
    public static final String SIZE_P = "P";
    public static final String SIZE_PP = "PP";

    public static final String SIZE_U = "U";

    @JsonProperty("available")
    private boolean available;

    @JsonProperty("size")
    private String size;

    @JsonProperty("sku")
    private String sku;

    public Size(){}

    public Size(boolean available, String size, String sku){
        this.available = available;
        this.size = size;
        this.sku = sku;
    }

    protected Size(Parcel in) {
        available = in.readByte() != 0;
        size = in.readString();
        sku = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (available ? 1 : 0));
        dest.writeString(size);
        dest.writeString(sku);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Size> CREATOR = new Creator<Size>() {
        @Override
        public Size createFromParcel(Parcel in) {
            return new Size(in);
        }

        @Override
        public Size[] newArray(int size) {
            return new Size[size];
        }
    };

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
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
    public boolean equals(Object o) {
        return o instanceof Size && ((Size) o).size.toLowerCase().equals(size.toLowerCase()) && ((Size)o).isAvailable();
    }

}
