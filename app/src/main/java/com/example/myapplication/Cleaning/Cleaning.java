package com.example.myapplication.Cleaning;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.myapplication.Heating.HeatingMachine;
import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cleaning extends AppCompatActivity implements CleaningInterface {

    ArrayList<CleaningDevice> heatingMachines = new ArrayList<CleaningDevice>();

    ImageButton addDevice;
    LinearLayout verticalLinearLayoutVertical;


    int userID=-1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning);


        int value = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getInt("idHeating");
            System.out.println(value+" mainin ici");
        }
        userID=value;

        getFromTextToCreateDevice(userID);



        verticalLinearLayoutVertical = findViewById(R.id.verticalLayoutVertical);
        addDevice = findViewById(R.id.addDevice);

        addDevice.setOnClickListener(v -> {
            //read txt file and call this method


        });


        getFromTextToCreateDevice(userID);
    }


    public void getFromTextToCreateDevice(int userid){

        String strLine = null;
        try {
            BufferedReader br = null;

            br = new BufferedReader(new InputStreamReader(this.getAssets().open("CleaningDevicesList.txt")));


            while ((strLine = br.readLine()) != null) {

                String[] splitedText=strLine.split(",");

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

            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void printDevices() {

    }

    @Override
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
        paramsI.weight = 0.4f;
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
    public boolean deviceAvailable() {
        return false;
    }

    @Override
    public int deviceProcess() {
        return 0;
    }
}