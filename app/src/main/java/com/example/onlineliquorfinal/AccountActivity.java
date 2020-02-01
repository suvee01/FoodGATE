package com.example.onlineliquorfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineliquorfinal.Fragment.AccountFragment;
import com.example.onlineliquorfinal.URL.url;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import API.API;
import Model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class AccountActivity extends AppCompatActivity {
   TextView fname, lname,address,phno,email,username;
    private FrameLayout accountframe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fname = findViewById(R.id.firstname);
        lname=findViewById(R.id.lstname);
        address=findViewById(R.id.uadd);
        phno=findViewById(R.id.uphone);
        email=findViewById(R.id.uemail);
        username=findViewById(R.id.user);
        loadCurrentUser();
        accountframe=findViewById(R.id.aframelayout);
        setFragment(new AccountFragment());
    }
    private void loadCurrentUser() {
        //user token access here from URL
         API api = url.getInstance().create(API.class);
        final Call<User> userCall = API.getUserDetails(token);

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
                fname.setText(firstName);
                lname.setText(lastName);
                address.setText(uaddress);
                phno.setText(uphone);
                email.setText(uemail);
                username.setText(susername);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void setFragment(AccountFragment accountFragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(accountframe.getId(),accountFragment);
        fragmentTransaction.commit();
    }
}
