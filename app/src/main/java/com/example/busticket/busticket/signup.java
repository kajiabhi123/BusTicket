package com.example.busticket.busticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {

    AQuery aQuery;

    EditText username,email,password,address,mobile_number;
    RadioGroup gender;
    //String posturl ="http://192.168.1.106/BusTicket/insert.php";
   // String posturl ="http://192.168.6.1/BusTicket/insert.php";
    String posturl= Constants.BASE_URL+"insert.php";

    String posturl1 ="http://10.0.2.2/BusTicket/insert.php";
    String fetchurl ="http://10.0.2.2/BusTicket/select.php";
    String fetchurl1 ="http://192.168.1.106/BusTicket/select.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        aQuery = new AQuery(this);

        username = (EditText) findViewById(R.id.fname);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        address = (EditText) findViewById(R.id.address);
        mobile_number = (EditText) findViewById(R.id.phone);
        gender = (RadioGroup) findViewById(R.id.gender);

        Button btn = (Button) findViewById(R.id.signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostData();
                Intent intent = new Intent(signup.this,Login.class);
                startActivity(intent);
            }
        });
    }

    public void PostData()
    {
        String Username = username.getText().toString();
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        String Address = address.getText().toString();
        String Mobile_Number = mobile_number.getText().toString();
        RadioButton checkedrb = (RadioButton) findViewById(gender.getCheckedRadioButtonId());
        String Gender = checkedrb.getText().toString();

        Map<String,Object> param = new HashMap<String,Object>();
        param.put("name",Username);
        param.put("email",Email);
        param.put("password",Password);
        param.put("address",Address);
        param.put("phone",Mobile_Number);
        param.put("gender",Gender);
        aQuery.ajax(posturl,param,JSONArray.class, new AjaxCallback<JSONArray>()
        {
            @Override
            public void callback(String url, JSONArray array, AjaxStatus status) {
                super.callback(url, array, status);
               Log.i("response", url +"response:"+array);
            }
        });



    }
}
