package com.example.onlineshop.netWork;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShopRetrofit {
    public static final String BASE_URL="https://fakestoreapi.com/";
    private Retrofit mRetrofit;
    private static ShopRetrofit sInstance;

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public static ShopRetrofit getInstance() {
        if (sInstance==null){
            sInstance=new ShopRetrofit();
        }
        return sInstance;
    }

    private ShopRetrofit() {
        mRetrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
