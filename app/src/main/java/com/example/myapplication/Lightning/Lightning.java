package com.example.myapplication.Lightning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lightning extends AppCompatActivity implements LightningInterface {


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
    }


    TextInputLayout text =findViewById(R.id.TextLayer);


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