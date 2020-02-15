package com.example.onlineliquorfinal.bll;

import com.example.onlineliquorfinal.URL.url;
import com.example.onlineliquorfinal.serverresponse.SignUpResponse;

import java.io.IOException;

import API.API;
import Model.User;
import retrofit2.Call;
import retrofit2.Response;

public class SignUpBLL {

    String firstName;
    String lastName;
    String address;
    String email;
    String phoneno;
    String username;
    String password;
    boolean isSuccess=false;

    public SignUpBLL(String firstName, String lastName, String address, String email, String phoneno, String username, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneno = phoneno;
        this.username = username;
        this.password = password;
    }
    public boolean register() {

        User userRegModel = new User(firstName, lastName, address, email, phoneno, username, password);

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
