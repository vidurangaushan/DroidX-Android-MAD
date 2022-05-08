package com.example.droidx_mad;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;

public class ServiceAllAdapter extends FirebaseRecyclerAdapter<ServiceAll,ServiceAllAdapter.MyViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ServiceAllAdapter(@NonNull FirebaseRecyclerOptions<ServiceAll> options) {
        super(options);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.srvisitem,parent, false );
        return new MyViewHolder(v);
    }



    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull ServiceAll model) {
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.telephone.setText(model.getTelephone());
        holder.city.setText(model.getCity());
        holder.category.setText(model.getCategory());

        //update

        holder.serupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus =  DialogPlus.newDialog(holder.name.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true, 1400)
                        .create();

                dialogPlus.show();

                View view = dialogPlus.getHolderView();

                EditText name = view.findViewById(R.id.sername);
                EditText email = view.findViewById(R.id.seremail);
                EditText telephone = view.findViewById(R.id.sertel);
                EditText city = view.findViewById(R.id.sercity);
                EditText category = view.findViewById(R.id.sercategory);

                Button serupdate = view.findViewById(R.id.serupdate);

                name.setText(model.getName());
                email.setText(model.getEmail());
                telephone.setText(model.getTelephone());
                city.setText(model.getCity());
                category.setText(model.getCategory());

                dialogPlus.show();

               serupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("name", name.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("telephone",telephone.getText().toString());
                        map.put("city",city.getText().toString());
                        map.put("category",category.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Save")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.name.getContext(), "Update successful",Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }

                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.name.getContext(), "Updating Error",Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });

            }
        });

        //delete

        holder.serdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Deleted data can't be undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        FirebaseDatabase.getInstance().getReference().child("Save")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.name.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, email, telephone, city, category;

        Button serupdate, serdelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.sername);
            email = itemView.findViewById(R.id.seremail);
            telephone = itemView.findViewById(R.id.sertel);
            city = itemView.findViewById(R.id.sercity);
            category = itemView.findViewById(R.id.sercategory);

            serupdate = (Button)itemView.findViewById(R.id.serupdate);
            serdelete = (Button)itemView.findViewById(R.id.serdelete);
        }
    }
}
