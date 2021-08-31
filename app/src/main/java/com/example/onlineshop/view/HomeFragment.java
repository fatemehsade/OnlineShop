package com.example.onlineshop.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlineshop.R;
import com.example.onlineshop.adapter.HomeAdapter;
import com.example.onlineshop.databinding.FragmentHomeBinding;
import com.example.onlineshop.model.AllProduct;
import com.example.onlineshop.viewModel.ShopViewModel;

import java.util.List;


public class HomeFragment extends Fragment {

    private static final String TAG = "com.example.onlineshop.viewHomeFragment";
    private FragmentHomeBinding mBinding;
    private ShopViewModel mViewModel;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding= DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_home,
                container,
                false);
        mViewModel=new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.getAllProduct().observe(getViewLifecycleOwner(), new Observer<List<AllProduct>>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onChanged(List<AllProduct> allProducts) {
                setUpAdapter(allProducts);

                Log.d(TAG, "onChanged: "+allProducts.size()
                );
            }
        });
    }

    private void setUpAdapter(List<AllProduct> allProducts) {
        HomeAdapter adapter=new HomeAdapter(allProducts);
        mBinding.recyclerHome.setLayoutManager(new LinearLayoutManager(requireActivity()));
        mBinding.recyclerHome.setAdapter(adapter);
    }
}