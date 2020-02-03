package com.example.onlineliquorfinal.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.onlineliquorfinal.ProductDetailActivity;
import com.example.onlineliquorfinal.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.CategoryAdapter;
import Adapter.ProductAdapter;
import Model.CategoryModel;
import Model.ProductModel;

import static com.example.onlineliquorfinal.DashboardActivity.lstcat;
import static com.example.onlineliquorfinal.DashboardActivity.lstproduct;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {




    public DashboardFragment() {
        // Required empty public constructor
    }
    private RecyclerView cat_recyclerview, rv_product;
    private CardView cardView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dashboard, container, false);
        cat_recyclerview= view.findViewById(R.id.cat_recyclerview);
        rv_product= view.findViewById(R.id.recyproduct);


        CategoryAdapter categoryAdapter= new CategoryAdapter(getContext(),lstcat);
        cat_recyclerview.setAdapter(categoryAdapter);
        cat_recyclerview.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        ProductAdapter productAdapter= new ProductAdapter(getContext(),lstproduct);
        rv_product.setAdapter(productAdapter);
        rv_product.setLayoutManager(new GridLayoutManager(getContext(),3));



        return view;


    }

}