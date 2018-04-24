package com.example.busticket.busticket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BusTime extends AppCompatActivity {

    Button pm12,pm1,pm3,pm5;
    TextView date,type;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_time);

        pm12 = (Button) findViewById(R.id.pm12);
        pm1= (Button) findViewById(R.id.pm1);
        pm3 = (Button) findViewById(R.id.pm3);
        pm5 = (Button) findViewById(R.id.pm5);
        type = (TextView) findViewById(R.id.bus_catagory);
        preferences = getSharedPreferences("booking_info",0);
        date = (TextView) findViewById(R.id.bus_date);
        date.setText(preferences.getString("departure_date",""));
        type.setText(preferences.getString("Bus_type",""));

        pm12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                String time = pm12.getText().toString();
                //Toast.makeText(BusTime.this, time, Toast.LENGTH_SHORT).show();
                editor.putString("departure_time",time);

                Intent intent = new Intent(BusTime.this,BookSeatActivity.class);
                startActivity(intent);
            }
        });
    }
}
