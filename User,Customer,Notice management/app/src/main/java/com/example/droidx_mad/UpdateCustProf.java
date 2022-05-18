package com.example.droidx_mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
*/
import java.util.HashMap;

public class UpdateCustProf extends AppCompatActivity {
/*
    EditText txtfname, txtlname, txtemail, txtaddress, txtcontactNumber;
    Button updatebtn;
    DatabaseReference dbRef;
    CustAccounts custObj;


*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cust_prof);
        setTitle("Update Profile");

        final EditText fname=findViewById(R.id.fname);
        final EditText lname=findViewById(R.id.lname);
        final EditText email=findViewById(R.id.email);
        final EditText address=findViewById(R.id.address);
        final EditText phone=findViewById(R.id.phone);
        Button btn = findViewById(R.id.updatebtn);
        Button btn1 = findViewById(R.id.deletebtn);
        DBCustomer dbc = new DBCustomer();
        btn.setOnClickListener(v->
        {
           /* CustAccounts cstA = new CustAccounts(fname.getText().toString(),lname.getText().toString(),email.getText().toString(),address.getText().toString(),phone.getText().toString());
            dbc.add(cstA).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Customer is updated",Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er->{
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });*/
            HashMap<String , Object>hashMap = new HashMap<>();
            hashMap.put("fname",fname.getText().toString());
            hashMap.put("lname",lname.getText().toString());
            hashMap.put("email",email.getText().toString());
            hashMap.put("address",address.getText().toString());
            hashMap.put("phone",phone.getText().toString());
            dbc.update("",hashMap).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Customer is updated",Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er->{
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });

        });
        //custObj = new CustAccounts();
        btn1.setOnClickListener(v->
        {
           /* CustAccounts cstA = new CustAccounts(fname.getText().toString(),lname.getText().toString(),email.getText().toString(),address.getText().toString(),phone.getText().toString());
            */
            HashMap<String , Object>hashMap = new HashMap<>();
            hashMap.put("fname",fname.getText().toString());
            hashMap.put("lname",lname.getText().toString());
            hashMap.put("email",email.getText().toString());
            hashMap.put("address",address.getText().toString());
            hashMap.put("phone",phone.getText().toString());
            dbc.remove("").addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Customer is removed",Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er->{
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });

        });

    }
    /*
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
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void Onsend(View view) {
        view = findViewById(R.id.updatebtn);
        startActivity(new Intent(UpdateCustProf.this,CustHome.class) );
    }

    public void send(View view) {
        view = findViewById(R.id.deletebtn);
        startActivity(new Intent( UpdateCustProf.this, CustHome.class));
    }
}