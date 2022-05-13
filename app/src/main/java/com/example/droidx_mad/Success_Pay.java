package com.example.droidx_mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.droidx_mad.databinding.ActivityMainBinding;
import com.example.droidx_mad.databinding.ActivitySuccessPayBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Success_Pay extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private ActivitySuccessPayBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.useraccount);

        binding = ActivitySuccessPayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Payment");

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle(" ");

        //Bottom Navigation Bar
        try {
            bottomNavigationView = findViewById(R.id.bottom_navigator);
            bottomNavigationView.setSelectedItemId(R.id.othernv);

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.homenv:
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            overridePendingTransition(1, 0);
                            return true;

                        case R.id.servicenv:
                            startActivity(new Intent(getApplicationContext(), ServiceM.class));
                            overridePendingTransition(1, 0);
                            return true;

                        case R.id.notifinv:
                            startActivity(new Intent(getApplicationContext(), Notice.class));
                            overridePendingTransition(0, 0);
                            return true;

                        case R.id.othernv:
                            startActivity(new Intent(getApplicationContext(), Confirm_payment.class));
                            overridePendingTransition(0, 0);
                            return true;
                    }

                    return false;
                }
            });

        }catch (NullPointerException ex){
            ex.printStackTrace();
        }

        //end of bottom navigation

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
}