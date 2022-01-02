package com.example.myapplication.Heating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Heating extends AppCompatActivity implements HeatingInterface {



    LinearLayout verticalLinearLayoutVertical;
    ArrayList<HeatingMachine> heatingMachines = new ArrayList<HeatingMachine>();

    int userID=-1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heating);

        int value = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getInt("idHeating");
            System.out.println(value+" mainin ici");
        }
        userID=value;

        ArrayList<HeatingMachine> heatingMachines = new ArrayList<HeatingMachine>();


        verticalLinearLayoutVertical = findViewById(R.id.verticalLayoutVertical);
        getFromTextToCreateDevice(userID);



    }

    public void getFromTextToCreateDevice(int userid){

        String strLine = null;
        try {
            BufferedReader br = null;

            br = new BufferedReader(new InputStreamReader(this.getAssets().open("HeatingDevicesList.txt")));


            while ((strLine = br.readLine()) != null) {

                String[] splitedText=strLine.split(",");

                if(Integer.parseInt(splitedText[0])==userid){
                    HeatingMachine newHeatingMachine=new HeatingMachine();
                    newHeatingMachine.setName(splitedText[1]);
                    newHeatingMachine.setOnOff(Integer.parseInt(splitedText[2]));
                    newHeatingMachine.setCapacity(Integer.parseInt(splitedText[3]));
                    newHeatingMachine.setTemp(Integer.parseInt(splitedText[4]));
                    newHeatingMachine.setDesiredTemp(Integer.parseInt(splitedText[5]));
                    System.out.println(newHeatingMachine.getName());
                    addDevices(newHeatingMachine);
                    heatingMachines.add(newHeatingMachine);
                }
            }

            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void printDevices() {

    }


    public boolean addDevices(HeatingMachine hm) {

        LinearLayout device = new LinearLayout(Heating.this);

        device.setOrientation(LinearLayout.HORIZONTAL);

        // initialising new layout
        ImageView imageView = new ImageView(Heating.this);

        // setting the image in the layout
        imageView.setImageResource(R.drawable.heaterandcooler);

        int width = 200;
        int height = 200;



        LinearLayout.LayoutParams paramsI = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        //paramsI.setMargins(0, 30, 0, 10);
        paramsI.weight = 0.2f;
        imageView.setLayoutParams(paramsI);


        device.addView(imageView);





        //name
        TextView textView = new TextView(Heating.this);
        textView.setText(hm.getName());


        LinearLayout.LayoutParams paramsT = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        // paramsT.setMargins(0, 40, 0, 10);
        paramsT.weight = 0.2f;
        textView.setLayoutParams(paramsT);


        device.addView(textView);


        //power
        TextView textView2 = new TextView(Heating.this);
        textView2.setText("%" + hm.getCapacity() + ", " + hm.getTemp() + " ->" + hm.getDesiredTemp());


        LinearLayout.LayoutParams paramsT2 = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        // paramsT.setMargins(0, 40, 0, 10);
        paramsT2.weight = 0.2f;
        textView.setLayoutParams(paramsT2);
        device.addView(textView2);





        SwitchCompat sw = new SwitchCompat(Heating.this);

        sw.setText("On/Off");


        if(hm.getOnOff()==1){
            sw.toggle();
        }


        boolean switchResult = sw.isChecked();

        System.out.println(switchResult);

        LinearLayout.LayoutParams paramsS = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        paramsS.setMargins(15, 0, 90, 0);
        paramsS.weight = 0.2f;
        sw.setLayoutParams(paramsS);

        
        
        
        
        
        
        if(!sw.isChecked()){
            textView2.setVisibility(View.INVISIBLE);
        }
        
        device.addView(sw);
        
        verticalLinearLayoutVertical.addView(device);





        return false;
    }

    @Override
    public void assignTask() {

    }

    @Override
    public boolean deviceAvailable() {
        return false;
    }

    @Override
    public int roomTemprature() {
        return 0;
    }

    @Override
    public int getRoomTempOfRoom(int roomIndex) {
        return 0;
    }

    @Override
    public int setTempOfRoom(int roomIndex) {
        return 0;
    }
}