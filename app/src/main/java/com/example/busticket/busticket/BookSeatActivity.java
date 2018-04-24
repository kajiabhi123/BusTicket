package com.example.busticket.busticket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.busticket.busticket.adapter.AdapterSeat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookSeatActivity extends AppCompatActivity {


    RecyclerView rvSeats;
    AdapterSeat mAdapter;
    Button buy;
    AQuery aquery;
    SharedPreferences preferences1,preferences2;


    String posturl= Constants.BASE_URL +"Booking.php";
    //String BookingInfoUrl ="http://192.168.1.106/BusTicket/BookingInfo.php";
    String BookingInfoUrl= Constants.BASE_URL +"BookingInfo.php";

    //String posturl ="http://192.168.6.1/BusTicket/Booking.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_seat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        aquery = new AQuery(this);
        preferences2 = getSharedPreferences("booking_info",0);
        GetReservedSeat();

        rvSeats = (RecyclerView) findViewById(R.id.rv_seats);
        rvSeats.setLayoutManager(new GridLayoutManager(this, 4));
        buy = (Button) findViewById(R.id.submit);
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBooking();

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home ){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void getBooking ()
    {

        preferences1 = getSharedPreferences("login_info",0);
        List<Seat> l = mAdapter.getList();
        JSONArray arr = new JSONArray();
        for (Seat s : l){
           // JSONObject ob = new JSONObject();
                if(s.isBooked())
                {
                    Map<String,Object> param = new HashMap<String,Object>();
                    param.put("seat_id",s.getNumber());
                    param.put("uid",preferences1.getString("uid",""));
                    param.put("ticket_date",preferences2.getString("departure_date",""));
                    param.put("ticket_time",preferences2.getString("departure_time",""));
                    //ob.put("seat_no",s.getNumber());
                    String time = preferences2.getString("departure_time","");
                    Toast.makeText(BookSeatActivity.this,time , Toast.LENGTH_SHORT).show();
                    Toast.makeText(BookSeatActivity.this,s.getNumber() , Toast.LENGTH_SHORT).show();

                    aquery.ajax(posturl,param,JSONArray.class, new AjaxCallback<JSONArray>()
                    {
                        @Override
                        public void callback(String url, JSONArray array, AjaxStatus status) {
                            super.callback(url, array, status);
                            //  Log.i("response", url +"response:"+object);
                            Toast.makeText(BookSeatActivity.this,"Seat Reserved" , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(BookSeatActivity.this,TicketLayout.class));

                        }
                    });
                }
               // arr.put(ob);

        }

        Toast.makeText(BookSeatActivity.this, "Data= "+ arr, Toast.LENGTH_SHORT).show();

    }

    public void GetReservedSeat()
    {
        String date = preferences2.getString("departure_date","");
        String time ="12pm";//preferences2.getString("departure_time","");

        //final SharedPreferences.Editor editor = preferences.edit();
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("date", date);
        param.put("time", time);
        aquery.ajax(BookingInfoUrl, param, JSONObject.class, new AjaxCallback<JSONObject>() {
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                try {
                    Log.i("response",url +"response:"+object);
                    String decision = object.getString("status");
                    JSONArray seatinfo = object.getJSONArray("seatinfo");
                    String message = object.optString("message");
                    mAdapter = new AdapterSeat(BookSeatActivity.this, seatinfo);
                    rvSeats.setAdapter(mAdapter);
                    Toast.makeText(BookSeatActivity.this, decision, Toast.LENGTH_SHORT).show();
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}



