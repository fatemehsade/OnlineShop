package com.example.onlineshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.onlineshop.R;
import com.example.onlineshop.databinding.HomeItemBinding;
import com.example.onlineshop.model.AllProduct;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private List<AllProduct> mAllProductList;
    private Context mContext;

    public HomeAdapter(List<AllProduct> allProductList) {
        mAllProductList = allProductList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext=parent.getContext();
        HomeItemBinding binding=
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.home_item,
                        parent,
                        false);
        return new HomeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        AllProduct product=mAllProductList.get(position);
        holder.mBinding.txtTitleProduct.setText(product.getTitle());
        holder.mBinding.txtDescriptionProduct.setText(product.getDescription());
        holder.mBinding.txtPriceProduct.setText((int) product.getPrice());
        Glide.with(mContext).load(product.getUrlImage()).into(holder.mBinding.imgProduct);

    }

    @Override
    public int getItemCount() {
        return mAllProductList.size();
    }


    public static class HomeViewHolder extends RecyclerView.ViewHolder {
        private HomeItemBinding mBinding;
        public HomeViewHolder(@NonNull HomeItemBinding binding) {
            super(binding.getRoot());
            mBinding=binding;
        }
    }
}
