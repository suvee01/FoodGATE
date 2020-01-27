package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineliquorfinal.R;

import java.util.List;

import Model.ProductModel;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

Context mcontext;
List<ProductModel> lstproduct;

public ProductAdapter(Context mcontext, List<ProductModel> lstproduct){
this.mcontext= mcontext;
this.lstproduct=lstproduct;
}


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(mcontext).inflate(R.layout.cardview_product, parent,false);
            return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductModel res=lstproduct.get(position);
        holder.imgpro.setImageResource(res.getProductimg());

    }

    @Override
    public int getItemCount() {
        return lstproduct.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

                ImageView imgpro;

    public ProductViewHolder(View itemView){
        super(itemView);
        imgpro= itemView.findViewById(R.id.product_img_id);

    }
    }
}
