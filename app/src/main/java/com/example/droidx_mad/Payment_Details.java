package com.example.droidx_mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.droidx_mad.databinding.ActivityPaymentDetailsBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Payment_Details extends DrawerBase {

    private ActivityPaymentDetailsBinding binding;
    BottomNavigationView bottomNavigationView;

    RecyclerView recyclerView;
    Query database;
    PayAdapter payAdapter;
    ArrayList<Payment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityPaymentDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Payment Details");

        recyclerView = findViewById(R.id.pay_details);
        database = FirebaseDatabase.getInstance().getReference("Payment");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
/*
        FirebaseRecyclerOptions<Payment> options =
                  new FirebaseRecyclerOptions.Builder<Payment>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Payment"), Payment.class)
                .build();

        payAdapter = new PayAdapter(options);
        recyclerView.setAdapter(payAdapter);*/

       list = new ArrayList<>();
        payAdapter = new PayAdapter(this,list);
        recyclerView.setAdapter(payAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for  (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    Payment payment = dataSnapshot.getValue(Payment.class);
                    list.add(payment);
                }
                payAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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

    }
    //Action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
       // MenuItem item = menu.findItem(R.id.search);
      //  SearchView searchView = (SearchView)item.getActionView();
       // SearchView.setMaxWidth(Integer.MAX_VALUE);
        //SearchView.setQueryHint("Search Here!");

      /*  searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                payAdapter.getFilter().filter(newText);
                return false;
            }
        });
*/

        return true;
    }
}