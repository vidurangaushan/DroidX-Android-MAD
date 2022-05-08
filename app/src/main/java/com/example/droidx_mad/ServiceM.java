package com.example.droidx_mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.droidx_mad.databinding.ActivityServiceMBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ServiceM extends DrawerBase {

    private ActivityServiceMBinding binding;
    BottomNavigationView bottomNavigationView;

    RecyclerView recyclerView;
    DatabaseReference database;
    ServiceAllAdapter serviceAllAdapter;
    ArrayList<ServiceAll> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityServiceMBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Service Providers");

        recyclerView = (RecyclerView)findViewById(R.id.allservicead);
        //database = FirebaseDatabase.getInstance().getReference("Service");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ServiceAll> options =
                new FirebaseRecyclerOptions.Builder<ServiceAll>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Save"), ServiceAll.class)
                        .build();

        serviceAllAdapter = new ServiceAllAdapter(options);
        recyclerView.setAdapter(serviceAllAdapter);
        serviceAllAdapter.notifyDataSetChanged();

      /*  list = new ArrayList<>();
        serviceAllAdapter = new ServiceAllAdapter(this,list);
        recyclerView.setAdapter(serviceAllAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for  (DataSnapshot dataSnapshot : snapshot.getChildren()){

                 ServiceAll serviceAll = dataSnapshot.getValue(ServiceAll.class);
                    list.add(serviceAll);
                }
                serviceAllAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

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
    protected void onStart() {
        super.onStart();
        serviceAllAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        serviceAllAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)item.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });
        return true;

    }
    private void txtSearch(String str){

        FirebaseRecyclerOptions<ServiceAll> options =
                new FirebaseRecyclerOptions.Builder<ServiceAll>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Save").orderByChild("name").startAt(str).endAt(str + "~"), ServiceAll.class)
                        .build();

        serviceAllAdapter = new ServiceAllAdapter(options);
        serviceAllAdapter.startListening();
        recyclerView.setAdapter(serviceAllAdapter);
    }
}