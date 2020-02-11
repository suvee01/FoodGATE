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


    private EditText username,password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquor_wear);

        username = (EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.pass);
        login=(Button)findViewById(R.id.btn_login);

//        String message = getIntent().getStringExtra("Login Success");
//        if(message==null || message.equalsIgnoreCase("")){
//            message = "This is just a test";
//        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              dashlogin();
            }
        });
    }

    private void dashlogin() {

        String susername = username.getText().toString();
        String spassword = password.getText().toString();

        LoginBLL loginBLL = new LoginBLL();

        StrictModeClass.StrictMode();
        if (loginBLL.checkUser(susername, spassword)) {
//            Intent intent = new Intent(LiquorWear.this, DashActivity.class);
//            startActivity(intent);
//            finish();
            Toast.makeText(this, url.token, Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            username.requestFocus();

        }
    }

}
