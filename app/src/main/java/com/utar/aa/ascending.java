package com.utar.aa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ascending extends AppCompatActivity {

    private TextView[] numberTextViews = new TextView[5];
    private Button sumbitAsceOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ascending);

        numberTextViews[0] = findViewById(R.id.number1);
        numberTextViews[1] = findViewById(R.id.number2);
        numberTextViews[2] = findViewById(R.id.number3);
        numberTextViews[3] = findViewById(R.id.number4);
        numberTextViews[4] = findViewById(R.id.number5);

        sumbitAsceOrder = findViewById(R.id.submitOrder);

        randomNumber();

        for (TextView numberTextView : numberTextViews) {
            numberTextView.setOnLongClickListener(longClickListener);
        }

        for (TextView numberTextView : numberTextViews) {
            numberTextView.setOnDragListener(dragListener);
        }

        sumbitAsceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResultDialog();
            }
        });



        final Button descending = findViewById(R.id.descending);
        descending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ascending.this, descending.class);
                startActivity(intent);

            }
        });

        final Button Back = findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ascending.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void randomNumber() {
        Random random = new Random();
        for (TextView numberTextView : numberTextViews) {
            int randomNumber = random.nextInt(50); // Change 100 to your desired range
            numberTextView.setText(String.valueOf(randomNumber));
        }
    }


    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, shadowBuilder, v, 0);
            return false; // Return false to indicate that the long click event is not consumed
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent) {
                case DragEvent.ACTION_DROP:
                    TextView dropped = (TextView) view;
                    TextView dropTarget = (TextView) v;
                    String tempText = dropTarget.getText().toString();
                    dropTarget.setText(dropped.getText());
                    dropped.setText(tempText);
                    break;
            }
            return true;
        }
    };

    private void showResultDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");

        boolean isAscending = checkAscendingOrder();

        if(isAscending){
            builder.setMessage("Correct! The numbers are in ascending order. Let's try another question.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    randomNumber(); // Dismiss the dialog
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        }else{
            builder.setMessage("Incorrect! Numbers are not in ascending order. Please try again!");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss(); // Dismiss the dialog
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        };
    }

    private boolean checkAscendingOrder() {
        for (int i = 0; i < numberTextViews.length - 1; i++) {
            int currentNumber = Integer.parseInt(numberTextViews[i].getText().toString());
            int nextNumber = Integer.parseInt(numberTextViews[i + 1].getText().toString());
            if (currentNumber > nextNumber) {
                return false;
            }
        }
        return true;
    }
}