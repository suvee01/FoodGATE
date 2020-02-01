package Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineliquorfinal.R;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import Model.CategoryModel;
import URL.url;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.http.Url;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    Context mContext;
     List<CategoryModel> categoryModelList;

    public CategoryAdapter(Context context, List<CategoryModel> categoryModelList) {
        this.mContext= mContext;
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder viewHolder, int position) {

//       CategoryModel pc=categoryModelList.get(position);
//        viewHolder.category_icon.setImageResource(pc.getCat_img());
//        viewHolder.category_name.setText(categoryModelList.get(position).getCat_name());

      CategoryModel cat = categoryModelList.get(position);
        //holder.category_img.setImageResource(cat.getImage());

        String imgPath = url.BASE_URL + "uploads/" + cat.getCat_img();
        StrictMode();
        try {
           URL url=new URL(imgPath);
            viewHolder.category_icon.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (Exception e) {
        }
        viewHolder.category_name.setText(cat.getCat_name());
    }
    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

     CircleImageView category_icon;
       TextView category_name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category_icon= itemView.findViewById(R.id.catimage);
            category_name=itemView.findViewById(R.id.catname);
        }

        public static void setcCategory_name(String name) {
        }

        private void setcategory_icon(){

        }

        private void setcategory_name(String name){

            category_name.setText(name);
        }
    }
}
