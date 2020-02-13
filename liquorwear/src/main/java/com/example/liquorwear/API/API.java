package com.example.liquorwear.API;

import com.example.liquorwear.Model.User;
import com.example.liquorwear.serverresponse.SignUpResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface API {
 @FormUrlEncoded
 @POST("/users/login")
 Call<SignUpResponse> checkUser(@Field("username") String username, @Field("password") String password);
//
//@POST ("/users/signup")
// Call<SignUpResponse> register(@Body User regUser);



}
