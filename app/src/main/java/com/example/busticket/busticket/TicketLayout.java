package com.example.busticket.busticket;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TicketLayout extends AppCompatActivity {

    SharedPreferences loginpreferences,bookingPreferences;
    TextView issued_date,pessenger_name,bus_no,bus_type,destination,no_of_seat,time,ticket_date,origin,destinationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_layout);
        loginpreferences= getSharedPreferences("login_info",0);
        bookingPreferences = getSharedPreferences("booking_info",0);
        issued_date = (TextView) findViewById(R.id.Idate);
        pessenger_name = (TextView) findViewById(R.id.username);
        bus_no = (TextView) findViewById(R.id.bus_no);
        bus_type = (TextView) findViewById(R.id.bus_type);
        destination = (TextView) findViewById(R.id.destination);
        no_of_seat = (TextView) findViewById(R.id.no_of_seat);
        time = (TextView) findViewById(R.id.Ttime);
        ticket_date = (TextView) findViewById(R.id.Tdate);
        time.setText(bookingPreferences.getString("departure_time",""));
        origin = (TextView) findViewById(R.id.origin);
        destinationView = (TextView) findViewById(R.id.destinationView);

        String username =loginpreferences.getString("username","");
        pessenger_name.setText(username);
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a", Locale.getDefault()).format(new Date());
        issued_date.setText(date);

        String from = bookingPreferences.getString("from","");
        origin.setText(from);
        String to = bookingPreferences.getString("to","");
        destinationView.setText(to);
        destination.setText(to);
        String Departure_date = bookingPreferences.getString("departure_date","");
        ticket_date.setText(Departure_date);

        String bus_catagory = bookingPreferences.getString("Bus_type","");
        bus_type.setText(bus_catagory);




    }
}
