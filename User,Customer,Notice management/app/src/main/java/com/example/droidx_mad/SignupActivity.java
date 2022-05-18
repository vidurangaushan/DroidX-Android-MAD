package com.example.droidx_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    /*
    EditText username, email, password;
    Button signbtn;
    User useObj;
    DatabaseReference dbRef;
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setTitle("Sign Up");
        final EditText username = findViewById(R.id.username);
        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.password);
        Button btn =findViewById(R.id.signbtn);
        DBUser dbu = new DBUser();
        btn.setOnClickListener(v->
        {
            User useO = new User(username.getText().toString(),email.getText().toString(),password.getText().toString());
            dbu.add(useO).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "User is signed up",Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er->{
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });
        });
        /*useObj = new User();*/
    }
    /*
    public void ClearControls(){
        username.setText("");
        email.setText("");
        password.setText("");
    }
    */

    /*
    public void CreateData(View view){
        dbRef = FirebaseDatabase.getInstance().getReference().child("User");
        if(TextUtils.isEmpty(username.getText().toString()))
            Toast.makeText(getApplicationContext(),  "Please enter a Username", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(email.getText().toString()))
            Toast.makeText(getApplicationContext(), "Please enter a Email", Toast.LENGTH_SHORT).show();
        else if(TextUtils.isEmpty(password.getText().toString()))
            Toast.makeText(getApplicationContext(), "Please enter Password", Toast.LENGTH_SHORT).show();
        else{
            useObj.setUsername(username.getText().toString().trim());
            useObj.setEmail(email.getText().toString().trim());
            useObj.setPassword(password.getText().toString().trim());
            dbRef.push().setValue(useObj);
            Toast.makeText(getApplicationContext(), "Signed up Successfully",Toast.LENGTH_SHORT).show();
            ClearControls();
        }

    }*/
    public void signbtn(View view) {
        view = findViewById(R.id.signbtn);
        startActivity(new Intent (SignupActivity.this,Userhome.class) );
    }

    public void Onsend(View view) {
        view = findViewById(R.id.imgbtnsign);
        startActivity(new Intent (SignupActivity.this,Addnotice.class) );
    }
}