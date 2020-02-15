package com.example.onlineliquorfinal.Fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.onlineliquorfinal.CartActivity;
import com.example.onlineliquorfinal.CheckoutActivity;
import com.example.onlineliquorfinal.DashboardActivity;
import com.example.onlineliquorfinal.R;
import com.example.onlineliquorfinal.URL.url;

import java.util.List;

import API.API;
import Adapter.CartAdapter;
import Model.CartModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    RecyclerView recy_cart;
    Button btn_pro_order, btncontinueshop, checkout;
    
    public CartFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view= inflater.inflate(R.layout.fragment_cart, container, false);

        recy_cart= view.findViewById(R.id.recycart);
        recy_cart.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recy_cart.setHasFixedSize(true);
        btncontinueshop= view.findViewById(R.id.btnback);
        checkout=view.findViewById(R.id.btnplaceorder);

        btn_pro_order=view.findViewById(R.id.btnplaceorder);
        getCart();

        btncontinueshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i= new Intent(getContext(), DashboardActivity.class);
                    startActivity(i);
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getContext(), CheckoutActivity.class);
                startActivity(i);
            }
        });
        return (view);
    }

    private void getCart() {
        API api= url.getInstance().create(API.class);

        SharedPreferences sharedPreferences=this.getActivity().getSharedPreferences("User",MODE_PRIVATE);
        String uid = sharedPreferences.getString("id","");
        Call<List<CartModel>> listCall=api.getbyid(url.token);

        listCall.enqueue(new Callback<List<CartModel>>() {
            @Override
            public void onResponse(Call<List<CartModel>> call, Response<List<CartModel>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getView().getContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    return;
                }

                final List<CartModel> cartModels=response.body();
                CartAdapter adapter = new CartAdapter(getView().getContext(),cartModels);

                recy_cart.setAdapter(adapter);
                recy_cart.setLayoutManager(new LinearLayoutManager(getView().getContext()));
            }

            @Override
            public void onFailure(Call<List<CartModel>> call, Throwable t) {
                Toast.makeText(getView().getContext(),"error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}


