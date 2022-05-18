package com.example.hansani;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final ValidationStyle BASIC = ValidationStyle.BASIC;
    EditText fName, email, mobile, nic, city;
    Button button;
    AwesomeValidation awesomeValidation;
    DatabaseReference RegisterDbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        awesomeValidation  = new AwesomeValidation(BASIC);

        setTitle("Register");


        //Assign variable
        fName = findViewById(R.id.fName);
        email = findViewById(R.id.email);
        mobile = findViewById(R.id.mobile);
        nic = findViewById(R.id.nic);
        city = findViewById(R.id.city);
        button = findViewById(R.id.btn);


        RegisterDbRef = FirebaseDatabase.getInstance().getReference().child("Register");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertRegisterData();
                Intent intent = new Intent(MainActivity.this, Delete.class);
                startActivity(intent);
            }
        });


    }

    private void insertRegisterData() {
        String name = fName.getText().toString();
        String mail = email.getText().toString();
        String mob = mobile.getText().toString();
        String nc = nic.getText().toString();
        String cit = city.getText().toString();


        Register register = new Register(name, mail, mob, nc , cit);

        RegisterDbRef.push().setValue(register);
        Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();

    }
}