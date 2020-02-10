package com.example.onlineliquorfinal.Fragment;


import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    public SensorManager sensorManager;
    Context context;
    String TAG= "DashboardFragment";


    public DashboardFragment() {
        // Required empty public constructor
    }
    private RecyclerView cat_recyclerview, rv_product;
    private TextView tvgyro;
    SearchView searchView;

    private List<CategoryModel> AllCategoryList = new ArrayList<>();
    private List<ProductModel> AllProductsList = new ArrayList<>();
    private List<ProductModel> SearchedProductList = new ArrayList<ProductModel>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        sensorGyro();

        View view= inflater.inflate(R.layout.fragment_dashboard, container, false);
        context = getContext();

        tvgyro= view.findViewById(R.id.tvgyro);
        rv_product= view.findViewById(R.id.recyproduct);
        searchView = view.findViewById(R.id.search);

        rv_product.setLayoutManager(new GridLayoutManager(getContext(),3));

        cat_recyclerview= view.findViewById(R.id.cat_recyclerview);
        cat_recyclerview.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.isEmpty()){
                    SearchedProductList = AllProductsList;
                }else {
                    SearchedProductList = new ArrayList<>();
                    for(ProductModel product:AllProductsList){
                        if(product.getProductname().contains(newText)){
                            SearchedProductList.add(product);
                        }
                    }
                }
//                rv_product.getAdapter().notifyDataSetChanged();
//                rv_product.getAdapter().notify();
                ProductAdapter adapter = new ProductAdapter(context,SearchedProductList);
                rv_product.setAdapter(adapter);
                return false;
            }
        });


        CategoryAPI productapi= url.getInstance().create(CategoryAPI.class);
        Call<List<ProductModel>> productcall= productapi.getAllProduct();
        productcall.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                Toast.makeText(context,"Product List Fetched",Toast.LENGTH_LONG).show();
                AllProductsList =response.body();
                SearchedProductList = AllProductsList;
                ProductAdapter pa=new ProductAdapter(context, SearchedProductList);
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
                AllCategoryList = response.body();
                CategoryAdapter ca = new CategoryAdapter(context,AllCategoryList);
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




//    private void sensorGyro() {
//        sensorManager=(SensorManager)context.getSystemService(SENSOR_SERVGYROSCOPEICE);
//        Sensor sensor= sensorManager.getDefaultSensor(Sensor.TYPE_);
//        SensorEventListener sensorEventListener= new SensorEventListener() {
//            @Override
//            public void onSensorChanged(SensorEvent event) {
//                if(event.values[1]<0){
//                    tvgyro.setText("Left");
//
//                }
//                else if (event.values[1]>0){
//                    tvgyro.setText("Right");
//                }
//            }
//
//            @Override
//            public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//            }
//        };
//        if(sensor!=null){
//            sensorManager.registerListener(sensorEventListener, sensor,SensorManager.SENSOR_DELAY_NORMAL);
//
//        }else {
//            Toast.makeText(context,"No sensor found",Toast.LENGTH_SHORT).show();
//
//        }
//
//
//    }


}
