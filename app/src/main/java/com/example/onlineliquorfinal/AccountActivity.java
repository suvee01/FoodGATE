package com.example.onlineliquorfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.onlineliquorfinal.Fragment.AccountFragment;

public class AccountActivity extends AppCompatActivity {

    private FrameLayout accountframe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        accountframe=findViewById(R.id.aframelayout);
        setFragment(new AccountFragment());
    }

    private void setFragment(AccountFragment accountFragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(accountframe.getId(),accountFragment);
        fragmentTransaction.commit();
    }
}
