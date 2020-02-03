package com.example.onlineliquorfinal;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.onlineliquorfinal.Fragment.DashboardFragment;
import com.example.onlineliquorfinal.Fragment.ProductDetailFragment;

public class ProductDetailActivity extends AppCompatActivity {

    private FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        frameLayout=findViewById(R.id.pframelayout);
        setFragment(new ProductDetailFragment());






    }

    private void setFragment(ProductDetailFragment productDetailFragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),productDetailFragment);
        fragmentTransaction.commit();
    }


}
