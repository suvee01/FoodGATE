package com.example.onlineliquorfinal.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.onlineliquorfinal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    RecyclerView recy_cart;
    Button btn_pro_order;







    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view= inflater.inflate(R.layout.fragment_cart, container, false);

        recy_cart= view.findViewById(R.id.recycart);
        recy_cart.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recy_cart.setHasFixedSize(true);

        btn_pro_order=view.findViewById(R.id.btnplaceorder);
        loadCartItems();

        return (view);

    }

    private void loadCartItems() {
    }


}


