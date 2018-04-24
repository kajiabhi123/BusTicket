package com.example.busticket.busticket;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class menu extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Button signup =(Button)findViewById(R.id.signup);
        Button login =(Button)findViewById(R.id.login);

        signup.setOnClickListener(this);
        login.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.signup:
                Intent signup= new Intent(menu.this,signup.class);
                startActivity(signup);
                break;
            case R.id.login:
                Intent login = new Intent(menu.this,Login.class);
                startActivity(login);
                break;
        }
    }
}
