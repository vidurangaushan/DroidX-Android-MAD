package com.example.droidx_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final Button loginbtn = findViewById(R.id.loginbtn);
        final TextView noaccount = findViewById(R.id.noaccount);



       loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, Userhome.class);
                startActivity(myintent);
                final String usernameTxt = username.getText().toString();
                final String passwordTxt = password.getText().toString();

                if (usernameTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Onsend(View view) {
        view = findViewById(R.id.loginbtn);
        startActivity(new Intent (MainActivity.this,Userhome.class) );
    }


    public void send(View view) {
        view = findViewById(R.id.signupbtn);
        startActivity(new Intent( MainActivity.this, SignupActivity.class));
    }

    public void next(View view) {
        view = findViewById(R.id.imglogbtn);
        startActivity(new Intent( MainActivity.this, Userhome.class));
    }
}