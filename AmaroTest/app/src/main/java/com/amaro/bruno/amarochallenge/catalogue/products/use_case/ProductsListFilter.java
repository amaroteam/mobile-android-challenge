package com.amaro.bruno.amarochallenge.catalogue.products.use_case;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductsListFilter implements Parcelable {

    public static final String BUNDLE = "product_filter";

    private String price;

    public ProductsListFilter(){}

    protected ProductsListFilter(Parcel in) {
        price = in.readString();
    }

    public static final Creator<ProductsListFilter> CREATOR = new Creator<ProductsListFilter>() {
        @Override
        public ProductsListFilter createFromParcel(Parcel in) {
            return new ProductsListFilter(in);
        }

        @Override
        public ProductsListFilter[] newArray(int size) {
            return new ProductsListFilter[size];
        }
    };

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(price);
    }
}
