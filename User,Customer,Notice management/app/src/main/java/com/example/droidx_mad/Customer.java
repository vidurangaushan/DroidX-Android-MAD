package com.example.droidx_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Customer<dbRef> extends AppCompatActivity {
    EditText txtfname, txtlname, txtemail, txtaddress, txtcontactNumber;
    Button submitbtn;
    DatabaseReference dbRef;
    CustAccounts custObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        setTitle("Customer");

        txtfname=findViewById(R.id.fname);
        txtlname=findViewById(R.id.lname);
        txtemail=findViewById(R.id.email);
        txtaddress=findViewById(R.id.address);
        txtcontactNumber=findViewById(R.id.phone);
        custObj = new CustAccounts();
    }
    public void ClearControls(){
        txtfname.setText("");
        txtlname.setText("");
        txtemail.setText("");
        txtaddress.setText("");
        txtcontactNumber.setText("");
    }
    public void CreateData(View view){
        dbRef=FirebaseDatabase.getInstance().getReference().child("CustAccount");
        try{
            if(TextUtils.isEmpty(txtfname.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter first name", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(txtlname.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter last name", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(txtemail.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(txtaddress.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter address", Toast.LENGTH_SHORT).show();
            else {
                custObj.setFname(txtfname.getText().toString().trim());
                custObj.setLname(txtlname.getText().toString().trim());
                custObj.setEmail(txtemail.getText().toString().trim());
                custObj.setAddress(txtaddress.getText().toString().trim());
                custObj.setContactNumber(Integer.parseInt(txtcontactNumber.getText().toString().trim()));

                dbRef.push().setValue(custObj);
                Toast.makeText(getApplicationContext(), "Register successfully",Toast.LENGTH_SHORT).show();
            }

        }
        catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Invalid contact number", Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void Onsend(View view) {
        view = findViewById(R.id.submitbtn);
        startActivity(new Intent(Customer.this,CustHome.class) );
    }
}