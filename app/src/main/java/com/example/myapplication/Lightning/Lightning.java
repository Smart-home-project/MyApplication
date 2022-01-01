package com.example.myapplication.Lightning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lightning extends AppCompatActivity implements LightningInterface {



    LinearLayout verticalLinearLayoutVertical;






    int userID=-1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightning);


        int value = 0;
        Bundle extras1 = getIntent().getExtras();
        if(extras1 != null) {
            value = extras1.getInt("idHeating");
            System.out.println(value+" mainin ici");
        }

        userID=value;
        String line=getFromTextFinal(userID);
        System.out.println(line);




        verticalLinearLayoutVertical = findViewById(R.id.verticalLayoutVertical);

        //read txt file and call this method
        addDevices();






    }





    public String getFromTextFinal(int userid){
        String strLine = null;
        try {
            BufferedReader br = null;

            br = new BufferedReader(new InputStreamReader(this.getAssets().open("DeviceList.txt")));

            int calc = (userid*3)+1;
            for(int t=0;t<calc;t++){
                strLine = br.readLine();
            }
            //String[] splitedText=strLine.split(",");

            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return strLine;
    }


    public void printDevices() {


    }

    @Override
    public boolean addDevices() {


        LinearLayout device = new LinearLayout(Lightning.this);

        device.setOrientation(LinearLayout.HORIZONTAL);

        // initialising new layout
        ImageView imageView = new ImageView(Lightning.this);

        // setting the image in the layout
        imageView.setImageResource(R.drawable.lightbulb);

        int width = 200;
        int height = 200;



        LinearLayout.LayoutParams paramsI = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        //paramsI.setMargins(0, 30, 0, 10);
        paramsI.weight = 0.4f;
        imageView.setLayoutParams(paramsI);


        device.addView(imageView);






        TextView textView = new TextView(Lightning.this);
        textView.setText("Hi");


        LinearLayout.LayoutParams paramsT = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        // paramsT.setMargins(0, 40, 0, 10);
        paramsT.weight = 0.2f;
        textView.setLayoutParams(paramsT);


        device.addView(textView);





        SwitchCompat sw = new SwitchCompat(Lightning.this);

        sw.setText("On/Off");

        sw.toggle();

        boolean switchResult = sw.isChecked();

        System.out.println(switchResult);

        LinearLayout.LayoutParams paramsS = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        paramsS.setMargins(0, 0, 90, 0);
        paramsS.weight = 0.4f;
        sw.setLayoutParams(paramsS);

        device.addView(sw);



        verticalLinearLayoutVertical.addView(device);


        return false;
    }

    @Override
    public void assignTask() {

    }

    @Override
    public boolean isDeviceTurnedOn() {
        return false;
    }

    @Override
    public void printTurnedOnDevices() {

    }

    @Override
    public void printTurnedOffDevices() {

    }


}