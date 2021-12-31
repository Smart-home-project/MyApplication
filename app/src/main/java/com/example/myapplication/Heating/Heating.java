package com.example.myapplication.Heating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Heating extends AppCompatActivity implements HeatingInterface {

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

        String line=getFromTextFinal(userID);
        System.out.println(line);

    }

    public String getFromTextFinal(int userid){
        String strLine = null;
        try {
            BufferedReader br = null;

            br = new BufferedReader(new InputStreamReader(this.getAssets().open("DeviceList.txt")));

            int calc = (userid*3)+0;
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



    @Override
    public void printDevices() {

    }

    @Override
    public boolean addDevices() {
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