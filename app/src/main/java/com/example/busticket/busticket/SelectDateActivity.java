package com.example.busticket.busticket;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SelectDateActivity extends AppCompatActivity {

    ArrayAdapter destinationAdapter,originAdapter;
    Spinner spinner1,spinner2;
    Button dateButton,submit;
    TextView datetxt;
    SharedPreferences preferences;

    Calendar currentDate;
    int day, month, year;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);
        dateButton = (Button) findViewById(R.id.datebtn);
        datetxt = (TextView) findViewById(R.id.departure_date);
        submit = (Button) findViewById(R.id.submit);
        preferences = getSharedPreferences("booking_info",0);


        spinner1 = (Spinner) findViewById(R.id.from);
        originAdapter =  ArrayAdapter.createFromResource(this,R.array.from,android.R.layout.simple_spinner_item);
        originAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//layout for each dropdown list for the spinner
        spinner1.setAdapter(this.originAdapter);

        spinner2 = (Spinner) findViewById(R.id.to);
        destinationAdapter =  ArrayAdapter.createFromResource(this,R.array.to,android.R.layout.simple_spinner_item);
        destinationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//layout for each dropdown list for the spinner
        spinner2.setAdapter(this.destinationAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                final String from = spinner1.getSelectedItem().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("from",from);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 final String to = spinner2.getSelectedItem().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("to",to);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        currentDate = Calendar.getInstance();
        day = currentDate.get(Calendar.DAY_OF_MONTH);
        month = currentDate.get(Calendar.MONTH);
        year = currentDate.get(Calendar.YEAR);

        month = month+1;

       // datetxt.setText(year+"-"+month+"-"+day);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(SelectDateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthofyear, int dayofmonth) {
                        monthofyear= monthofyear+1;
                        datetxt.setText(year+"-"+monthofyear+"-"+dayofmonth);

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String date = (String) datetxt.getText();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("departure_date",date);
                editor.apply();

                Intent intent = new Intent(SelectDateActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
