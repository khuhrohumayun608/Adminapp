package com.example.adminapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Product> lsit;

    public ItemsAdapter(Context context, ArrayList<Product> lsit) {
        this.context = context;
        this.lsit = lsit;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(lsit.get(position).getProductTitle());
        holder.price.setText("Rs. "+lsit.get(position).getProductPrice());
        holder.qty.setText("QTY: "+lsit.get(position).getProductAvlQty());
    }


    @Override
    public int getItemCount() {
        return lsit.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, price, qty;
        ImageButton delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cart_title);
            price = itemView.findViewById(R.id.cart_price);
            qty = itemView.findViewById(R.id.qty);
            delete = itemView.findViewById(R.id.deletecart);

//            delete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int pos = getAdapterPosition();
//                    MainActivity.cartList.remove(pos);
//                    notifyItemRemoved(pos);
//                    Toast.makeText(context, lsit.get(pos).getProductTitle()+" remvoed from cart.", Toast.LENGTH_SHORT).show();
//                }
//            });


        }
    }
}
