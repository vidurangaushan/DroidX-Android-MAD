package com.example.hansani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuestionE extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_e);

        button = (Button) findViewById(R.id.button2);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intentLoadNewActivity = new Intent(QuestionE.this,Electrician.class);
               startActivity(intentLoadNewActivity);
           }
       });
    }
}