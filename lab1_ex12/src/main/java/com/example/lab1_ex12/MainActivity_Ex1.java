package com.example.lab1_ex12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity_Ex1 extends AppCompatActivity {

    private EditText input1, input2;
    private TextView output1;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ex1);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        output1 = findViewById(R.id.output1);
        calculateButton = findViewById(R.id.calculateButton);
    }

    public void calculate(View view){

        double x, y, z;
        x = Double.parseDouble(input1.getText().toString());
        y = Double.parseDouble(input2.getText().toString());
        z = x+y;
        output1.setText(String.valueOf(z));

    }
}