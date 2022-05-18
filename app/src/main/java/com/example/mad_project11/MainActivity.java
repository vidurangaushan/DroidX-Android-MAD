package com.example.mad_project11;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{


    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MainModel>options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Service Providers"), MainModel.class)
                        .build();

        mainAdapter = new MainAdapter(options);
        recyclerView.setAdapter(mainAdapter);




    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);

        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), choice , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void txtSearch(String str)
    {
        FirebaseRecyclerOptions<MainModel>options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Service Providers").orderByChild("name").startAt(str). endAt(str+"~"), MainModel.class)
                        .build();

        mainAdapter = new MainAdapter(options);
        mainAdapter.stopListening();
        recyclerView.setAdapter(mainAdapter);
    }






}