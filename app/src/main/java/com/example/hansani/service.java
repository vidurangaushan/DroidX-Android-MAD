package com.example.hansani;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class service extends AppCompatActivity  {

    ImageButton ImageButton1;
    ImageButton ImageButton2;
    ImageButton ImageButton3;
    ImageButton ImageButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        ImageButton1 = (ImageButton) findViewById(R.id.imageButton1);

        ImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(service.this,Question.class);
                startActivity(intentLoadNewActivity);
            }
        });


        ImageButton2 = (ImageButton) findViewById(R.id.imageButton2);

        ImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(service.this,QuestionC.class);
                startActivity(intentLoadNewActivity);
            }
        });

        ImageButton3 = (ImageButton) findViewById(R.id.imageButton3);

        ImageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(service.this,QuestionR.class);
                startActivity(intentLoadNewActivity);
            }
        });

        ImageButton4 = (ImageButton) findViewById(R.id.imageButton4);

        ImageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(service.this,QuestionE.class);
                startActivity(intentLoadNewActivity);
            }
        });

        setTitle("Our Services");


    }

    }
