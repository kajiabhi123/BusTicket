package com.example.busticket.busticket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText email,password;
    AQuery aQuery;
    SharedPreferences preferences;
    //String posturl ="http://10.0.2.2/BusTicket/Login_validation.php";
    //String posturl1 ="http://192.168.1.106/BusTicket/Login_validation.php";
    //String posturl1 ="http://192.168.6.1/BusTicket/Login_validation.php";
    String posturl1= Constants.BASE_URL+"Login_validation.php";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = getSharedPreferences("login_info",0);
        email= (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        Button btn = (Button) findViewById(R.id.login1);
        aQuery = new AQuery(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              verifyUser();
            }
        });
    }

    public void verifyUser() {
        String Email = email.getText().toString();
        String Password = password.getText().toString();

        final SharedPreferences.Editor editor = preferences.edit();
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("email", Email);
        param.put("password", Password);
        aQuery.ajax(posturl1, param, JSONObject.class, new AjaxCallback<JSONObject>() {
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                try {
                    Log.i("response",url +"response:"+object);
                    String decision = object.getString("status");
                    JSONObject user = object.getJSONObject("user");
                       String id = user.getString("uid");
                    String message = object.optString("message");
                    //Toast.makeText(Login.this, id + " " + userName, Toast.LENGTH_SHORT).show();
                    String username = user.getString("username");
                    editor.putString("uid",id);
                    editor.putString("username",username);
                    editor.apply();
                    Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
                  if(decision.equals("true"))
                    {
                        Intent intent = new Intent(Login.this, SelectDateActivity.class);
                        Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
                        startActivity(intent);

                    }
                    else if(decision.equals("false"))
                    {
                        Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
                    }


                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

