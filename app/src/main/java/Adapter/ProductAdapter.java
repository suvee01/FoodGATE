package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineliquorfinal.DashboardActivity;
import com.example.onlineliquorfinal.ProductDetailActivity;
import com.example.onlineliquorfinal.R;

import java.util.List;

import Model.ProductModel;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context mContent;
    List<ProductModel> lstproduct;

    public ProductAdapter(Context mcontent, List<ProductModel> lstproduct){
        this.mContent= mcontent;
        this.lstproduct=lstproduct;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContent).inflate(R.layout.cardview_product, parent,false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int position) {


        ProductModel res=lstproduct.get(position);

        holder.productname.setText(lstproduct.get(position).getProductname());
        holder.productdesc.setText(lstproduct.get(position).getProductdesc());
        holder.imgpro.setImageResource(lstproduct.get(position).getProductimg());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mContent, ProductDetailActivity.class);
                mContent.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lstproduct.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imgpro;
        TextView productname;
        CardView cardview;
        TextView productdesc;


        public ProductViewHolder(View itemView){
            super(itemView);

            productname=itemView.findViewById(R.id.product_name_id);
            productdesc=itemView.findViewById(R.id.product_desc_id);
            imgpro= itemView.findViewById(R.id.product_img_id);
            cardview=itemView.findViewById(R.id.cardview);

        }
    }
}