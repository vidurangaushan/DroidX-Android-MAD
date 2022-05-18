package com.example.droidx_mad;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBUser {
    private DatabaseReference databaseReference;
    public DBUser(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(User.class.getSimpleName());
    }
    public Task<Void> add(User useO){

        return databaseReference.push().setValue(useO);
    }
}
