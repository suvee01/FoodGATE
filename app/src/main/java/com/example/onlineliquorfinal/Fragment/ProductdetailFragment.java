package com.example.onlineliquorfinal.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlineliquorfinal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductdetailFragment extends Fragment {


    public ProductdetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_productdetail, container, false);
    }

}
