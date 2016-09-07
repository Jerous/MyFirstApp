package com.tellustek.jerous.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewAty extends AppCompatActivity {

    private TextView getText;

    //隱式intent，定義變數免得打很長
    public static final String ACTION = "com.tellustek.jerous.myfirstapp.intent.action.NewAty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_aty);

        getText = (TextView) findViewById(R.id.getText);

        //Send text direct
        //Intent i = getIntent();
        //getText.setText(i.getStringExtra("data"));

        //Send user data from other activity use putExtras
        //Intent i = getIntent();
        //Bundle data = i.getExtras();
        //getText.setText(String.format("name=%s, age=%d, email=%s", data.getString("name"), data.getInt("age"), data.getString("email", "have no email")));

        //send user data from other activity use putExtra
        //Intent i = getIntent();
        //Bundle data = i.getBundleExtra("data");
        //getText.setText(String.format("name=%s, age=%d, email=%s", data.getString("name"), data.getInt("age"), data.getString("email", "have no email")));

        //send user data by Serializable from other activity
        //Intent i = getIntent();
        //User user = (User) i.getSerializableExtra("user");
        //getText.setText(String.format("User info: name=%s, age=%d, email=%s", user.getName(), user.getAge(), user.getEmail()));

        //send user data by Parcelable from other activity
        Intent i = getIntent();
        User user = i.getParcelableExtra("user");
        getText.setText(String.format("User info: name=%s, age=%d, email=%s", user.getName(), user.getAge(), user.getEmail()));

        System.out.println("B onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("B onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("B onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("B onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("B onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        System.out.println("B onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("B onDestroy");
    }
}
