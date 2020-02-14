package com.example.onlineliquorfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.Dash;

public class CheckoutActivity extends AppCompatActivity {

    Button order;
    TextView quantity,total ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        order= findViewById(R.id.order);
        quantity= findViewById(R.id.quantity);
        total=findViewById(R.id.totalcharge);



        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(CheckoutActivity.this,"You have placed an order",Toast.LENGTH_SHORT).show();
                Intent i= new Intent(CheckoutActivity.this, DashboardActivity.class);
                startActivity(i);

            }
        });



    }
}
