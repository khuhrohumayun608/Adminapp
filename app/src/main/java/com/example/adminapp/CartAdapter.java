package com.example.adminapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Order> lsit;

    public CartAdapter(Context context, ArrayList<Order> lsit) {
        this.context = context;
        this.lsit = lsit;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(lsit.get(position).getCustomerName());
        holder.contact.setText(lsit.get(position).getCustomerContact());
        holder.address.setText(lsit.get(position).getCustomerAddress());
        holder.total.setText(""+lsit.get(position).getTotal());
    }

    @Override
    public int getItemCount() {
        return lsit.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,contact,address,total;
        Button accept,reject;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
               name = itemView.findViewById(R.id.username);
               contact = itemView.findViewById(R.id.usercontact);
               address = itemView.findViewById(R.id.useraddress);
               total = itemView.findViewById(R.id.total);
               accept = itemView.findViewById(R.id.accept);
               reject = itemView.findViewById(R.id.reject);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    Intent intent = new Intent(context,OrderDetails.class);
                    intent.putExtra("Pushkey",lsit.get(pos).getId());
                    context.startActivity(intent);
                }
            });

            accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int  pos = getAdapterPosition();
                    DatabaseReference db = FirebaseDatabase.getInstance().getReference();
                    db.child("Orders").child(lsit.get(pos).getId()).child("status").setValue("Delivered");
                    Toast.makeText(context, "Order delivered", Toast.LENGTH_SHORT).show();

                }
            });

            reject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int  pos = getAdapterPosition();
                    DatabaseReference db = FirebaseDatabase.getInstance().getReference();
                    db.child("Orders").child(lsit.get(pos).getId()).child("status").setValue("Rejected");
                    Toast.makeText(context, "Order Rejected", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
