package com.example.onlineliquorfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineliquorfinal.URL.url;
import static com.example.onlineliquorfinal.URL.url.token;

import API.API;
import Model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountActivity extends AppCompatActivity {
   TextView fname, lname,address,phno,email,username;
    private FrameLayout accountframe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fname = findViewById(R.id.firstname);
       // lname=findViewById(R.id.lstname);
        address=findViewById(R.id.uadd);
        phno=findViewById(R.id.uphone);
        email=findViewById(R.id.uemail);
        username=findViewById(R.id.user);

        accountframe=findViewById(R.id.aframelayout);
        loadCurrentUser();
    }
    private void loadCurrentUser() {
        //user token access here from URL
        API usersAPI = url.getInstance().create(API.class);
        Call<User>userCall= usersAPI.getUserDetails(token);

        userCall.enqueue(new Callback<User>(){


            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(AccountActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                String firstName = response.body().getFirstName();
                String lastName= response.body().getLastName();
                String uaddress= response.body().getAddress();
                String uphone= response.body().getPhoneno();
                String uemail= response.body().getEmail();
                String susername=response.body().getUsername();
                fname.setText(firstName + lastName);
//                lname.setText(lastName);
                address.setText(uaddress);
                phno.setText(uphone);
                email.setText(uemail);
                username.setText(susername);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Toast.makeText(AccountActivity.this, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
