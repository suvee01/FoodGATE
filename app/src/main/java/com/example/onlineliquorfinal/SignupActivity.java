package com.example.onlineliquorfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import API.API;
import Model.User;
import URL.URL;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private EditText etfname,etlname, etaddress,etphone,etemail,etusername,etpassword;
    private Button signup;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etfname = findViewById(R.id.fname);
        etlname = findViewById(R.id.lname);
        etaddress = findViewById(R.id.address);
        etphone = findViewById(R.id.phone);
        etemail = findViewById(R.id.email);
        etusername = findViewById(R.id.username);
        etpassword = findViewById(R.id.password);
        signup= findViewById(R.id.btn_signup);
        login = findViewById(R.id.tvlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user= new User(etfname.getText().toString(), etlname.getText().toString(), etaddress.getText().toString(), etphone.getText().toString(), etemail.getText().toString(), etusername.getText().toString(), etpassword.getText().toString());
                API api= URL.getInstance().create(API.class);
                Call<Void> call= api.register(user);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(SignupActivity.this, "Unable to register"+ response.message(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Intent i= new Intent(SignupActivity.this, MainActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(SignupActivity.this, "Error"+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


    }
}
