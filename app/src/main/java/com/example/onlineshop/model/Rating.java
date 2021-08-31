package com.example.onlineshop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("rate")
    @Expose
    private float mRate;

    @SerializedName("count")
    @Expose
    public int mCount;

    public float getRate() {
        return mRate;
    }

    public int getCount() {
        return mCount;
    }
}
