package com.example.droidx_mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Notice extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        setTitle("Notice");

        //Bottom Navigation Bar
        try {
            bottomNavigationView = findViewById(R.id.bottom_navigator);
            bottomNavigationView.setSelectedItemId(R.id.notifinv);

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.homenv:
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            overridePendingTransition(1, 0);
                            return true;

                        case R.id.servicenv:
                         //   startActivity(new Intent(getApplicationContext(), ServiceM1.class));
                           // overridePendingTransition(0, 0);
                            return true;

                        case R.id.notifinv:
                            return true;

                        case R.id.othernv:
                        //    startActivity(new Intent(getApplicationContext(), Confirm_payment.class));
                        //    overridePendingTransition(0, 0);
                            return true;


                    }

                    return false;
                }
            });

        }catch (NullPointerException ex){
            ex.printStackTrace();
        }


        Button button = (Button) findViewById(R.id.button5);
        //admin & admin

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Notice.this, Addnotice.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())){
          //  case R.id.account:
           //     startActivity(new Intent(this, Home.class));
        }
        return super.onOptionsItemSelected(item);
    }


    public void Onsend(View view) {
        view = findViewById(R.id.addnotibtn);
        startActivity(new Intent(Notice.this,Addnotice.class) );
    }
}