package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Cleaning.Cleaning;
import com.example.myapplication.Heating.Heating;
import com.example.myapplication.Lightning.Lightning;

public class SmartHomeMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_home_menu);

        Button heatButton = findViewById(R.id.heating);
        Button lightButton = findViewById(R.id.lightning);
        Button cleanButton = findViewById(R.id.cleaning);





        heatButton.setOnClickListener(v -> {

            Intent intent = new Intent(SmartHomeMenu.this, Heating.class);
            startActivity(intent);

        });


        lightButton.setOnClickListener(v -> {

            Intent intent = new Intent(SmartHomeMenu.this, Lightning.class);
            startActivity(intent);

        });


        cleanButton.setOnClickListener(v -> {

            Intent intent = new Intent(SmartHomeMenu.this, Cleaning.class);
            startActivity(intent);

        });




    }
}