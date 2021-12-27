package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText EDusername = findViewById(R.id.username);
        EditText EDpassword = findViewById(R.id.password);
        Button login = findViewById(R.id.login);




        login.setOnClickListener(v -> {

            if(EDusername.getText().toString().equals("admin") && EDpassword.getText().toString().equals("1234")){
                Toast.makeText(getApplicationContext(),
                        "Succesfully loged",Toast.LENGTH_SHORT).show();
                //go new page
                Intent intent = new Intent(getApplicationContext(), SmartHomeMenu.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(),
                        "Username or Password is incorrect!",Toast.LENGTH_SHORT).show();

            }
        });




    }
}