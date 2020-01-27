package Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineliquorfinal.R;

import java.util.List;

import Model.CategoryModel;

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

       CategoryModel pc=categoryModelList.get(position);
        viewHolder.category_icon.setImageResource(pc.getCat_img());


    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView category_icon;
        private TextView category_name;


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
