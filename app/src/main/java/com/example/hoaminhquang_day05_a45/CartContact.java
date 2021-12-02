package com.example.hoaminhquang_day05_a45;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class CartContact extends AppCompatActivity {

    ImageView btnBack;
    List<ContactDemo> contactDemoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_contact);
        contactDemoList = new ArrayList<>();
        btnBack = findViewById(R.id.btnBack);

        Intent intent = new Intent(getBaseContext(),MainActivity.class);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });



    }
}