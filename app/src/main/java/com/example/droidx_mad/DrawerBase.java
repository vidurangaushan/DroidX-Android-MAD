package com.example.droidx_mad;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class DrawerBase extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById((R.id.nav_view));
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.menu_drawer_open,R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer((GravityCompat.START));

        switch (item.getItemId()){
            case R.id.abd:
                startActivity(new Intent(this, ServiceM.class));
                overridePendingTransition(0,0);
                break;

            case R.id.termd:
                startActivity(new Intent(this, Home.class));
                overridePendingTransition(0,0);
                break;

            case R.id.contatd:
                startActivity(new Intent(this, Confirm_payment.class));
                overridePendingTransition(0,0);
                break;

            case R.id.settid:
                startActivity(new Intent(this, Payment_Details.class));
                overridePendingTransition(0,0);
                break;
        }
        return false;
    }
}