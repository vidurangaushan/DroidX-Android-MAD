package com.example.droidx_mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import com.example.droidx_mad.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends DrawerBase {

    private ActivityMainBinding binding;

    BottomNavigationView bottomNavigationView;


    //Button btn1,btn2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
      //  allocateActivityTitle("Main");

        //Bottom Navigation Bar
        try {
            bottomNavigationView = findViewById(R.id.bottom_navigator);
            bottomNavigationView.setSelectedItemId(R.id.homenv);

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.homenv:
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
                        startActivity(new Intent(getApplicationContext(), Others.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });

        }catch (NullPointerException ex){
            ex.printStackTrace();
        }

    /*
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Home icon
        getSupportActionBar().setIcon(R.drawable.menu1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        button = (Button)findViewById(R.id.card_1);
        button2 = (Button)findViewById(R.id.card_2);
        button3 = (Button)findViewById(R.id.card_3);
*/
        ActionBar actionBar = getSupportActionBar(); //Remove action bar title
        actionBar.setTitle("Home Page");

    }



    public void onClick(View v){

        if(v.getId() == R.id.card_1){
            Intent intent = new Intent(MainActivity.this, Confirm_payment.class);
            startActivity(intent);

        }else if(v.getId() == R.id.card_2){
            Intent intent = new Intent(MainActivity.this, ServiceM.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.card_3){
            Intent intent = new Intent(MainActivity.this, Others.class);
            startActivity(intent);
        }

    }

        //Action bar
   @Override
        public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.main, menu);
       return true;
   }

}