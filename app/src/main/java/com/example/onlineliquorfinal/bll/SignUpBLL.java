package com.example.onlineliquorfinal.bll;

import com.example.onlineliquorfinal.URL.url;
import com.example.onlineliquorfinal.serverresponse.SignUpResponse;

import java.io.IOException;

import API.API;
import Model.User;
import retrofit2.Call;
import retrofit2.Response;

public class SignUpBLL {

    String firstname;
    String lastname;
    String address;
    String email;
    String phoneno;
    String username;
    String password;
    //String userType = "User";
    boolean isSuccess = false;

    public SignUpBLL(String firstname, String lastname, String address, String email, String phoneno, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.phoneno = phoneno;
        this.username = username;
        this.password = password;
    }

    public boolean register() {

        User userRegModel = new User(firstname, lastname, address, email, phoneno, username, password);

        API api = url.getInstance().create(API.class);

        Call<SignUpResponse> voidCall = api.register(userRegModel);

        try {
            Response<SignUpResponse> voidResponse = voidCall.execute();
            if (voidResponse.isSuccessful()) {
                isSuccess = true;
            }
        } catch (IOException e) {
            isSuccess =false;

        }
        return isSuccess;

    }
}
