package API;

import Model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
 @POST("/users/login")
 Call<Void> login (@Body User user);

@POST ("/users/signup")
 Call<Void> register (@Body User regUser);
}
