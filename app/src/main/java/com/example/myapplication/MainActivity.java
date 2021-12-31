package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.InputStreamReader;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText EDusername = findViewById(R.id.username);
        EditText EDpassword = findViewById(R.id.password);
        Button login = findViewById(R.id.login);




        login.setOnClickListener(v -> {
            int status = getFromFile(EDusername.getText().toString(),EDpassword.getText().toString());
            if(status!=-1){
                Toast.makeText(getApplicationContext(),
                        "Succesfully loged",Toast.LENGTH_SHORT).show();
                //go new page

                Intent intent = new Intent(getApplicationContext(), SmartHomeMenu.class);
                intent.putExtra("id",status);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),
                        "Username or Password is incorrect!",Toast.LENGTH_SHORT).show();

            }
        });


    }

    private int getFromFile(String EDusername,String EDpassword)
    {
        int myData = -1;


       // File sdcard = Environment.getExternalStorageDirectory();
        //File myExternalFile = new File("Users.txt");

        try {
            BufferedReader br = null;

            br = new BufferedReader(new InputStreamReader(this.getAssets().open("Users.txt")));
            //BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            //BufferedReader br =new BufferedReader(new FileReader("Users.txt"));


            System.out.println("aasdasd");
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] splitedText=strLine.split(" ");
                if(splitedText[1].equals(EDusername) && splitedText[2].equals(EDpassword)){
                    int userID=Integer.parseInt(splitedText[0]);
                    myData=userID;
                }
            }
            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return myData;
    }



}