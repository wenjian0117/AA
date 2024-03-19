package com.utar.aa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class orderNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_number);

        final Button ascending = findViewById(R.id.ascending);
        ascending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(orderNumber.this, ascending.class);
                startActivity(intent);

            }
        });

        final Button descending = findViewById(R.id.descending);
        descending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(orderNumber.this, descending.class);
                startActivity(intent);

            }
        });


        final Button Back = findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(orderNumber.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}