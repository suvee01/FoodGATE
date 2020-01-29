package com.example.onlineliquorfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.onlineliquorfinal.Fragment.AccountFragment;
import com.example.onlineliquorfinal.Fragment.CartFragment;
import com.example.onlineliquorfinal.Fragment.DashboardFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import Model.CategoryModel;
import Model.ProductModel;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    Fragment selectedFragment=null;
    private ActionBarDrawerToggle mToggle;
    private FrameLayout frameLayout;

    public static List<CategoryModel> lstcat= new ArrayList<>();
    public static List<ProductModel> lstproduct = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;

    private RecyclerView rv_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();

        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawyerlayout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar = findViewById(R.id.app_bar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(DashboardActivity.this,CartActivity.class);
                startActivity(i);
            }
        });

        mToggle= new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        lstcat=new ArrayList<>();
        lstcat.add(new CategoryModel(R.drawable.beer,"Beer"));
        lstcat.add(new CategoryModel(R.drawable.sig,"Whiskey"));
        lstcat.add(new CategoryModel(R.drawable.ruslan,"Rum"));

        lstproduct=new ArrayList<>();
        lstproduct.add(new ProductModel(R.drawable.beer,"Beer","70ml",70));
        lstproduct.add(new ProductModel(R.drawable.sig,"Whiskey","70ml",80));
        lstproduct.add(new ProductModel(R.drawable.ruslan,"Rum","70ml",80));
        lstproduct.add(new ProductModel(R.drawable.goak,"Golden Oak","70ml",80));
        lstproduct.add(new ProductModel(R.drawable.oak,"Black OAK","70ml",80));
        lstproduct.add(new ProductModel(R.drawable.rum,"Khukuri","70ml",80));
        lstproduct.add(new ProductModel(R.drawable.ruslan,"Rum","70ml",80));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        frameLayout=findViewById(R.id.framelayout);
        setFragment(new DashboardFragment());
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id=menuItem.getItemId();

        switch (menuItem.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new DashboardFragment()).commit();

            break;

            case R.id.Cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new CartFragment()).commit();
                break;
            case  R.id.Account:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new AccountFragment()).commit();
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//
//    }
}
