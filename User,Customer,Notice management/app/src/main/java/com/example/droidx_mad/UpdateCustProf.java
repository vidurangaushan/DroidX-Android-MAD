package com.example.droidx_mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateCustProf extends AppCompatActivity {

    EditText txtfname, txtlname, txtemail, txtaddress, txtcontactNumber;
    Button updatebtn;
    DatabaseReference dbRef;
    CustAccounts custObj;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cust_prof);
        setTitle("Update Profile");

        txtfname=findViewById(R.id.fname);
        txtlname=findViewById(R.id.lname);
        txtemail=findViewById(R.id.email);
        txtaddress=findViewById(R.id.address);
        txtcontactNumber=findViewById(R.id.phone);
        custObj = new CustAccounts();





    }
   public void UpdateData(View v){
        DatabaseReference updRef= FirebaseDatabase.getInstance().getReference().child("CustAccounts");
        updRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(DataSnapshot.hasChild( "cust1")){
                    try{
                        custObj.setFname(txtfname.getText().toString().trim());
                        custObj.setLname(txtlname.getText().toString().trim());
                        custObj.setEmail(txtemail.getText().toString().trim());
                        custObj.setAddress(txtaddress.getText().toString().trim());
                        custObj.setContactNumber(Integer.parseInt(txtcontactNumber.getText().toString().trim()));
                        dbRef =FirebaseDatabase.getInstance().getReference().child("CustAccount").child("cust1");
                        dbRef.setValue(custObj);
                        ClearControls();
                        Toast.makeText(getApplicationContext(), "Profile updated successfully", Toast.LENGTH_SHORT).show();
                    }
                    catch(NumberFormatException e){
                        Toast.makeText(getApplicationContext(), "Invalid contact number", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(getApplicationContext(), "No Source to Update", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void ClearControls() {
        txtfname.setText("");
        txtlname.setText("");
        txtemail.setText("");
        txtaddress.setText("");
        txtcontactNumber.setText("");
    }

    public void Onsend(View view) {
        view = findViewById(R.id.updatebtn);
        startActivity(new Intent(UpdateCustProf.this,CustHome.class) );
    }
}