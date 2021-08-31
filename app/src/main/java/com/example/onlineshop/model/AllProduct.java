package com.example.onlineshop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllProduct {

    @SerializedName("id")
    @Expose
    private int mId;

    @SerializedName("title")
    @Expose
    private String mTitle;

    @SerializedName("price")
    @Expose
    private float mPrice;

    @SerializedName("description")
    @Expose
    private String mDescription;

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("image")
    @Expose
    private String mUrlImage;

    @SerializedName("rating")
    @Expose
    private Rating mRating;

    public String getDescription() {
        return mDescription;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public float getPrice() {
        return mPrice;
    }

    public String getCategory() {
        return category;
    }

    public String getUrlImage() {
        return mUrlImage;
    }

    public Rating getRating() {
        return mRating;
    }
}
