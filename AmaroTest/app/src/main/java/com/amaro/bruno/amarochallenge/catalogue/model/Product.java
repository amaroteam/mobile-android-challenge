package com.amaro.bruno.amarochallenge.catalogue.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @JsonProperty("name")
    private String name;

    @JsonProperty("style")
    private String style;

    @JsonProperty("code_color")
    private String codeColor;

    @JsonProperty("color_slug")
    private String colorSlug;

    @JsonProperty("color")
    private String color;

    @JsonProperty("on_sale")
    private boolean onSale;

    @JsonProperty("regular_price")
    private String regularPrice;

    @JsonProperty("actual_price")
    private String actualPrice;

    @JsonProperty("discount_percentage")
    private String discountPercent;

    @JsonProperty("installments")
    private String installments;

    @JsonProperty("image")
    private String image;

    @JsonProperty("sizes")
    private List<Size> sizes;

    public Product(){}

    public Product(String name, String regularPrice, String image){
        this.name = name;
        this.regularPrice = regularPrice;
        this.image = image;
    }

    public Product(String name, String style, boolean onSale, String regularPrice, List<Size> sizes){
        this.name = name;
        this.style = style;
        this.onSale = onSale;
        this.regularPrice = regularPrice;
        this.sizes = sizes;
    }

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

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
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

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
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

    public void setSizes(ArrayList<Size> sizes) {
        this.sizes = sizes;
    }
}
