package com.example.lab1_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity_Ex2 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.lab1_ex2";
    private EditText input1;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ex2);

        input1 = findViewById(R.id.input1);
        calculateButton = findViewById(R.id.calculateButton);
    }

    public void calculate(View view){

        Intent myIntent = new Intent(this, SubActivity.class);
        myIntent.putExtra(EXTRA_MESSAGE, input1.getText().toString());

        startActivity(myIntent);
    }
}