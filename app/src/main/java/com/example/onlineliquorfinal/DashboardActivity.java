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

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineliquorfinal.Fragment.CartFragment;
import com.example.onlineliquorfinal.Fragment.DashboardFragment;
import com.google.android.material.navigation.NavigationView;
import com.example.onlineliquorfinal.URL.url;


import org.w3c.dom.Text;

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
    Context context;
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mToggle;
    private FrameLayout frameLayout;
    private  TextView hname;
    SearchView searchView;
    public static List<CategoryModel> lstcat= new ArrayList<>();
    public static List<ProductModel> lstproduct = new ArrayList<>();
    private static final String TAG="DashboardActivity";

    private TextView hUsername;
    private TextView hEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        context  = this;
        getSupportActionBar().hide();
        mDrawerLayout= findViewById(R.id.drawyerlayout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = LayoutInflater.from(context).inflate(R.layout.header,null);
        navigationView.addHeaderView(headerView);

        hUsername = headerView.findViewById(R.id.husername);
        hEmail = headerView.findViewById(R.id.hemail);
        searchView=(SearchView)findViewById(R.id.search);

        API api = url.getInstance().create(API.class);
        Call<User> getuserdetails = api.getUserDetails(url.token);

        getuserdetails.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                hUsername.setText(response.body().getFirstName());
                hEmail.setText(response.body().getEmail());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        Toolbar toolbar = findViewById(R.id.app_bar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(context,CartActivity.class);
                startActivity(i);
            }
        });

        mToggle= new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
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
            case  R.id.map:
                Intent i= new Intent(DashboardActivity.this,MapsActivity.class);
                startActivity(i);
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
