package com.example.onlineliquorfinal.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.onlineliquorfinal.DashboardActivity;
import com.example.onlineliquorfinal.ProductDetailActivity;
import com.example.onlineliquorfinal.R;
import com.example.onlineliquorfinal.URL.url;

import java.util.ArrayList;
import java.util.List;

import API.CategoryAPI;
import Adapter.CategoryAdapter;
import Adapter.ProductAdapter;
import Model.CategoryModel;
import Model.ProductModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.onlineliquorfinal.DashboardActivity.lstcat;
import static com.example.onlineliquorfinal.DashboardActivity.lstproduct;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    Context context;
    String TAG= "DashboardFragment";




    public DashboardFragment() {
        // Required empty public constructor
    }
    private RecyclerView cat_recyclerview, rv_product;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_dashboard, container, false);
        context = getContext();

        rv_product= view.findViewById(R.id.recyproduct);
        rv_product.setLayoutManager(new GridLayoutManager(getContext(),3));

        cat_recyclerview= view.findViewById(R.id.cat_recyclerview);
        cat_recyclerview.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));


        CategoryAPI productapi= url.getInstance().create(CategoryAPI.class);
        Call<List<ProductModel>> productcall= productapi.getAllProduct();
        productcall.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                Toast.makeText(context,"Product List Fetched",Toast.LENGTH_LONG).show();
                lstproduct=response.body();
                ProductAdapter pa=new ProductAdapter(context,lstproduct);
                rv_product.setAdapter(pa);
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                Toast.makeText(context, "Product fail"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: "+t.getLocalizedMessage());
            }
        });

        CategoryAPI categoryAPI= url.getInstance().create(CategoryAPI.class);
        Call<List<CategoryModel>> categorycall =categoryAPI.getAllCategory();

        categorycall.enqueue(new Callback<List<CategoryModel>>() {
            @Override
            public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
                Toast.makeText(context,"Category List Fetched",Toast.LENGTH_LONG).show();
                lstcat = response.body();
                CategoryAdapter ca = new CategoryAdapter(context,lstcat);
                cat_recyclerview.setAdapter(ca);
            }

            @Override
            public void onFailure(Call<List<CategoryModel>> call, Throwable t) {

                Toast.makeText(context, "Category fail"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: "+t.getLocalizedMessage());

            }
        });
        return view;
    }



}
