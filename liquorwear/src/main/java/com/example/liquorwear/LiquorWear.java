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


    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquor_wear);

        mTextView = (TextView) findViewById(R.id.text);
        String message = getIntent().getStringExtra("message");
        if(message==null || message.equalsIgnoreCase("")){
            message = "This is just a test";
        }
    }

    private void Login() {



    }
}
