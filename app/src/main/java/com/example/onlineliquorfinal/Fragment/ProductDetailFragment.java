package com.example.onlineliquorfinal.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.onlineliquorfinal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailFragment extends Fragment {
    String product_name;
    String product_desc;
    int product_rate;
    TextView textView_product_name;

    public ProductDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_detail, container, false);
        // Inflate the layout for this fragment
        product_name = getArguments().getString("product_name");
        product_desc = getArguments().getString("product_desc");
        product_rate = getArguments().getInt("product_rate");
        textView_product_name = view.findViewById(R.id.text_product_name);
        textView_product_name.setText(product_name);


        return view;
    }

}
