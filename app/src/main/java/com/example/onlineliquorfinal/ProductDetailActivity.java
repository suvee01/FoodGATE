package com.example.onlineliquorfinal;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.onlineliquorfinal.Fragment.DashboardFragment;
import com.example.onlineliquorfinal.Fragment.ProductdetailFragment;

public class ProductDetailActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mToggle;
    private FrameLayout frameLayout;

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
        setFragment(new ProductdetailFragment());
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
