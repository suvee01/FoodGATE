package API;

import java.util.List;

import Model.LoginResponse;
import Model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface API {
 @POST("/users/login")
 Call<LoginResponse> login (@Body User user);

@POST ("/users/signup")
 Call<Void> register (@Body User regUser);
 @GET("users/me")
  Call<User> getUserDetails(@Header("Authorization") String token);

}
