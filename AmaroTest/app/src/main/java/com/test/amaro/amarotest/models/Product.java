
package com.test.amaro.amarotest.models;

import android.os.Parcel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Product implements android.os.Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("style")
    @Expose
    private String style;
    @SerializedName("code_color")
    @Expose
    private String codeColor;
    @SerializedName("color_slug")
    @Expose
    private String colorSlug;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("on_sale")
    @Expose
    private Boolean onSale;
    @SerializedName("regular_price")
    @Expose
    private String regularPrice;
    @SerializedName("actual_price")
    @Expose
    private String actualPrice;
    @SerializedName("discount_percentage")
    @Expose
    private String discountPercentage;
    @SerializedName("installments")
    @Expose
    private String installments;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("sizes")
    @Expose
    private List<Size> sizes = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getCodeColor() {
        return codeColor;
    }

    public void setCodeColor(String codeColor) {
        this.codeColor = codeColor;
    }

    public String getColorSlug() {
        return colorSlug;
    }

    public void setColorSlug(String colorSlug) {
        this.colorSlug = colorSlug;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    public String getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getInstallments() {
        return installments;
    }

    public void setInstallments(String installments) {
        this.installments = installments;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.style);
        dest.writeString(this.codeColor);
        dest.writeString(this.colorSlug);
        dest.writeString(this.color);
        dest.writeValue(this.onSale);
        dest.writeString(this.regularPrice);
        dest.writeString(this.actualPrice);
        dest.writeString(this.discountPercentage);
        dest.writeString(this.installments);
        dest.writeString(this.image);
        dest.writeList(this.sizes);
    }

    public Product() {
    }

    protected Product(Parcel in) {
        this.name = in.readString();
        this.style = in.readString();
        this.codeColor = in.readString();
        this.colorSlug = in.readString();
        this.color = in.readString();
        this.onSale = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.regularPrice = in.readString();
        this.actualPrice = in.readString();
        this.discountPercentage = in.readString();
        this.installments = in.readString();
        this.image = in.readString();
        this.sizes = new ArrayList<>();
        in.readList(this.sizes, Size.class.getClassLoader());
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
