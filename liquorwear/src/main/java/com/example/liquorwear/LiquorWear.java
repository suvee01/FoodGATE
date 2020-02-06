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

public class LiquorWear extends WearableActivity {
    private EditText et1,et2;
    private Button login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquor_wear);

        et1 = findViewById(R.id.username);
        et2 = findViewById(R.id.password);

        // Enables Always-on
        setAmbientEnabled();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void Login() {
        String username = et1.getText().toString();
        String password = et2.getText().toString();

        LoginBLL loginBLL = new LoginBLL();

//        StrictModeClass.StrictMode();
//        if (loginBLL.checkUser(username, password)) {
//            Intent intent = new Intent(LiquorWear.this, DashActivity.class);
//            startActivity(intent);
//            finish();
//
//        } else {
//            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
//            et1.requestFocus();
//        }

    }
}
