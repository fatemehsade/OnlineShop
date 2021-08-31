package com.example.onlineshop.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.onlineshop.model.AllProduct;
import com.example.onlineshop.repository.ShopRepository;

import java.util.List;

public class ShopViewModel extends ViewModel {
    private final ShopRepository mRepository;

    public ShopViewModel() {
        mRepository=new ShopRepository();
    }

    public LiveData<List<AllProduct>> getAllProduct(){
        return mRepository.getAllProduct();
    }
}
