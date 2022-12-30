package com.example.adminapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity {
    ArrayList<Product> list;
    RecyclerView recyclerView;
    ItemsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        list = new ArrayList<>();
        recyclerView = findViewById(R.id.cartrecycler);



        String id = getIntent().getStringExtra("Pushkey");
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        db.child("Orders").child(id).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                Order order = task.getResult().getValue(Order.class);
                for (Product product:order.getList()){
                    list.add(product);
                }


                adapter = new ItemsAdapter(OrderDetails.this,list);
                LinearLayoutManager llm = new LinearLayoutManager(OrderDetails.this, RecyclerView.VERTICAL,false);
                recyclerView.setLayoutManager(llm);
                recyclerView.setAdapter(adapter);




            }
        });
    }
}