package com.example.myapplication.Lightning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.Heating.Heating;
import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputLayout;

public class Lightning extends AppCompatActivity {

<<<<<<< Updated upstream
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightning);
=======
public class Lightning extends AppCompatActivity implements LightningInterface {


    ImageButton addDevice;
    LinearLayout verticalLinearLayoutVertical;
    LinearLayout verticalLinearLayoutHorizaontal;


    int counter = 0;

    int userID=-1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightning);

        addDevice = findViewById(R.id.addDevice);
        verticalLinearLayoutVertical = findViewById(R.id.verticalLayoutVertical);
        verticalLinearLayoutHorizaontal = findViewById(R.id.verticalLayoutHorizontal);



        int value = 0;
        Bundle extras1 = getIntent().getExtras();
        if(extras1 != null) {
            value = extras1.getInt("idHeating");
            System.out.println(value+" mainin ici");
        }

        userID=value;
        String line=getFromTextFinal(userID);
        System.out.println(line);



        addDevice.setOnClickListener(v -> {


            LinearLayout device = new LinearLayout(Lightning.this);

            device.setOrientation(LinearLayout.HORIZONTAL);

            // initialising new layout
            ImageView imageView = new ImageView(Lightning.this);

            // setting the image in the layout
            imageView.setImageResource(R.drawable.heaterandcooler);

            int width = 200;
            int height = 200;



            LinearLayout.LayoutParams paramsI = new LinearLayout.LayoutParams(width, height);

            // setting the margin in linearlayout
            paramsI.setMargins(10, 30, 0, 10);
            imageView.setLayoutParams(paramsI);

            device.addView(imageView);






            TextView textView = new TextView(Lightning.this);
            textView.setText("Hi");


            LinearLayout.LayoutParams paramsT = new LinearLayout.LayoutParams(width, height);

            // setting the margin in linearlayout
            paramsT.setMargins(10, 40, 0, 10);
            textView.setLayoutParams(paramsT);


            device.addView(textView);





            SwitchCompat sw = new SwitchCompat(Lightning.this);

            sw.setText("On/Off");

            sw.toggle();

            boolean switchResult = sw.isChecked();

            System.out.println(switchResult);

            LinearLayout.LayoutParams paramsS = new LinearLayout.LayoutParams(width, height);

            // setting the margin in linearlayout
            paramsS.setMargins(10, 30, 0, 10);
            sw.setLayoutParams(paramsS);

            device.addView(sw);



            verticalLinearLayoutVertical.addView(device);
            counter++;

        });


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


>>>>>>> Stashed changes
    }







}