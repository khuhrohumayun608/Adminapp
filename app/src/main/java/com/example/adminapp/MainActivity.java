package com.example.adminapp;

import android.os.Bundle;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CartAdapter adapter;
    ArrayList<Order> list;
    int totalValue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        list = new ArrayList<>();

        DatabaseReference db = FirebaseDatabase.getInstance().getReference();

        db.child("Orders").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                for (DataSnapshot snap:task.getResult().getChildren()){
                    totalValue = 0;
                    Order order = snap.getValue(Order.class);
                    if(order.getStatus().equals("Padding")){
                        for(Product countTotal:order.getList()){
                            totalValue+=countTotal.getProductPrice();
                        }
                        order.setTotal(totalValue);
                        list.add(order);
                    }

                }


                adapter = new CartAdapter(MainActivity.this,list);
                LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
                recyclerView.setLayoutManager(llm);
                recyclerView.setAdapter(adapter);

            }
        });


    }
}