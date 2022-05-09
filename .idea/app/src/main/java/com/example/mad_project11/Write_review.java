package com.example.mad_project11;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Write_review extends AppCompatActivity {

    EditText etName, etTitle, etReview;
    Button btnSubmit;
    Review revObj;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        etName = findViewById(R.id.et_name);
        etTitle = findViewById(R.id.et_title);
        etReview = findViewById(R.id.et_review);
        btnSubmit = findViewById(R.id.btn_submit);

        revObj = new Review();

        Button button = (Button) findViewById(R.id.btn_submit);
        button.setOnClickListener(view -> {
            dbRef = FirebaseDatabase.getInstance().getReference().child("Review");

            if(TextUtils.isEmpty(etName.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a name" , Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(etTitle.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a title" , Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(etReview.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter a review" , Toast.LENGTH_SHORT).show();
            else{
                revObj.setName(etName.getText().toString().trim());
                revObj.setTitle(etTitle.getText().toString().trim());
                revObj.setReview(etReview.getText().toString().trim());

                //insert in to the database
                dbRef.push().setValue(revObj);
                //Feedback to the user via a Toast
                Toast.makeText(getApplicationContext(), "Data saved Successfully" , Toast.LENGTH_SHORT).show();
                ClearControls();
            }
        });


        /**
        // New Button
        //Called when the user taps the Send button
        Button button = (Button) findViewById(R.id.btn_submit);
        //admin & admin

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Write_review.this, review_success.class);
                startActivity(intent);
            }
        }); **/


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
    }

    public void ClearControls(){
        etName.setText("");
        etTitle.setText("");
        etReview.setText("");
    }

    public void CreateData(View view){
        dbRef = FirebaseDatabase.getInstance().getReference().child("Review");

        if(TextUtils.isEmpty(etName.getText().toString()))
            Toast.makeText(getApplicationContext(), "Please enter a name" , Toast.LENGTH_SHORT).show();
        else if(TextUtils.isEmpty(etTitle.getText().toString()))
            Toast.makeText(getApplicationContext(), "Please enter a title" , Toast.LENGTH_SHORT).show();
        else if(TextUtils.isEmpty(etReview.getText().toString()))
            Toast.makeText(getApplicationContext(), "Please enter a review" , Toast.LENGTH_SHORT).show();
        else{
            revObj.setName(etName.getText().toString().trim());
            revObj.setTitle(etTitle.getText().toString().trim());
            revObj.setReview(etReview.getText().toString().trim());

            //insert in to the database
            dbRef.push().setValue(revObj);
            //Feedback to the user via a Toast
            Toast.makeText(getApplicationContext(), "Data saved Successfully" , Toast.LENGTH_SHORT).show();
            ClearControls();

            int ratingSum = 0;
            float ratingTotal = 0;
            float ratingAvg = 0;
            DataSnapshot dataSnapshot;
            for(DataSnapshot child : dataSnapshot.child("rating").getChildren()){
                ratingSum = ratingSum+ Integer.valueOf(child.getValue().toString());
                ratingTotal++;
            }
            if(ratingTotal!=0){
                ratingAvg = ratingSum / ratingTotal;
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}