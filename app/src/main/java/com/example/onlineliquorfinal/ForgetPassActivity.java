package com.example.onlineliquorfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ForgetPassActivity extends AppCompatActivity {

    public Button resetpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        resetpass=findViewById(R.id.btn_reset);

        resetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ForgetPassActivity.this,"Please check your email",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
