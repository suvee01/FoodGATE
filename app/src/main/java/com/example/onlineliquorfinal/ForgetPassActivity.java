package com.example.onlineliquorfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ForgetPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
