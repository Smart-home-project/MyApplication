package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SmartHomeMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_home_menu);

        Button heatButton = findViewById(R.id.heating);
        Button lightButton = findViewById(R.id.lightning);
        Button cleanButton = findViewById(R.id.cleaning);





        heatButton.setOnClickListener(v -> {

        });


        lightButton.setOnClickListener(v -> {

        });


        cleanButton.setOnClickListener(v -> {

        });




    }
}