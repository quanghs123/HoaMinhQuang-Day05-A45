
package com.example.hoaminhquang_day05_a45;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvList;
    List<ContactDemo> contactDemoList;
    ContactDemo contact01,contact02,contact03,contact04,contact05,contact06;
    ContactRecyclerViewAdapter recyclerViewAdapter;
    TextView tvPrice,tvThanks,tvCount;
    Button btnOrder;
    ImageView btnCart;
    int dem=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPrice = findViewById(R.id.tvPrice);
        tvCount = findViewById(R.id.tvCount);
        tvThanks = findViewById(R.id.tvThanks);
        btnOrder = findViewById(R.id.btnOrder);
        btnCart = findViewById(R.id.btnCart);

        rvList = findViewById(R.id.rvContact);
        contactDemoList = new ArrayList<>();
        contact01 = new ContactDemo(getString(R.string.firstList));
        contact02 = new ContactDemo(getString(R.string.secondList));
        contact03 = new ContactDemo(getString(R.string.thirdList));
        contact04 = new ContactDemo(getString(R.string.fourthList));
        contact05 = new ContactDemo(getString(R.string.fifthList));
        contact06 = new ContactDemo(getString(R.string.sixthList));

        contactDemoList.add(contact01);
        contactDemoList.add(contact02);
        contactDemoList.add(contact03);
        contactDemoList.add(contact04);
        contactDemoList.add(contact05);
        contactDemoList.add(contact06);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getBaseContext(),1,RecyclerView.VERTICAL,false);

        recyclerViewAdapter = new ContactRecyclerViewAdapter(contactDemoList);

        rvList.setLayoutManager(layoutManager);
        rvList.setAdapter(recyclerViewAdapter);


        Intent intent = new Intent(getBaseContext(),CartContact.class);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });



        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPrice.setText("0");
                tvCount.setText("0");
                tvThanks.setText(R.string.last_tv);
                dem=0;
                intent.putExtra("price","0");
                intent.putExtra("keyName","");
            }
        });

        recyclerViewAdapter.setiOnClickContactRv(new iOnClickContactRv() {
            @Override
            public void onClickName(String name) {
                dem++;
                tvPrice.setText(String.valueOf(10*dem));
                tvCount.setText(String.valueOf(dem));
                intent.putExtra("keyName",name);
                intent.putExtra("price",String.valueOf(10*dem));
            }
        });

    }
}