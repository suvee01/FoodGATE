package com.example.onlineliquorfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseLongArray;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SystemClock.sleep(3000);
        Intent dashintent= new Intent(SplashActivity.this,LoginActivity.class);
        startActivity(dashintent);
        finish();
    }
}
