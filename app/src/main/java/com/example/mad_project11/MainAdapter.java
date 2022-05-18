package com.example.mad_project11;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel,MainAdapter.myViewHolder> {

    public Context context;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel model) {
        holder.name.setText(model.getName());
        holder.category.setText(model.getCategory());
        holder.city.setText(model.getCity());
        /**holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Write_review.class);
                context.startActivity(intent);
            }
        })**/;

        Glide.with(holder.img.getContext())
                .load(model.getProfileImageURL())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);


    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView name, category, city;
        Button btn;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.img1);
            name = (TextView) itemView.findViewById(R.id.nametext);
            category = (TextView) itemView.findViewById(R.id.cattext);
            city = (TextView) itemView.findViewById(R.id.citytext);
            btn = (Button) itemView.findViewById(R.id.btn_writereview);

            /**

            itemView.findViewById(R.id.btn_writereview).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), Write_review.class);
                    intent.putExtra("name" , (Parcelable) name);

                    view.getContext().startActivity(intent);

                }
            })**/

            Button button = (Button)itemView.findViewById(R.id.btn_writereview);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), Write_review.class);
                    /**
                    intent.putExtra("NAME" , (Parcelable) name);
                    intent.putExtra("CATEGORY", (Parcelable) category);
                    **/
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
