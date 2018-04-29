package com.amaro.bruno.amarochallenge.catalogue.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Size {

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
