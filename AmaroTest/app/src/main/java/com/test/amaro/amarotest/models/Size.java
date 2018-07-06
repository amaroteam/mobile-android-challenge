
package com.test.amaro.amarotest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Size {

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

}
