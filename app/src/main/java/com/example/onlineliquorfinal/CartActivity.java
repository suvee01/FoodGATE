package com.example.onlineliquorfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineliquorfinal.Fragment.CartFragment;
import com.example.onlineliquorfinal.Fragment.DashboardFragment;
import com.example.onlineliquorfinal.URL.url;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import Adapter.CartAdapter;
import Model.ProductModel;

public class CartActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    String product_name;
    String product_rate;
    String product_image;
    ImageView product_img;
    Double total;
    String quantity;
    ImageButton remove;
    private FrameLayout cframelayout;
    private TextView textViewName,textViewRate,textViewQuantity, textViewTotal,totaltxt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cframelayout=findViewById(R.id.cartframelayout);
        product_img = findViewById(R.id.cartimgproduct);
        textViewName= findViewById(R.id.txtcproname);
        textViewRate = findViewById(R.id.txtcprate);
        textViewQuantity = findViewById(R.id.txtquant);
        textViewTotal= findViewById(R.id.total);
        totaltxt=findViewById(R.id.totalamount);
        remove=findViewById(R.id.cart_remove);

        ImageButton imageButton = findViewById(R.id.cart_remove);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this,"Cart Removed",Toast.LENGTH_SHORT).show();
                textViewName.setText("");
                textViewRate.setText("");
                textViewQuantity.setText("");
                textViewTotal.setText("");
                totaltxt.setText("");
                product_img.setVisibility(View.INVISIBLE);
                remove.setVisibility(View.INVISIBLE);


            }
        });

        setFragment(new CartFragment());

        Bundle extras =getIntent().getExtras();
        if(extras!=null){
            product_image=extras.getString("product_img");
            product_rate=extras.getString("textViewRate");
            product_name=extras.getString("textViewName");
            quantity=extras.getString("quantity");
            textViewName.setText(product_name);
            textViewRate.setText(product_rate);
            textViewQuantity.setText(quantity);
            total= Double.parseDouble(product_rate)* Double.parseDouble(quantity);
            textViewTotal.setText(String.valueOf(total));

            String imgPath = url.BASE_URL + "uploads/" + product_image;
            try {
                URL url=new URL(imgPath);
                product_img.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
            } catch (Exception e) {
            }
        }
   }

    private void setFragment(CartFragment cartFragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(cframelayout.getId(),cartFragment);
        fragmentTransaction.commit();
    }
}
