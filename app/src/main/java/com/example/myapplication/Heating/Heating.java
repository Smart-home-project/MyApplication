package com.example.myapplication.Heating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;

public class Heating extends AppCompatActivity {


    ImageButton addDevice;
    LinearLayout verticalLinearLayout;
    LinearLayout horizontalLinearLayout;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heating);



        addDevice = findViewById(R.id.addDevice);
        verticalLinearLayout = findViewById(R.id.verticalLayout);
        horizontalLinearLayout = findViewById(R.id.horizontalLayout);



        addDevice.setOnClickListener(v -> {

            // initialising new layout
            ImageView imageView = new ImageView(Heating.this);

            // setting the image in the layout
            imageView.setImageResource(R.drawable.heaterandcooler);

            TextView textView = new TextView(Heating.this);
            textView.setText("Hi");

            // calling addview with width and height
            addvieW(imageView, 200, 200, textView, 50, 50);
            counter++;

        });



    }


    private void addvieW(ImageView imageView, int widthI, int heightI, TextView text, int widthT, int heightT) {
        LinearLayout.LayoutParams paramsI = new LinearLayout.LayoutParams(widthI, heightI);

        // setting the margin in linearlayout
        paramsI.setMargins(10, 30, 0, 10);
        imageView.setLayoutParams(paramsI);

        LinearLayout.LayoutParams paramsT = new LinearLayout.LayoutParams(widthT, heightT);
        paramsT.setMargins(50, 30, 0, 10);
        text.setLayoutParams(paramsT);

        ListView list = new ListView(this);
        list.addView(imageView);
        list.addView(text);


        // adding the image in layout
        verticalLinearLayout.addView(imageView, counter);
        verticalLinearLayout.addView(text, counter);

       // verticalLinearLayout.addView(list);



    }


}