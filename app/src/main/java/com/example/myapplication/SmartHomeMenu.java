package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        Button removeUser = findViewById(R.id.removeUser);
        TextView text = findViewById(R.id.textView);

        int value = 0;
        String name = "";


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getInt("id");
            System.out.println(value+" mainin ici");
            name = extras.getString("username");


        }

        text.setText("Welcome "+ name + " to Smart Home app");
        text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        int finalValue = value;
        heatButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(),
                    "Succesfull",Toast.LENGTH_SHORT).show();
            //go new page

            Intent intent = new Intent(getApplicationContext(), Heating.class);
            intent.putExtra("idHeating", finalValue);
            startActivity(intent);

        });


        lightButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(),
                    "Succesfull",Toast.LENGTH_SHORT).show();
            //go new page

            Intent intent = new Intent(getApplicationContext(), Lightning.class);
            intent.putExtra("idLightning",finalValue);
            startActivity(intent);
        });




        cleanButton.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),
                    "Succesfull",Toast.LENGTH_SHORT).show();
            //go new page

            Intent intent = new Intent(getApplicationContext(), Cleaning.class);
            intent.putExtra("idCleaning",finalValue);
            startActivity(intent);
        });


        if(!name.equals("Ahmet")){
            removeUser.setVisibility(View.INVISIBLE);
        }

        removeUser.setOnClickListener(v -> {


                Intent intent = new Intent(getApplicationContext(), RemoveUser.class);
                startActivity(intent);


        });




    }


}