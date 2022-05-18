package com.example.hansani;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hansani.databinding.ActivityDeleteBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Delete extends AppCompatActivity {

    ActivityDeleteBinding binding;
    DatabaseReference reference;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeleteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        button = (Button) findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Delete.this, service.class);
                startActivity(intent);
            }
        });


        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullName = binding.fName.getText().toString();

                if (!fullName.isEmpty()) {

                    deleteData(fullName);
                } else {

                    Toast.makeText(Delete.this, "Enter Full Name", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void deleteData(String fullName) {

        reference = FirebaseDatabase.getInstance().getReference("Register");
        reference.child(fullName).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(Delete.this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                    binding.fName.setText("");
                } else {
                    Toast.makeText(Delete.this, "Fail to Delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}