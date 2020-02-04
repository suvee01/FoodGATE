
package Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineliquorfinal.DashboardActivity;
import com.example.onlineliquorfinal.ProductDetailActivity;
import com.example.onlineliquorfinal.R;
import com.example.onlineliquorfinal.URL.url;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import Model.ProductModel;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.onlineliquorfinal.strictmode.StrictModeClass.StrictMode;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context mContext;
    List<ProductModel> lstproduct;

    public ProductAdapter(Context context, List<ProductModel> lstproduct){
        this.mContext= context;
        this.lstproduct=lstproduct;
    }


    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_product,parent,false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int position) {
        holder.productname.setText(lstproduct.get(position).getProductname());
        holder.productdesc.setText(lstproduct.get(position).getProductdesc());
        holder.prate.setText(String.valueOf(lstproduct.get(position).getRate()));
        String imgPath = url.BASE_URL + "uploads/" + lstproduct.get(position).getProductimg();
        StrictMode();
        try {
            URL url=new URL(imgPath);
            holder.imgpro.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (Exception e) {
        }
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ProductDetailActivity.class);
                intent.putExtra("product_image",lstproduct.get(position).getProductimg());
                intent.putExtra("product_name",lstproduct.get(position).getProductname());
                intent.putExtra("product_desc",lstproduct.get(position).getProductdesc());
                intent.putExtra("product_rate",lstproduct.get(position).getRate());
                ((DashboardActivity) mContext).startActivity(intent);
            }
        });



    }
    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public int getItemCount() {
        return lstproduct.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgpro;
        TextView productname;
        TextView productdesc;
        TextView prate;
        View view;


        public ProductViewHolder(View itemView){
            super(itemView);
            this.view = itemView;
            productname=itemView.findViewById(R.id.product_name_id);
            productdesc=itemView.findViewById(R.id.product_desc_id);
            imgpro= itemView.findViewById(R.id.product_img_id);
            prate= itemView.findViewById(R.id.product_rate_id);

        }
        public View getView(){
            return view;
        }
    }



}