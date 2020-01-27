package com.example.onlineliquorfinal;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.onlineliquorfinal.Fragment.DashboardFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import Model.CategoryModel;
import Model.ProductModel;

public class DashboardActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mToggle;
    private FrameLayout frameLayout;
    public static List<CategoryModel> lstcat= new ArrayList<>();
    public static List<ProductModel> lstproduct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();

        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawyerlayout);
        Toolbar toolbar = findViewById(R.id.app_bar);
        mToggle= new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        lstcat=new ArrayList<>();
        lstcat.add(new CategoryModel(R.drawable.logo2,"Beer"));
        lstcat.add(new CategoryModel(R.drawable.logo5,"Whiskey"));
        lstcat.add(new CategoryModel(R.drawable.logo5,"Rum"));

        lstproduct=new ArrayList<>();
        lstproduct.add(new ProductModel(R.drawable.logo5,"Beer"));
        lstproduct.add(new ProductModel(R.drawable.logo5,"Whiskey"));
        lstproduct.add(new ProductModel(R.drawable.logo5,"Rum"));


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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//
//    }
}
