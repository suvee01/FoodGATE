package com.example.onlineliquorfinal;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.onlineliquorfinal.Fragment.DashboardFragment;
import com.example.onlineliquorfinal.Fragment.ProductDetailFragment;
import com.example.onlineliquorfinal.URL.url;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductDetailActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    String product_name;
    String product_desc;
    int product_rate;
    CircleImageView product_img;
    String product_image;

    private TextView textViewName, textViewDesc, textViewRate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        product_img= findViewById(R.id.productimg);
        textViewName = findViewById(R.id.proname);
        textViewDesc = findViewById(R.id.prodesc);
        textViewRate = findViewById(R.id.prorate);
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


        frameLayout=findViewById(R.id.pframelayout);
//        setFragment(new ProductDetailFragment());






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