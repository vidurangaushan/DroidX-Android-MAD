package com.example.droidx_mad;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DBCustomer {
    private DatabaseReference databaseReference;
    public DBCustomer(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(CustAccounts.class.getSimpleName());

    }
    public Task<Void> add(CustAccounts cstA){

        return databaseReference.push().setValue(cstA);
    }
    public Task<Void> update(String key, HashMap<String , Object> hashMap){
        return databaseReference.child(key).updateChildren(hashMap);
    }
    public Task<Void> remove(String key){
        return databaseReference.child(key).removeValue();
    }

}
