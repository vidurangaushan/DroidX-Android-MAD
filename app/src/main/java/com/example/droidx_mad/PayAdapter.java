package com.example.droidx_mad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class PayAdapter extends RecyclerView.Adapter<PayAdapter.MyViewHolder>  {

    Context context;
    ArrayList<Payment> list;
   // ArrayList<Payment> newlist;

    public PayAdapter(Context context, ArrayList<Payment> list){
        this.context = context;
        this.list = list;
        //this.newlist = new ArrayList<>(newlist);
    }

    public PayAdapter(FirebaseRecyclerOptions<Payment> options) {
    }

    @NonNull
    @Override
    public PayAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.pitem,parent, false );
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PayAdapter.MyViewHolder holder, int position) {

        Payment payment = list.get(position);
        holder.name.setText(payment.getName());
        holder.amount.setText(payment.getAmount());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void startListening() {
    }

    /*@Override
    public Filter getFilter() {
        return paymentfilter;
    }*/

    /*private final Filter paymentfilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            ArrayList<Payment> filteredPayList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){

                filteredPayList.addAll(newlist);
            }else {
                String filterPattern = constraint.toString().toLowerCase(Locale.ROOT).trim();

                for (Payment payment : newlist){
                    filteredPayList.add(payment);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredPayList;
            results.count = filteredPayList.size();
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            list.clear();
            list.addAll((ArrayList)results.values);
            notifyDataSetChanged();
        }
    };*/

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, amount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.pname);
            amount = itemView.findViewById(R.id.pamount);

        }
    }
}
