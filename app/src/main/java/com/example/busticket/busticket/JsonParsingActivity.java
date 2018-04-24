package com.example.busticket.busticket;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by compware on 1/22/2018.
 */

public class JsonParsingActivity {

    EditText name,email,password,address,phone,gender;

    AQuery aQuery;

    String posturl ="http://10.0.2.2/BusTicket/insert.php";
    String fetchurl ="http://10.0.2.2/BusTicket/select.php";
    String fetchurl1 ="http://192.168.1.106/BusTicket/select.php";

    public void PostData()
    {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("name","name ko value");
        param.put("address","address ko value");
        param.put("phone","phone ko value");

        aQuery.ajax(posturl,param,JSONArray.class, new AjaxCallback<JSONArray>()
        {
            @Override
            public void callback(String url, JSONArray object, AjaxStatus status) {
                super.callback(url, object, status);
                Log.i("response", url +"response:"+object);
            }
        });

    }
}
