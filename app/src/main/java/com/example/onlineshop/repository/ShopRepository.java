package com.example.onlineshop.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.onlineshop.model.AllProduct;
import com.example.onlineshop.netWork.ShopApiInterface;
import com.example.onlineshop.netWork.ShopRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopRepository {
    private ShopApiInterface mShopApiInterface;
    private final MutableLiveData<List<AllProduct>> allProductListLiveData=new MutableLiveData<>();

    public ShopRepository() {
        ShopRetrofit retrofit=ShopRetrofit.getInstance();
        mShopApiInterface=retrofit.getRetrofit().create(ShopApiInterface.class);
    }

    public LiveData<List<AllProduct>> getAllProduct(){
        Call<List<AllProduct>> call=mShopApiInterface.getAllProduct();
        call.enqueue(new Callback<List<AllProduct>>() {
            @Override
            public void onResponse(@NonNull Call<List<AllProduct>> call, @NonNull Response<List<AllProduct>> response) {
                allProductListLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<AllProduct>> call, Throwable t) {

            }
        });
        return allProductListLiveData;
    }

}
