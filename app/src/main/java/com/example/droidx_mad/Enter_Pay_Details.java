package com.example.droidx_mad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import com.example.droidx_mad.databinding.ActivityEnterPayDetailsBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Enter_Pay_Details extends DrawerBase {

    private ActivityEnterPayDetailsBinding binding;

    BottomNavigationView bottomNavigationView;

      EditText name, amount,cardnum,expdate,cvv;
      Button button;
     Context context;
     private DbHandler dbHandler;
     Payment payment;
     DatabaseReference dbrefpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnterPayDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //check all the fields are filled by the user
        final boolean[] isAllFieldsChecked = {false};

        //Bottom Navigation Bar

        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.othernv);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.homenv:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(1, 0);
                        return true;

                    case R.id.notifinv:
                        startActivity(new Intent(getApplicationContext(), Notice.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.othernv:
                        startActivity(new Intent(getApplicationContext(), Confirm_payment.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.servicenv:
                        startActivity(new Intent(getApplicationContext(), ServiceM.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });


        ActionBar actionBar = getSupportActionBar();
       // actionBar.setTitle(" ");

       // Button button = (Button) findViewById(R.id.btnConfirm);

        name = findViewById(R.id.Name);
        amount = findViewById(R.id.Amount);
        cardnum = findViewById(R.id.CardNum);
        expdate = findViewById(R.id.editTextDate);
        cvv = findViewById(R.id.editTextNumberPassword);
        button = findViewById(R.id.btnConfirm);
        context = this;

       payment = new Payment();

       // dbHandler = new DbHandler(context);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              dbrefpay   = FirebaseDatabase.getInstance().getReference().child("Payment");

                isAllFieldsChecked[0] = CheckAllFields();

               /*Intent intent = new Intent(Enter_Pay_Details.this, Success_Pay.class);
                String usename = name.getText().toString();
                String useamount = amount.getText().toString();
                long started = System.currentTimeMillis();*/

                payment.setName(name.getText().toString().trim());
                payment.setAmount(amount.getText().toString().trim());


                if (isAllFieldsChecked[0] == true) {
                    dbrefpay.push().setValue(payment);
                    Toast.makeText(getApplicationContext(), "Successful!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Enter_Pay_Details.this, Success_Pay.class);
                    startActivity(new Intent(context,Success_Pay.class));
                    return;
                }
                else{
                    Toast.makeText(getApplicationContext(), "Unsuccessful!",Toast.LENGTH_SHORT).show();
                }




            }
        });
    }


    //checking fields
    private boolean CheckAllFields() {
        if (name.length() == 0) {
            name.setError("This field is required");
            return false;
        }

        if (amount.length() == 0) {
            amount.setError("This field is required");
            return false;
        }

        if (cardnum.length() == 0) {
            cardnum.setError("Card number is required");
            return false;
        }

        if (expdate.length() == 0) {
            expdate.setError("This field is required");
            return false;
        }

        if (cvv.length() == 0) {
            cvv.setError("Password is required");
            return false;
        } else if (cvv.length() < 3) {
            cvv.setError("Invalid Password");
            return false;
        }

        // after all validation return true.
        return true;
    }
    //action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

}