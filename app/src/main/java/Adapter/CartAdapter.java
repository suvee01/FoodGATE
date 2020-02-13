package Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.onlineliquorfinal.CartActivity;
import com.example.onlineliquorfinal.ProductDetailActivity;
import com.example.onlineliquorfinal.R;
import com.example.onlineliquorfinal.URL.url;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import Model.CartModel;
import Model.ProductModel;

import static com.example.onlineliquorfinal.strictmode.StrictModeClass.StrictMode;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{

    Context context;
    List<CartModel> cartModels;
    CartAdapter a= this;

    public CartAdapter(Context context, List<CartModel> cartmodels) {
        this.context = context;
        this.cartModels = cartmodels;
    }
    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(context).inflate(R.layout.cart_layout,parent,false);

        return new CartViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull CartViewHolder cartViewHolder, final int position) {

        cartViewHolder.txt_productname.setText(cartModels.get(position).getProductcart().getProductname());
        cartViewHolder.txt_productrate.setText(new StringBuilder("Rs").append(cartModels.get(position).getProductcart().getRate()));
        cartViewHolder.txtquantity.setNumber(String.valueOf(cartModels.get(position).getProductcart().getAmount()));
        String imgPath = url.BASE_URL + "uploads/" + cartModels.get(position).getProductcart().getProductimg();
        cartViewHolder.cart_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"DElete",Toast.LENGTH_SHORT).show();
                Log.d("Viewholder", "Clicked on view");
            }
        });
//
//        cartViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CharSequence options[]= new CharSequence[]
//                        {
//                                "Edit",
//                                "Delete"
//                        };
//                AlertDialog.Builder builder= new AlertDialog.Builder(context);
//                builder.setTitle("Cart Options:");
//                builder.setItems(options, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int i) {
//
//                        if(i==0)
//                        {
//                                    cartModels
//                        }
//
//                    }
//                });
//            }
//        });

//        removeSelected();
        StrictMode();

        try {
            URL url=new URL(imgPath);
            cartViewHolder.img_product.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (Exception e) {
        }
        cartViewHolder.txtquantity.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
//                Product cart= cartModels.get();
//                cart.getQuantity()= newValue;
//                Common.cartRepository.updateCart(cart);

                //Log.d(TAG, String.format("oldValue: %d   newValue: %d", oldValue, newValue));
            }
        });
    }
//    public static void removeSelected() {
//
////        for(CartModel cart : cartModels){
////            if(cartModels.get(i).selected){
////                cartModels.remove(i);
////            }
////        }
////        notifyDataSetChanged();
//    }

    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img_product;
        TextView txt_productname,txt_productrate;
        ElegantNumberButton txtquantity;
        View view;
        ImageButton cart_remove;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            img_product=(ImageView)itemView.findViewById(R.id.cartimgproduct);
            txt_productname=(TextView)itemView.findViewById(R.id.txtcproname);
            txt_productrate=(TextView)itemView.findViewById(R.id.txtcprate);
            txtquantity=(ElegantNumberButton) itemView.findViewById(R.id.txtquant);
            cart_remove = (ImageButton) itemView.findViewById(R.id.cart_remove);
        }
//        public View getView(){
//            return view;
//        }
        }
    }

