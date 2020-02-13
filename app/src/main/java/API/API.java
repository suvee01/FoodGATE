package API;

import com.example.onlineliquorfinal.serverresponse.SignUpResponse;

import java.util.List;

import Model.CartModel;
import Model.LoginResponse;
import Model.User;
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
 Call<SignUpResponse> checkUser (@Field("username") String username,@Field("password") String password);

@POST ("/users/signup")
 Call<SignUpResponse> register (@Body User regUser);

 @GET("users/me")
  Call<User> getUserDetails(@Header("authorization")String token);

 @GET("/users/cart")
 Call<List<CartModel>> getbyid(@Header("Authorization") String token);

}
