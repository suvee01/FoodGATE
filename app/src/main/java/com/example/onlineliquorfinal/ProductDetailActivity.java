package com.example.onlineliquorfinal;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.onlineliquorfinal.Fragment.CartFragment;
import com.example.onlineliquorfinal.Fragment.DashboardFragment;
import com.example.onlineliquorfinal.Fragment.ProductDetailFragment;
import com.example.onlineliquorfinal.URL.url;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;

public class ProductDetailActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    String product_name;
    String product_desc;
    int product_rate;
    CircleImageView product_img;
    String product_image;
    private Button Order;

    private TextView textViewName, textViewDesc, textViewRate;
    private ElegantNumberButton quantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        product_img= findViewById(R.id.productimg);
        textViewName = findViewById(R.id.proname);
        textViewDesc = findViewById(R.id.prodesc);
        textViewRate = findViewById(R.id.prorate);

        quantity =findViewById(R.id.txtamount);
        quantity.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String product_detail_quantity = quantity.getNumber();
            }
        });
        quantity.getNumber();
        Order= findViewById(R.id.btnorder);
        Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class);
                intent.putExtra("textViewName",textViewName.getText().toString());
                intent.putExtra("textViewRate",textViewRate.getText().toString());
                intent.putExtra("product_img",product_image);
                intent.putExtra("quantity",quantity.getNumber());
                startActivity(intent);
            }
        });
        Bundle extras = getIntent().getExtras();
        if(extras!=null){

            product_image=extras.getString("product_image");
            product_name = extras.getString("product_name");
            product_desc = extras.getString("product_desc");
            product_rate = extras.getInt("product_rate");
            textViewName.setText(product_name);
            textViewDesc.setText(product_desc);
            textViewRate.setText(String.valueOf(product_rate));
//            product_img.setImageURI(URI.create(url.BASE_URL + "uploads/" + product_image));
            String imgPath = url.BASE_URL + "uploads/" + product_image;
            try {
                URL url=new URL(imgPath);
                product_img.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
            } catch (Exception e) {
            }
        }








    }

//    private void setFragment(ProductDetailFragment productDetailFragment) {
//        Bundle bundle = new Bundle();
//        bundle.putString("product_name",product_name);
//        bundle.putString("product_desc",product_desc);
//        bundle.putInt("product_rate",product_rate);
//        productDetailFragment.setArguments(bundle);
//        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(frameLayout.getId(),productDetailFragment);
//        fragmentTransaction.commit();
//    }


}