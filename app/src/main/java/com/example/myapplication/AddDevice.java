package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Cleaning.Cleaning;

public class AddDevice extends AppCompatActivity {

    EditText name, vacuun, capacity;
    Button addDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);

        name = findViewById(R.id.name);
        vacuun = findViewById(R.id.vacuum);
        capacity = findViewById(R.id.capacity);
        addDevice = findViewById(R.id.addDevice);


        addDevice.setOnClickListener(v -> {

           String deviceName = name.getText().toString();
           String vacuumPower = vacuun.getText().toString();
           String deviceCapacity = capacity.getText().toString();

            Intent intent = new Intent(getApplicationContext(), Cleaning.class);
            intent.putExtra("deviceName", deviceName);
            intent.putExtra("vacuumPower", vacuumPower);
            intent.putExtra("deviceCapacity", deviceCapacity);
            intent.putExtra("counter", 1);
            startActivity(intent);


        });






    }
}