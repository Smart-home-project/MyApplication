package com.example.myapplication.Lightning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Heating.Heating;
import com.example.myapplication.Heating.HeatingMachine;
import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputLayout;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Lightning extends AppCompatActivity implements LightningInterface {


    ArrayList<LightningDevice> lightningDevices = new ArrayList<LightningDevice>();
    ArrayList<LinearLayout> deviceLayouts = new ArrayList<LinearLayout>();
    LinearLayout verticalLinearLayoutVertical;
    ArrayList<SwitchCompat> switchList = new ArrayList<SwitchCompat>();
    SwitchCompat sw;
    boolean[] chosen = new boolean[100];
    int currentDeviceCounter = 0;


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

        verticalLinearLayoutVertical = findViewById(R.id.verticalLayoutVertical);

        //read txt file and call this method
        getFromTextToCreateDevice(userID);

 //       sw.setOnClickListener(v -> {
        //          boolean switchResult = sw.isChecked();
        //          if(switchResult){
        //               //false to true;
        //
        //
        //        }else{
                //true to false;

        //        }

        //   });

    }


    public void getFromTextToCreateDevice(int userid){

        String strLine = null;
        try {
            BufferedReader br = null;

            br = new BufferedReader(new InputStreamReader(this.getAssets().open("LightningDevicesList.txt")));


            while ((strLine = br.readLine()) != null) {

                String[] splitedText=strLine.split(",");

                if(Integer.parseInt(splitedText[0])==userid){
                    LightningDevice newLightningDevice=new LightningDevice();
                    newLightningDevice.setName(splitedText[1]);
                    newLightningDevice.setOnOff(Integer.parseInt(splitedText[2]));
                    newLightningDevice.setBrithness(Integer.parseInt(splitedText[3]));
                    newLightningDevice.setColor(splitedText[4]);
                    System.out.println(newLightningDevice.getName());
                    addDevices(newLightningDevice);
                    lightningDevices.add(newLightningDevice);
                }
            }

            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void printDevices() {


    }


    public boolean addDevices(LightningDevice ld) {


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
        paramsI.weight = 0.2f;
        imageView.setLayoutParams(paramsI);


        device.addView(imageView);


        TextView textView = new TextView(Lightning.this);
        textView.setText(ld.getName());


        LinearLayout.LayoutParams paramsT = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        // paramsT.setMargins(0, 40, 0, 10);
        paramsT.weight = 0.1f;
        textView.setLayoutParams(paramsT);


        device.addView(textView);


        //power
        TextView textView2 = new TextView(Lightning.this);
        textView2.setText("%" + ld.getBrithness() + " " + ld.getColor());


        LinearLayout.LayoutParams paramsT2 = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        // paramsT.setMargins(0, 40, 0, 10);
        paramsT2.weight = 0.25f;
        textView.setLayoutParams(paramsT2);
        device.addView(textView2);




        sw = new SwitchCompat(Lightning.this);

        switchList.add(sw);
        sw.setText("On/Off");

        if(ld.getOnOff()==1){
            sw.toggle();
        }


        boolean switchResult = sw.isChecked();


        LinearLayout.LayoutParams paramsS = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        paramsS.setMargins(20, 0, 90, 0);
        paramsS.weight = 0.25f;
        sw.setLayoutParams(paramsS);

        device.addView(sw);

        if(!sw.isChecked()){
            textView2.setVisibility(View.INVISIBLE);
        }


        device.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                chosen[FindDevice(device)] = !chosen[FindDevice(device)];

                if(chosen[FindDevice(device)])
                    device.setBackgroundColor(Color.parseColor("#0000CC"));
                else
                    device.setBackgroundColor(Color.parseColor("#ffffff"));

                return false;
            }
        });
        verticalLinearLayoutVertical.addView(device);

        deviceLayouts.add(device);
        currentDeviceCounter++;

        return false;
    }

    public int FindDevice(LinearLayout device) {
        for(int i = 0; i < deviceLayouts.size(); i++)
            if(deviceLayouts.get(i) == device)
                return i;

            return 0;
    }


    @Override
    public void assignTask(LightningDevice lw) {

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