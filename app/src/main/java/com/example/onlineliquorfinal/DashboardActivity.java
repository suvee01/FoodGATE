package com.example.onlineliquorfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineliquorfinal.Fragment.CartFragment;
import com.example.onlineliquorfinal.Fragment.DashboardFragment;
import com.google.android.material.navigation.NavigationView;
import com.example.onlineliquorfinal.URL.url;


import java.util.ArrayList;
import java.util.List;

import API.API;
import API.CategoryAPI;
import Adapter.CategoryAdapter;
import Model.CategoryModel;
import Model.ProductModel;

import Model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
//    Fragment selectedFragment=null;
    private ActionBarDrawerToggle mToggle;
    private FrameLayout frameLayout;
    private  TextView hname;

    public static List<CategoryModel> lstcat= new ArrayList<>();
    public static List<ProductModel> lstproduct = new ArrayList<>();
    private static final String TAG="DashboardActivity";
    RecyclerView.LayoutManager layoutManager;

    private RecyclerView rv_product;

   // private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();
        hname = findViewById(R.id.husername);

        rv_product = findViewById(R.id.cat_recyclerview);


//        SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
//        String display= sharedPreferences.getString("display","");
//        TextView info= (TextView) findViewById(R.id.husername);
//        info.setText(display);

        mDrawerLayout= findViewById(R.id.drawyerlayout);
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
      //  sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
//        String token = sharedPreferences.getString("token","");

//        if (token.equals(" ")){
//            Intent intent= new Intent(DashboardActivity.this,LoginActivity.class);
//            startActivity(intent);
//        }

//        lstcat=new ArrayList<>();
//        lstcat.add(new CategoryModel(R.drawable.beer,"Beer"));
//        lstcat.add(new CategoryModel(R.drawable.sig,"Whiskey"));
//        lstcat.add(new CategoryModel(R.drawable.ruslan,"Rum"));

        CategoryAPI categoryAPI= url.getInstance().create(CategoryAPI.class);
        Call<List<CategoryModel>> categorycall =categoryAPI.getAllCategory();

       categorycall.enqueue(new Callback<List<CategoryModel>>() {
           @Override
           public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
               lstcat = response.body();

//               CategoryAdapter ca = new CategoryAdapter(getApplicationContext(),lstcat);
//               rv_product.setAdapter(ca);
//               rv_product.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false));
           }

           @Override
           public void onFailure(Call<List<CategoryModel>> call, Throwable t) {

               Toast.makeText(DashboardActivity.this, "fail"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
               Log.e(TAG, "onFailure: "+t.getLocalizedMessage());

           }


       });





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
                Intent intent= new Intent(DashboardActivity.this,AccountActivity.class);
                startActivity(intent);
               // getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new ()).commit();
                break;

            case R.id.Logout:
                logout();
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout() {
        if(url.token!="Bearer"){
            url.token="Bearer";
        }

        Intent i= new Intent(DashboardActivity.this,LoginActivity.class);
        startActivity(i);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//
//    }


}
