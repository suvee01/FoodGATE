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
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int position) {


        ProductModel res=lstproduct.get(position);

        holder.productname.setText(lstproduct.get(position).getProductname());
        holder.productdesc.setText(lstproduct.get(position).getProductdesc());
        holder.imgpro.setImageResource(lstproduct.get(position).getProductimg());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mcontext, ProductdetailFragment.class);

                intent.putExtra("Name",lstproduct.get(position).getProductname());
                intent.putExtra("Description",lstproduct.get(position).getProductdesc());
                intent.putExtra("Image",lstproduct.get(position).getProductimg());

                mcontext.startActivity(intent);
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
                CardView cardView;
                TextView productdesc;


    public ProductViewHolder(View itemView){
        super(itemView);

        productname=itemView.findViewById(R.id.product_name_id);
        productdesc=itemView.findViewById(R.id.product_desc_id);
        imgpro= itemView.findViewById(R.id.product_img_id);
        cardView=itemView.findViewById(R.id.cardview);

    }
    }
}
