package com.example.droidx_mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;

import com.example.droidx_mad.databinding.ActivityConfirmPaymentBinding;

public class Confirm_payment extends DrawerBase {

    private ActivityConfirmPaymentBinding binding;

    Button b4;
    TextView rst;
    EditText N1;
   // EditText N2;

    //int numb1, numb2;
    float result,numb1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Calculate Payment");

        rst=findViewById(R.id.editTextTextPersonName4);
        N1=  findViewById(R.id.editmonth);
       // N2=findViewById(R.id.spinnerpay);

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle(" ");

            //spinner

/*
        Spinner spinner = (Spinner) findViewById(R.id.spinnerpay);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.month_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

*/

        Button b4= (Button) findViewById(R.id.btncalculate);

        Button button = (Button) findViewById(R.id.btnpay);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Confirm_payment.this, Enter_Pay_Details.class);
                startActivity(intent);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //numb1=Integer.parseInt(N1.getText().toString());
                //numb2=Integer.parseInt(N2.getText().toString());

                numb1=Float.parseFloat(N1.getText().toString());
                //numb2=Float.parseFloat(N2.getText().toString());

                result= (float) (numb1*998.50);
                rst.setText(String.valueOf(result));
            }
        });
    }

   // private void setContentView(int activity_confirm_payment) {}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

  //  private MenuInflater getMenuInflater() { };
}