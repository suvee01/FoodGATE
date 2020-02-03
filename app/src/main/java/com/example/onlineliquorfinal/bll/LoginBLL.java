package com.example.onlineliquorfinal.bll;

import com.example.onlineliquorfinal.URL.url;
import com.example.onlineliquorfinal.serverresponse.SignUpResponse;
import java.io.IOException;
import API.API;
import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {

    boolean isSuccess = false;

    public boolean checkUser(String username, String password) {

        API api = url.getInstance().create(API.class);
        Call<SignUpResponse> usersCall = api.checkUser(username, password);

        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if(loginResponse.code()==200)
            {

                url.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
