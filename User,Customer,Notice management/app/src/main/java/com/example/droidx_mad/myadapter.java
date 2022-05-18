package com.example.droidx_mad;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.security.AccessController;
import java.util.HashMap;
import java.util.Map;


    public class myadapter extends FirebaseRecyclerAdapter<AllNotices,myadapter.myviewholder>{
    public myadapter(@NonNull FirebaseRecyclerOptions<AllNotices> options)
    {
       super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, final int position, @NonNull final AllNotices model)
    {
        holder.notititle.setText(model.getNotitile());
        holder.description.setText(model.getDescription());

        update part
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.notititle.getContext())
                       .setContentHolder(new RecyclerView.ViewHolder(R.layout.dialogcontent))
                      .setExpanded( true, 1100)
                      .create();
                dialogPlus.show();
                View myview=dialogPlus.getHolderView();
                final EditText notititle=myview.findViewById(R.id.utitle);
                final EditText description=myview.findViewById(R.id.udescription);

                Button submit=myview.findViewById(R.id.usubmit);

                notititle.setText(model.getNotitile());
                description.setText(model.getDescription());


                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("notititle",notititle.getText().toString());
                        map.put("description",description.getText().toString());


                        FirebaseDatabase.getInstance().getReference().child("AllNotices")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(holder.notititle.getContext(), "Notice updated successfully", Toast.LENGTH_SHORT).show();
                                         dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.notititle.getContext(), "Error while updating", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });
            }
        });

        //delete part
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.notititle.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Delete...?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("AllNotices")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.notititle.getContext(), "Removed", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.show();
            }
        });

    } // End of OnBindViewMethod

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder
    {

        public AccessController img;
        ImageView edit,delete;
        TextView notititle,description;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            notititle=(TextView)itemView.findViewById(R.id.titletext);
            description=(TextView)itemView.findViewById(R.id.destext);


            edit=(ImageView)itemView.findViewById(R.id.editicon);
            delete=(ImageView)itemView.findViewById(R.id.deleteicon);
        }
    }


}
