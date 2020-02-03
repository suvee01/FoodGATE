package API;

import java.util.List;

import Model.CategoryModel;
import Model.ProductModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryAPI {
    @GET("users/categories")
    Call<List<CategoryModel>> getAllCategory();

    @GET("users/product")
    Call<List<ProductModel>> getAllProduct();



}
