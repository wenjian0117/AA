package com.utar.aa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView customersupport = findViewById(R.id.customersupport);

        customersupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, agent.class);
                startActivity(intent);
            }
        });

        final LinearLayout compareNumber = findViewById(R.id.comparingNumber);
        compareNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, comparingNumber.class);
                startActivity(intent);
            }
        });

        final LinearLayout orderNumber = findViewById(R.id.orderNumber);
        orderNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, orderNumber.class);
                startActivity(intent);
            }
        });

        final LinearLayout composeNumber = findViewById(R.id.composeNumber);
        composeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, composeNumber.class);
                startActivity(intent);
            }
        });

        final Button logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        final Button howtoPlay = findViewById(R.id.howtoPlay);
        howtoPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, howtoPlay.class);
                startActivity(intent);
            }
        });

    }
}