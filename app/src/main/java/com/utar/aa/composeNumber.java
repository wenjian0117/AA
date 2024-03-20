package com.utar.aa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class composeNumber extends AppCompatActivity {


    private EditText num2;
    private TextView num1,num3;
    private int answer, question;
    private Button sumbit;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_number);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        sumbit = findViewById(R.id.submit);

        randomNumber();
        final Button Back = findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(composeNumber.this, MainActivity.class);
                startActivity(intent);
            }
        });
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num2Str = num2.getText().toString();
                String numbersOnlyPattern = "[0-9]+";

                // Check if num1 or num2 is empty .equals("?")
                if(num2Str.isEmpty() || num2Str.contains("?")) {
                    // Show a message that numbers cannot be empty
                    Toast.makeText(getApplicationContext(), "The field cannot be empty!", Toast.LENGTH_LONG).show();
                    return; // Exit the method early
                }
                else if ( !num2Str.matches(numbersOnlyPattern)) {
                    // Show a message that only numbers are allowed
                    Toast.makeText(getApplicationContext(), "The field can only contain numbers!", Toast.LENGTH_LONG).show();
                    return; // Exit the method early
                }

                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                double n3 = Double.parseDouble(num3.getText().toString());

                boolean result = checkSum(n1,n2,n3);
                if(result){
                    showResultDialog();
                }else{
                    showResultDialog2();
                }
            }
        });
    }

    private void showResultDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");
        builder.setMessage("Incorrect! No worries! Let's give it another shot. Keep trying, you're on the right track!");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Generate next numbers
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
    private void showResultDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");
        builder.setMessage("Correct! Great job on getting that answer right! Keep it up!");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Generate next numbers
                randomNumber();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private boolean checkSum(double n1, double n2, double n3) {
        return (n1 + n2) == n3;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100); // Change the bound as needed
    }
    private void randomNumber() {
        answer = generateRandomNumber();
        question = generateRandomNumber();

        // Ensure answer (num3) is greater than question (num1)
        if (answer < question) {
            // Swap the numbers if answer is less than question
            int temp = question;
            question = answer;
            answer = temp;
        }

        // Update the TextViews to show the generated numbers
        num3.setText(String.valueOf(answer)); // num3 shows the answer
        num1.setText(String.valueOf(question)); // num1 shows the question
    }
}

