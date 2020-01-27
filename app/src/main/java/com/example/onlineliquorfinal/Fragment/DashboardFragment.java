package com.example.onlineliquorfinal.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.onlineliquorfinal.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.CategoryAdapter;
import Model.CategoryModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {




    public DashboardFragment() {
        // Required empty public constructor
    }
    private RecyclerView cat_recyclerview;

    private CategoryAdapter categoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dashboard, container, false);
        cat_recyclerview= view.findViewById(R.id.cat_recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        cat_recyclerview.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList= new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("Categoryimage","Beer"));
        categoryModelList.add(new CategoryModel("Categoryimage","Whiskey"));
        categoryModelList.add(new CategoryModel("Categoryimage","Vodka"));
        categoryModelList.add(new CategoryModel("Categoryimage","Rum"));
        categoryModelList.add(new CategoryModel("Categoryimage","Tequilla"));
        categoryModelList.add(new CategoryModel("Categoryimage","Tequilla"));
        categoryModelList.add(new CategoryModel("Categoryimage","Tequilla"));
        categoryModelList.add(new CategoryModel("Categoryimage","Tequilla"));

        categoryAdapter= new CategoryAdapter(categoryModelList);
            cat_recyclerview.setAdapter(categoryAdapter);
            categoryAdapter.notifyDataSetChanged();

        return view;
    }

}
