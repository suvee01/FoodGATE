package Adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.onlineliquorfinal.R;

import org.w3c.dom.Text;

import java.util.List;

import Model.ProductModel;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{

    Context context;
    List<ProductModel> productlst;

    public CartAdapter(Context context, List<ProductModel> productlst) {
        this.context = context;
        this.productlst = productlst;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(context).inflate(R.layout.activity_cart,parent,false);

        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, final int position) {
        holder.img_product.setImageResource(Integer.parseInt(productlst.get(position).getProductimg()));
        holder.txt_productname.setText(productlst.get(position).getProductname());
        holder.txtproduct_quant.setText(productlst.get(position).getProductdesc());
        holder.txtproduct_rate.setText(new StringBuilder("Rs").append(productlst.get(position).rate));
        holder.txtamount.setNumber(String.valueOf(productlst.get(position).amount));

//
//        holder.txtamount.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
//            @Override
//            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
//                ProductModel cart= productlst.get(position);
//                cart.amount= newValue;
//                Common.cartRepository.updateCart(cart);
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return productlst.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img_product;
        TextView txt_productname,txtproduct_quant,txtproduct_rate;
        ElegantNumberButton txtamount;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            img_product=(ImageView)itemView.findViewById(R.id.cartimgproduct);
            txt_productname=(TextView)itemView.findViewById(R.id.txtcproname);
            txtamount=(ElegantNumberButton)itemView.findViewById(R.id.txtamount);
            txtproduct_quant=(TextView)itemView.findViewById(R.id.txtquant);
            txtproduct_rate=(TextView)itemView.findViewById(R.id.txtcprate);
        }
    }
}
