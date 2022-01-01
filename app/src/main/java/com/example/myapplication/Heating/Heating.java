package com.example.myapplication.Heating;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

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

<<<<<<< Updated upstream
    @Override
=======

    ImageButton addDevice;
    LinearLayout verticalLinearLayoutImage;
    LinearLayout verticalLinearLayoutText;
    LinearLayout verticalLinearLayoutSwitch;
    int counter = 0;
    int userID=-1;
>>>>>>> Stashed changes
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heating);

<<<<<<< Updated upstream
=======

        addDevice = findViewById(R.id.addDevice);
        verticalLinearLayoutImage = findViewById(R.id.verticalLayoutImage);
        verticalLinearLayoutText = findViewById(R.id.verticalLayoutText);
        verticalLinearLayoutSwitch = findViewById(R.id.verticalLayoutSwitch);




        int value = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getInt("idHeating");
            System.out.println(value+" mainin ici");
        }
        userID=value;
>>>>>>> Stashed changes


<<<<<<< Updated upstream
        addDevice = findViewById(R.id.addDevice);
        verticalLinearLayout = findViewById(R.id.verticalLayout);
        horizontalLinearLayout = findViewById(R.id.horizontalLayout);

=======




        addDevice.setOnClickListener(v -> {

            // initialising new layout
            ImageView imageView = new ImageView(Heating.this);

            // setting the image in the layout
            imageView.setImageResource(R.drawable.heaterandcooler);

            int width = 200;
            int height = 200;



            // calling addview with width and height
            addImage(imageView, width, height);


            TextView textView = new TextView(Heating.this);
            textView.setText("Hi");

            addText(textView, width, height);


            SwitchCompat sw = new SwitchCompat(Heating.this);

            sw.setText("On/Off");

            sw.toggle();

            boolean switchResult = sw.isChecked();

            System.out.println(switchResult);


            addSwitch(sw, 300, height);


            counter++;

        });



    }




    private void addImage(ImageView imageView, int widthI, int heightI) {
        LinearLayout.LayoutParams paramsI = new LinearLayout.LayoutParams(widthI, heightI);

        // setting the margin in linearlayout
        paramsI.setMargins(10, 30, 0, 10);
        imageView.setLayoutParams(paramsI);


        // adding the image in layout
        verticalLinearLayoutImage.addView(imageView, counter);


    }

    private void addText(TextView textView, int widthI, int heightI) {
        LinearLayout.LayoutParams paramsI = new LinearLayout.LayoutParams(widthI, heightI);

        // setting the margin in linearlayout
        paramsI.setMargins(10, 40, 0, 10);
        textView.setLayoutParams(paramsI);


        // adding the image in layout
        verticalLinearLayoutText.addView(textView, counter);


    }

    private void addSwitch(SwitchCompat sw, int widthI, int heightI) {
        LinearLayout.LayoutParams paramsI = new LinearLayout.LayoutParams(widthI, heightI);

        // setting the margin in linearlayout
        paramsI.setMargins(10, 30, 0, 10);
        sw.setLayoutParams(paramsI);


        // adding the image in layout
        verticalLinearLayoutSwitch.addView(sw, counter);


    }




    public String getFromTextFinal(int userid){
        String strLine = null;
        try {
            BufferedReader br = null;
>>>>>>> Stashed changes


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