package com.example.onlineshop.netWork;

import com.example.onlineshop.model.AllProduct;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShopApiInterface {

    @GET("products")
    Call<List<AllProduct>> getAllProduct();
}
