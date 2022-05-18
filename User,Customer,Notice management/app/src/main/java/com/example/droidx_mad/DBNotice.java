package com.example.droidx_mad;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBNotice {
    private DatabaseReference databaseReference;
    public DBNotice (){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(AllNotices.class.getSimpleName());
    }
    public Task<Void> add(AllNotices allN){

        return databaseReference.push().setValue(allN);
    }
}
