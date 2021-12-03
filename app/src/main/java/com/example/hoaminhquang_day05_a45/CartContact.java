package com.example.hoaminhquang_day05_a45;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class CartContact extends AppCompatActivity {

    ImageView btnBack;
    int dem=0;
    List<ContactDemo> contactDemoList;
    RecyclerView rvList;
    ContactRecyclerViewAdapter recyclerViewAdapter;
    TextView tvPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_contact);

        rvList = findViewById(R.id.rvContact);
        tvPrice = findViewById(R.id.tvPrice);
        contactDemoList = new ArrayList<>();

        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        Intent intent1 = new Intent(getBaseContext(),MainActivity.class);

        String name = intent.getStringExtra("keyName");
        tvPrice.setText(intent.getStringExtra("price"));

        contactDemoList.add(new ContactDemo(name));

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getBaseContext(),1,RecyclerView.VERTICAL,false);

        recyclerViewAdapter = new ContactRecyclerViewAdapter(contactDemoList);

        rvList.setLayoutManager(layoutManager);
        rvList.setAdapter(recyclerViewAdapter);



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });



    }
}