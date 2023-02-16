package com.example.skill6.networking;

import com.google.gson.annotations.SerializedName;

public class ProductResult {
    @SerializedName("id")
    int id;

    @SerializedName("title")
    String title;

    @SerializedName("productImage")
    String productImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
