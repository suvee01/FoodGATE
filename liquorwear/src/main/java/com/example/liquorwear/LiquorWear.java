package com.example.liquorwear;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liquorwear.URL.url;
import com.example.liquorwear.bll.LoginBLL;
import com.example.liquorwear.strictmode.StrictModeClass;

public class LiquorWear extends WearableActivity {


    private EditText et1,et2;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquor_wear);

        et1 = (EditText) findViewById(R.id.username);
        et2=(EditText) findViewById(R.id.password);
        login=(Button)findViewById(R.id.btn_login);

//        String message = getIntent().getStringExtra("Login Success");
//        if(message==null || message.equalsIgnoreCase("")){
//            message = "This is just a test";
//        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiquorWear.this, DashActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



}
