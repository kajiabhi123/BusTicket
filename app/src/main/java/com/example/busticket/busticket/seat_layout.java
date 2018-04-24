package com.example.busticket.busticket;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

import static com.example.busticket.busticket.R.id.A_1;

/**
 * Created by compware on 12/4/2017.
 */
public class seat_layout extends AppCompatActivity {

    Button a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17
            ,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16, buy,reserve;
           AQuery aquery;
    SharedPreferences preferences;

    //String posturl ="http://10.0.2.2/BusTicket/Booking.php";
    String posturl ="http://192.168.1.106/BusTicket/Booking.php";
    boolean btnFlagA_1= true,btnFlagA_2= true,btnFlagA_3= true,btnFlagA_4= true,btnFlagA_5= true,
            btnFlagA_6= true,btnFlagA_7= true,btnFlagA_8= true,btnFlagA_9= true,btnFlagA_10= true,
            btnFlagA_11= true,btnFlagA_12= true,btnFlagA_13= true,btnFlagA_14= true,btnFlagA_15= true,
            btnFlagA_16= true,btnFlagA_17= true;
    boolean btnFlagB_1= true,btnFlagB_2= true,btnFlagB_3= true,btnFlagB_4= true,btnFlagB_5= true,
            btnFlagB_6= true,btnFlagB_7= true,btnFlagB_8= true,btnFlagB_9= true,btnFlagB_10= true,
            btnFlagB_11= true,btnFlagB_12= true,btnFlagB_13=true,btnFlagB_14= true,btnFlagB_15= true,
            btnFlagB_16= true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seat_layout1);

        aquery = new AQuery(this);
        preferences = getSharedPreferences("login_info",0);
        String uid = preferences.getString("uid","");
        //Toast.makeText(this,uid, Toast.LENGTH_SHORT).show();

        buy = (Button) findViewById(R.id.buy);
        reserve = (Button) findViewById(R.id.reserve);
        a1= (Button) findViewById(A_1);
        a2= (Button) findViewById(R.id.A_2);
        a3= (Button) findViewById(R.id.A_3);
        a4= (Button) findViewById(R.id.A_4);
        a5= (Button) findViewById(R.id.A_5);
        a6= (Button) findViewById(R.id.A_6);
        a7= (Button) findViewById(R.id.A_7);
        a8= (Button) findViewById(R.id.A_8);
        a9= (Button) findViewById(R.id.A_9);
        a10= (Button) findViewById(R.id.A_10);
        a11= (Button) findViewById(R.id.A_11);
        a12= (Button) findViewById(R.id.A_12);
        a13= (Button) findViewById(R.id.A_13);
        a14= (Button) findViewById(R.id.A_14);
        a15= (Button) findViewById(R.id.A_15);
        a16= (Button) findViewById(R.id.A_16);
        a17= (Button) findViewById(R.id.A_17);
        b1= (Button) findViewById(R.id.B_1);
        b2= (Button) findViewById(R.id.B_2);
        b3= (Button) findViewById(R.id.B_3);
        b4= (Button) findViewById(R.id.B_4);
        b5= (Button) findViewById(R.id.B_5);
        b6= (Button) findViewById(R.id.B_6);
        b7= (Button) findViewById(R.id.B_7);
        b8= (Button) findViewById(R.id.B_8);
        b9= (Button) findViewById(R.id.B_9);
        b10= (Button) findViewById(R.id.B_10);
        b11= (Button) findViewById(R.id.B_11);
        b12= (Button) findViewById(R.id.B_12);
        b13= (Button) findViewById(R.id.B_13);
        b14= (Button) findViewById(R.id.B_14);
        b15= (Button) findViewById(R.id.B_15);
        b16 = (Button) findViewById(R.id.B_16);
         String bthtext = a1.getText().toString();
        String value = (String) b16.getText();
        Toast.makeText(this,value, Toast.LENGTH_SHORT).show();


        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(seat_layout.this,TicketLayout.class));
            }
        });

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_1) {
                    a1.setBackgroundColor(Color.rgb(248, 160, 118));
                    //buttonPress(a1);
                    String seat = a1.getText().toString();
                   // Toast.makeText(seat_layout.this, bthid, Toast.LENGTH_SHORT).show();
                    showAlertDialog();
                }

                else
                    a1.setBackgroundColor(Color.rgb(214,215,216));
                btnFlagA_1=!btnFlagA_1;


            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnFlagA_2) {
                    a2.setBackgroundColor(Color.rgb(248, 160, 118));
                    //buttonPress(a2);

                }


                else
                    a2.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagA_2=!btnFlagA_2;

            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_3) {
                    a3.setBackgroundColor(Color.rgb(248, 160, 118));
                    //buttonPress(a3);

                }

                else
                    a3.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagA_3=!btnFlagA_3;

            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_4)
                    a4.setBackgroundColor(Color.rgb(248,160,118));
                else
                    a4.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagA_4=!btnFlagA_4;

            }
        });
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_5)
                    a5.setBackgroundColor(Color.rgb(248,160,118));

                else
                    a5.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagA_5=!btnFlagA_5;

            }
        });
        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_6)
                    a6.setBackgroundColor(Color.rgb(248,160,118));

                else
                    a6.setBackgroundColor(Color.rgb(214,215,216));
                btnFlagA_6=!btnFlagA_6;

            }
        });
        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_7)
                    a7.setBackgroundColor(Color.rgb(248,160,118));


                else
                    a7.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagA_7=!btnFlagA_7;

            }
        });
        a8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_8)
                    a8.setBackgroundColor(Color.rgb(248,160,118));


                else
                    a8.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagA_8=!btnFlagA_8;


            }
        });
        a9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_9)
                    a9.setBackgroundColor(Color.rgb(248,160,118));

                else
                    a9.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagA_9=!btnFlagA_9;

            }
        });
        a10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_10)
                    a10.setBackgroundColor(Color.rgb(248,160,118));
                else
                    a10.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagA_10=!btnFlagA_10;

            }
        });
        a11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_11)
                    a11.setBackgroundColor(Color.rgb(248,160,118));

                else
                    a11.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagA_11=!btnFlagA_11;


            }
        });
        a12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_12)
                    a12.setBackgroundColor(Color.rgb(248,160,118));
                else
                    a12.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagA_12=!btnFlagA_12;



            }
        });
        a13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_13)
                    a13.setBackgroundColor(Color.rgb(248,160,118));
                else
                    a13.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagA_13=!btnFlagA_13;

            }
        });
        a14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_14)
                    a14.setBackgroundColor(Color.rgb(248,160,118));
                else
                    a14.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagA_14=!btnFlagA_14;

            }
        });
        a15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_15)
                    a15.setBackgroundColor(Color.rgb(248,160,118));
                else
                    a15.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagA_15=!btnFlagA_15;

            }
        });
        a16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_16)
                    a16.setBackgroundColor(Color.rgb(248,160,118));


                else
                    a16.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagA_16=!btnFlagA_16;

            }
        });
        a17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagA_17)
                    a17.setBackgroundColor(Color.rgb(248,160,118));

                else
                    a17.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagA_17=!btnFlagA_17;

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_1)
                    b1.setBackgroundColor(Color.rgb(248,160,118));
                else
                    b1.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagB_1=!btnFlagB_1;

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_2)
                    b2.setBackgroundColor(Color.rgb(248,160,118));

                else
                    b2.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagB_2=!btnFlagB_2;

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_3)
                    b3.setBackgroundColor(Color.rgb(248,160,118));

                else
                    b3.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagB_3=!btnFlagB_3;

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_4)
                    b4.setBackgroundColor(Color.rgb(248,160,118));

                else
                    b4.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagB_4=!btnFlagB_4;

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_5)
                    b5.setBackgroundColor(Color.rgb(248,160,118));

                else
                    b5.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagB_5=!btnFlagB_5;

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_6)
                    b6.setBackgroundColor(Color.rgb(248,160,118));

                else
                    b6.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagB_6=!btnFlagB_6;

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_7)
                    b7.setBackgroundColor(Color.rgb(248,160,118));

                else
                    b7.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagB_7=!btnFlagB_7;

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_8)
                    b8.setBackgroundColor(Color.rgb(248,160,118));
                else
                    b8.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagB_8=!btnFlagB_8;

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_9)
                    b9.setBackgroundColor(Color.rgb(248,160,118));
                else
                    b9.setBackgroundColor(Color.rgb(214,215,216));


                btnFlagB_9=!btnFlagB_9;

            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_10)
                    b10.setBackgroundColor(Color.rgb(248,160,118));
                else
                    b10.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagB_10=!btnFlagB_10;

            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_11)
                    b11.setBackgroundColor(Color.rgb(248,160,118));

                else
                    b11.setBackgroundColor(Color.rgb(214,215,216));
                btnFlagB_11=!btnFlagB_11;

            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_12)
                    b12.setBackgroundColor(Color.rgb(248,160,118));
                else
                    b12.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagB_12=!btnFlagB_12;

            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_13)
                    b13.setBackgroundColor(Color.rgb(248,160,118));

                else
                    b13.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagB_13=!btnFlagB_13;

            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_14)
                    b14.setBackgroundColor(Color.rgb(248,160,118));
                else
                    b14.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagB_14=!btnFlagB_14;

            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_15)
                    b15.setBackgroundColor(Color.rgb(248,160,118));
                else
                    b15.setBackgroundColor(Color.rgb(214,215,216));

                btnFlagB_15=!btnFlagB_15;

            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btnFlagB_16)
                    b16.setBackgroundColor(Color.rgb(248,160,118));
                else
                    b16.setBackgroundColor(Color.rgb(214,215,216));
                btnFlagB_16=!btnFlagB_16;

            }
        });

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
//    public void buttonPress(View v)
//    {
//        switch (v.getId())
//        {
//            case R.id.A_1:
//                Map<String,Object> param = new HashMap<String,Object>();
//                param.put("seat_id",1);
//                aquery.ajax(posturl,param,JSONArray.class, new AjaxCallback<JSONArray>()
//                {
//                    @Override
//                    public void callback(String url, JSONArray array, AjaxStatus status) {
//                        super.callback(url, array, status);
//                        //  Log.i("response", url +"response:"+object);
//                    }
//                });
//                break;
//            case R.id.A_2:
//                Map<String,Object> param1 = new HashMap<String,Object>();
//                param1.put("seat_id",2);
//                aquery.ajax(posturl,param1,JSONArray.class, new AjaxCallback<JSONArray>()
//                {
//                    @Override
//                    public void callback(String url, JSONArray array, AjaxStatus status) {
//                        super.callback(url, array, status);
//                        //  Log.i("response", url +"response:"+object);
//                    }
//                });
//                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.A_3:
//                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }


    public void showAlertDialog()
    {
        AlertDialog.Builder dialog =  new AlertDialog.Builder(this);
        dialog.setTitle("Reserve Seat");
        dialog.setMessage("Are you want to Buy this seat ?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }


    public void postData(String s)
    {
        String seatId = s;
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("seat_id",s);
        aquery.ajax(posturl,param,JSONArray.class, new AjaxCallback<JSONArray>()
        {
            @Override
            public void callback(String url, JSONArray array, AjaxStatus status) {
                super.callback(url, array, status);
                //  Log.i("response", url +"response:"+object);
            }
        });
    }

}