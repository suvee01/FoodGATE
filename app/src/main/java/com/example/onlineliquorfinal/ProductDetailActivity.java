package com.example.onlineliquorfinal;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private TextView proname, prodesc, prorate;
    private ImageView proimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        proname=(TextView) findViewById(R.id.proname);
        prodesc=(TextView)findViewById(R.id.prodesc);
        prorate=(TextView)findViewById(R.id.prorate);
        proimg=(ImageView)findViewById(R.id.productimg);

        Intent intent= getIntent();
        String name= intent.getExtras().getString("Name");
        String description= intent.getExtras().getString("Description");
        int rate= intent.getExtras().getInt("Rate");
        int image= intent.getExtras().getInt("Image");


proname.setText(name);
prodesc.setText(description);
prorate.setText(rate);
        proimg.setImageResource(image);
        ActionBar Name= getSupportActionBar();
        Name.setTitle(proname.getText().toString());



    }


}
