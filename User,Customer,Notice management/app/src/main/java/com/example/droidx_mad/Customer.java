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

public class Customer/*<dbRef>*/ extends AppCompatActivity {
    /*private EditText txtfname, txtlname, txtemail, txtaddress, txtcontactNumber;
    private Button submitbtn;
    private String fname, lname, email, address, contactNumber;
    private DatabaseReference dbRef;
    CustAccounts custObj;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        setTitle("Customer");

        //initializing our edittext and buttons
        final EditText fname=findViewById(R.id.fname);
        final EditText lname=findViewById(R.id.lname);
        final EditText email=findViewById(R.id.email);
        final EditText address=findViewById(R.id.address);
        final EditText phone=findViewById(R.id.phone);
        Button btn = findViewById(R.id.submitbtn);
        DBCustomer dbc = new DBCustomer();
        btn.setOnClickListener(v->
        {
            CustAccounts cstA = new CustAccounts(fname.getText().toString(),lname.getText().toString(),email.getText().toString(),address.getText().toString(),phone.getText().toString());
            dbc.add(cstA).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Customer is registered",Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er->{
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });
        });
        /*custObj = new CustAccounts();*/
    }
    /*public void ClearControls(){
        txtfname.setText("");
        txtlname.setText("");
        txtemail.setText("");
        txtaddress.setText("");
        txtcontactNumber.setText("");
    }*/
    //adding on click listener for button
    /*
    submitbtn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            //getting data from edittext fields
            fname = txtfname.getText().toString();
            lname = txtlname.getText().toString();
            email= txtemail.getText().toString();
            address = txtaddress.getText().toString();
            contactNumber = txtcontactNumber.getText().toString();

            //validating the text fields if empty or not
            if (TextUtils.isEmpty(fname)) {
                txtfname.setError("Please enter First Name");
            } else if (TextUtils.isEmpty(lname)) {
                txtlname.setError("Please enter Last Name");
            } else if (TextUtils.isEmpty(email)) {
                txtemail.setError("Please enter Email address");
            } else if (TextUtils.isEmpty(address)) {
                txtaddress.setError("Please enter Address");
            } else if (TextUtils.isEmpty(contactNumber)) {
                txtcontactNumber.setError("Please enter Contact Number");
            }else {
                // calling method to add data to Firebase Firestore.
                addDataToFirestore(fname, lname, email, address, contactNumber);
            }

        }

    });*/


    /*public void CreateData(View view){
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
    }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void Onsend(View view) {
        view = findViewById(R.id.imgcusbtn);
        startActivity(new Intent(Customer.this,CustHome.class) );
    }

}