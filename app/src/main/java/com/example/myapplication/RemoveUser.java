package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class RemoveUser extends AppCompatActivity {

    TextView user1;
    TextView user2;
    TextView noUser;
    ImageButton removeUser1;
    ImageButton removeUser2;

   static Boolean isUser1Exist =true;
   static Boolean isUser2Exist = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_user);




        user1 = findViewById(R.id.user1);
        user2 = findViewById(R.id.user2);
        noUser = findViewById(R.id.noUser);

        removeUser1 = findViewById(R.id.removeuser1);
        removeUser2 = findViewById(R.id.removeuser2);



        noUser.setVisibility(View.INVISIBLE);

        if(!isUser1Exist){
            user1.setVisibility(View.INVISIBLE);
            removeUser1.setVisibility(View.INVISIBLE);
        }
        if(!isUser2Exist){
            user2.setVisibility(View.INVISIBLE);
            removeUser2.setVisibility(View.INVISIBLE);
        }

        if(isUser1Exist == false && isUser2Exist == false){
            noUser.setVisibility(View.VISIBLE);
            noUser.setText("There is no member in this home");
            noUser.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }


        user1.setText("Mehmet - Member");
        user2.setText("Osman - Member");

        removeUser1.setOnClickListener(v -> {
            user1.setVisibility(View.INVISIBLE);
            removeUser1.setVisibility(View.INVISIBLE);
            isUser1Exist = false;
            //change file

        });


        removeUser2.setOnClickListener(v -> {
            user2.setVisibility(View.INVISIBLE);
            removeUser2.setVisibility(View.INVISIBLE);
            isUser2Exist = false;

            //change file

        });




    }
}