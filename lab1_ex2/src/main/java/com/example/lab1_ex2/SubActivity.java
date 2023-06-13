package com.example.lab1_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView messageReceive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent myIntent = getIntent();

        messageReceive = findViewById(R.id.messageReceive);

        messageReceive.setText(myIntent.getStringExtra(MainActivity_Ex2.EXTRA_MESSAGE));
    }
}