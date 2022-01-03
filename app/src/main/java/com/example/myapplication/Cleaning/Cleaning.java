package com.example.myapplication.Cleaning;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.myapplication.AddDevice;
import com.example.myapplication.Heating.Heating;
import com.example.myapplication.Heating.HeatingMachine;
import com.example.myapplication.Lightning.Lightning;
import com.example.myapplication.MainActivity;
import com.example.myapplication.MemoryReserve;
import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cleaning extends AppCompatActivity implements CleaningInterface {

    ArrayList<CleaningDevice> heatingMachines = new ArrayList<CleaningDevice>();

    ImageButton addDevice;
    ImageButton removeDevice;
    LinearLayout verticalLinearLayoutVertical;

    LinearLayout[] deviceLayouts = new LinearLayout[100];
    int currentCounter = 0;


    int userID=-1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning);


        int value = 0;
        int counter = 0;


        String deviceName = "";
        String vacuumPower = "";
        String deviceCapacity = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getInt("idHeating");
            System.out.println(value+" mainin ici");
            counter = extras.getInt("counter");
            deviceName = extras.getString("deviceName");
            vacuumPower = extras.getString("vacuumPower");
            deviceCapacity = extras.getString("deviceCapacity");
        }
        userID=value;

        getFromTextToCreateDevice(userID);



        verticalLinearLayoutVertical = findViewById(R.id.verticalLayoutVertical);
        addDevice = findViewById(R.id.addDevice);
        removeDevice = findViewById(R.id.removeDevice);

        addDevice.setOnClickListener(v -> {
            //read txt file and call this method

            Intent intent = new Intent(getApplicationContext(), AddDevice.class);
            startActivity(intent);

        });

        removeDevice.setOnClickListener(v -> {
            //read txt file and call this method
            try{
                for(int i = 1; i < MainActivity.memoryReserve.chosenCleaning.length; i++) {
                    if(MainActivity.memoryReserve.chosenCleaning[i])
                        deviceLayouts[i].setVisibility(View.INVISIBLE);
                }
            } catch (Exception e) {

            }


        });


        getFromTextToCreateDevice(userID);

        CleaningDevice cd;


        if(counter == 1){

           cd  = new CleaningDevice();

            cd.setName(deviceName);
            cd.setCapacity(Integer.valueOf(deviceCapacity));
            cd.setVacuumPower(Integer.valueOf(vacuumPower));
            cd.setOnOff(1);

            addDevices(cd);


        }




    }

    public void getFromTextToCreateDevice(int userid){

        String strLine = null;
        try {
            BufferedReader br = null;

            br = new BufferedReader(new InputStreamReader(this.getAssets().open("CleaningDevicesList.txt")));
            int removedCounter = 1;
String theadded ="";
            while ((strLine = br.readLine()) != null) {

                String[] splitedText=strLine.split(",");
                if(!MainActivity.memoryReserve.chosenCleaning[removedCounter]) {

                if(Integer.parseInt(splitedText[0])==userid){
                    CleaningDevice newCleaningDevice=new CleaningDevice();
                    newCleaningDevice.setName(splitedText[1]);
                    newCleaningDevice.setOnOff(Integer.parseInt(splitedText[2]));
                    newCleaningDevice.setVacuumPower(Integer.parseInt(splitedText[3]));
                    newCleaningDevice.setCapacity(Integer.parseInt(splitedText[4]));
                    System.out.println(newCleaningDevice.getName());
                        addDevices(newCleaningDevice);
                        heatingMachines.add(newCleaningDevice);



                }
                }
                removedCounter++;

            }

            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void printDevices() {

    }


    public boolean addDevices(CleaningDevice cd) {

        LinearLayout device = new LinearLayout(Cleaning.this);

        device.setOrientation(LinearLayout.HORIZONTAL);

        // initialising new layout
        ImageView imageView = new ImageView(Cleaning.this);

        // setting the image in the layout
        imageView.setImageResource(R.drawable.cleaner);

        int width = 200;
        int height = 200;



        LinearLayout.LayoutParams paramsI = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        //paramsI.setMargins(0, 30, 0, 10);
        paramsI.weight = 0.25f;
        imageView.setLayoutParams(paramsI);


        device.addView(imageView);






        TextView textView = new TextView(Cleaning.this);

        //TODO read txt file and get device name
        textView.setText(cd.getName());


        LinearLayout.LayoutParams paramsT = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        // paramsT.setMargins(0, 40, 0, 10);
        paramsT.weight = 0.2f;
        textView.setLayoutParams(paramsT);


        device.addView(textView);


        //power
        TextView textView2 = new TextView(Cleaning.this);
        textView2.setText("%" + cd.getVacuumPower() + " " + cd.getCapacity());


        LinearLayout.LayoutParams paramsT2 = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        // paramsT.setMargins(0, 40, 0, 10);
        paramsT2.weight = 0.25f;
        textView.setLayoutParams(paramsT2);
        device.addView(textView2);



        SwitchCompat sw = new SwitchCompat(Cleaning.this);

        sw.setText("On/Off");


        //TODO read txt file and get the on/off info
        if(cd.getOnOff()==1){
            sw.toggle();
        }
        //sw.toggle();


        boolean switchResult = sw.isChecked();

        System.out.println(switchResult);

        LinearLayout.LayoutParams paramsS = new LinearLayout.LayoutParams(width, height);

        // setting the margin in linearlayout
        paramsS.setMargins(20, 0, 90, 0);
        paramsS.weight = 0.3f;
        sw.setLayoutParams(paramsS);

        device.addView(sw);

        if(!sw.isChecked()){
            textView2.setVisibility(View.INVISIBLE);
        }

        device.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int dev = FindDevice(device);
                if(!MainActivity.memoryReserve.chosenCleaning[dev]) {
                    device.setBackgroundColor(Color.parseColor("#0044EE"));

                    MainActivity.memoryReserve.chosenCleaning[dev] = true;
                }

                else {
                    device.setBackgroundColor(Color.parseColor("#ffffff"));

                    MainActivity.memoryReserve.chosenCleaning[dev] = false;
                }
                System.out.println("chosenCleaning at" + dev +" " +  MainActivity.memoryReserve.chosenCleaning);

                return false;
            }
        });
        deviceLayouts[currentCounter++] = device;

        verticalLinearLayoutVertical.addView(device);

        return false;
    }

    public int FindDevice(LinearLayout device) {
        int k = 0;
        for(int i = 0; i < deviceLayouts.length; i++) {
            if(deviceLayouts[i] == device) {
                System.out.println("returned " + (i));

                return i;

            }

        }
        return k;
    }

    @Override
    public void assignTask() {

    }

    @Override
    public boolean deviceAvailable() {
        return false;
    }

    @Override
    public int deviceProcess() {
        return 0;
    }
}