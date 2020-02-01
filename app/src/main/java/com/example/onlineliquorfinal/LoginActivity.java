package com.example.onlineliquorfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import API.API;
import Model.LoginResponse;
import Model.User;
import com.example.onlineliquorfinal.URL.url;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText et1,et2;
    private Button login;
    private TextView LoginWithGG;
    private TextView signup, Forgetpass;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1 = findViewById(R.id.username);
        et2 = findViewById(R.id.password);
        login = findViewById(R.id.btn_login);
        LoginWithGG=findViewById(R.id.btnGG);
        Forgetpass=findViewById(R.id.forgot_password);
        signup=findViewById(R.id.tvsignup);


        Forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(LoginActivity.this, ForgetPassActivity.class );
                startActivity(i);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(LoginActivity.this, SignupActivity.class );
                startActivity(i);
            }
        });
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        User user= new User(et1.getText().toString(), et2.getText().toString());
                    API api= url.getInstance().create(API.class);
                    Call<LoginResponse>call= api.login(user);

                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if(!response.isSuccessful()){
                                Toast.makeText(LoginActivity.this, "Login error" + response.message(), Toast.LENGTH_SHORT).show();
                                vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
                                vibrator.vibrate(50);
                                return;
                            }
                            System.out.println(response.body().getToken());
                            Intent i= new Intent(LoginActivity.this, DashboardActivity.class);
                            startActivity(i);
                        }



                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {

                        Toast.makeText(LoginActivity.this, "Error: "+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();


                        }
                    });


                }
            });

            LoginWithGG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(LoginActivity.this,"You have clicked on Google Login",Toast.LENGTH_SHORT).show();
                }
            });
    }

//
                        public void openSignup(){
                    Intent openSignup= new Intent(this, SignupActivity.class);
                        startActivity(openSignup);
                        }
}
