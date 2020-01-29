package com.example.onlineliquorfinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlineliquorfinal.Fragment.DashboardFragment;
import com.example.onlineliquorfinal.Fragment.ProductdetailFragment;

public class ProductDetailActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mToggle;
    private FrameLayout frameLayout;
    private TextView productname, product_desc;
    private ImageView image;
    private TextView rate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawyerlayout);
        Toolbar toolbar = findViewById(R.id.app_bar);

        mToggle= new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        frameLayout=findViewById(R.id.pframelayout);
        /*setFragment(new ProductdetailFragment());

        productname=(TextView)findViewById(R.id.txtname);
        product_desc=(TextView)findViewById(R.id.prodesc);
        image=(ImageView) findViewById(R.id.productimg);
        rate=(TextView)findViewById(R.id.rate);
*/


        Intent intent=getIntent();
        String pname=intent.getExtras().getString("ProductName");
        String Description=intent.getExtras().getString("Description");
        int pimage=intent.getExtras().getInt("Image");
        int prate= intent.getExtras().getInt("Rate");

        System.out.println("the intent data is: "+pname);
        productname.setText(pname);
        product_desc.setText(Description);
        rate.setText(prate);
        image.setImageResource(pimage);
        ActionBar name=getSupportActionBar();
        name.setTitle(productname.getText().toString());

        

    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }


        return super.onOptionsItemSelected(item);


    }


    private void setFragment(ProductdetailFragment productdetailFragment) {

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),productdetailFragment);
        fragmentTransaction.commit();
    }
}
