package com.example.droidx_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addnotice extends AppCompatActivity {
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnotice);
        setTitle("Add New Notice");

        //initializing edittext and buttons
        final EditText notititle = findViewById(R.id.notititle);
        final EditText editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        Button btn = findViewById(R.id.uploadbtn);
        context = this;
        DBNotice dbn = new DBNotice();
        btn.setOnClickListener(v->{
            AllNotices allN = new AllNotices(notititle.getText().toString(),editTextTextPersonName2.getText().toString());
            dbn.add(allN).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "New notice is added",Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er->{
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void Onsend(View view) {
        view = findViewById(R.id.imgbtnuplod);
        Intent intent = new Intent(Addnotice.this,CustHome.class);
        startActivity(new Intent( context, CustHome.class));

    }
}