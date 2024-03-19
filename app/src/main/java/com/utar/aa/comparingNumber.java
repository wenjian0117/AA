package com.utar.aa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class comparingNumber extends AppCompatActivity {

    private TextView num1, num2;
    private LinearLayout lessthan, equal, greatthan;
    private int number1, number2;
    private int correct = 0;
    private int incorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparing_number);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        lessthan = findViewById(R.id.lessthan);
        equal = findViewById(R.id.equal);
        greatthan = findViewById(R.id.greatthan);

        randomNumbers();

        lessthan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer("<");

            }

        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer("=");

            }
        });

        greatthan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(">");

            }
        });


        final Button Back = findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(comparingNumber.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkAnswer(String s) {

        int result = Integer.compare(number1, number2);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");

        if (s.equals("<") && result < 0) {
            correct++;
            builder.setMessage("Correct! Great job on getting that answer right! Keep it up!");

        } else if (s.equals("=") && result == 0) {
            correct++;
            builder.setMessage("Correct! Good job! Keep up the great work!!");
        } else if (s.equals(">") && result > 0) {
            correct++;
            builder.setMessage("Correct! Great job! You got it right! Keep up the good work and always stay curious.");

        } else {
            incorrect++;
            builder.setMessage("Incorrect!  That was a good try! You're learning, and that's what really counts. Want to give it another go?");

        }


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Generate next numbers
                randomNumbers();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void randomNumbers() {
        number1 = generateRandomNumber();
        number2 = generateRandomNumber();
        num1.setText(String.valueOf(number1));
        num2.setText(String.valueOf(number2));
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100); // Change the bound as needed
    }

}