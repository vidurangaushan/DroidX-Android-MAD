package com.example.droidx_mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.droidx_mad.databinding.ActivityOthersBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//import com.example.droidx_mad.databinding.ActivityInfoBinding;

public class Others extends DrawerBase {

    private ActivityOthersBinding binding;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOthersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Bottom Navigation Bar
        try {
            bottomNavigationView = findViewById(R.id.bottom_navigator);
            bottomNavigationView.setSelectedItemId(R.id.othernv);

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.othernv:
                            return true;

                        case R.id.servicenv:
                            startActivity(new Intent(getApplicationContext(), ServiceM.class));
                            overridePendingTransition(1, 0);
                            return true;

                        case R.id.notifinv:
                            startActivity(new Intent(getApplicationContext(), Notice.class));
                            overridePendingTransition(0, 0);
                            return true;

                        case R.id.homenv:
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            overridePendingTransition(0, 0);
                            return true;
                    }

                    return false;
                }
            });

        }catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }
}