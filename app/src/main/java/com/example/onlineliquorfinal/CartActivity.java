package com.example.onlineliquorfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.onlineliquorfinal.Fragment.CartFragment;
import com.example.onlineliquorfinal.Fragment.DashboardFragment;

import java.util.ArrayList;
import java.util.List;

import Model.ProductModel;

public class CartActivity extends AppCompatActivity {

    private FrameLayout cframelayout;
    RecyclerView.LayoutManager layoutManager;
    public static List<ProductModel> lstproduct = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cframelayout=findViewById(R.id.cartframelayout);
        setFragment(new CartFragment());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void setFragment(CartFragment cartFragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(cframelayout.getId(),cartFragment);
        fragmentTransaction.commit();
    }
}
