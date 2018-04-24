package com.example.busticket.busticket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button normal,deluxe,ac,signup;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        normal = (Button) findViewById(R.id.normal);
        deluxe = (Button) findViewById(R.id.deluxe);
        ac = (Button) findViewById(R.id.ac);
        preferences = getSharedPreferences("booking_info",0);


        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = normal.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Bus_type",type);
                editor.apply();
                Intent register= new Intent(MainActivity.this,BusTime.class);
                startActivity(register);
            }
        });

        deluxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = deluxe.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Bus_type",type);
                editor.apply();
                Intent register= new Intent(MainActivity.this,BusTime.class);
                startActivity(register);
            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = ac.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Bus_type",type);
                editor.apply();
                Intent register= new Intent(MainActivity.this,BusTime.class);
                startActivity(register);
            }
        });

    }
}
