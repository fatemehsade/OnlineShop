package com.example.onlineshop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.onlineshop.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityAppCompatActivity";
    private ActivityMainBinding mBinding;
    private boolean isSelected=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController;
        //if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        //}
        mBinding.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home_menu:

                    if (isSelected){
                    }
                    navController.navigate(R.id.homeFragment);
                    return true;

                case R.id.profile_menu:
                    navController.navigate(R.id.profileFragment);

                    return true;

                case R.id.cart_menu:
                    navController.navigate(R.id.cartFragment);


                    return true;
                case R.id.favorite_menu:
                    navController.navigate(R.id.favoriteFragment);


                    return true;
            }
            return false;
        });
    }

}