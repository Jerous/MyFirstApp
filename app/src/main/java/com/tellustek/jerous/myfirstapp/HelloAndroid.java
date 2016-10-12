package com.tellustek.jerous.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HelloAndroid extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_hello_android);
        setContentView(R.layout.my_layout_test);


        findViewById(R.id.btnStartNewAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelloAndroid.this, HelloAndroid.class));
            }
        });

        findViewById(R.id.btnStartUrlParse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tellustek.com")));
            }
        });

        findViewById(R.id.btnStartBaseThemeDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelloAndroid.this, ActBaseThemeDialog.class));
            }
        });

        findViewById(R.id.btnSendSomthingToOtherAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //顯示intent寫法
                //Intent i = new Intent(HelloAndroid.this, NewAty.class);

                //用隱式intent改寫
                Intent i = new Intent(NewAty.ACTION);

                //Send text direct
                //i.putExtra("data", "this is send text from home aty.");

                //Send user data from other activity use putExtras
                //Bundle b = new Bundle();
                //b.putString("name", "Jerous");
                //b.putInt("age", 32);
                //b.putString("email", "tlu37317@gmail.com");
                //i.putExtras(b);

                //send user data from other activity use putExtra
                //Bundle b = new Bundle();
                //b.putString("name", "Jerous");
                //b.putInt("age", 32);
                //b.putString("email", "tlu37317@gmail.com");
                //i.putExtra("data", b);

                //send user data by implements Serializable or parcelable from other activity
                i.putExtra("user", new User("Jerous", 32, "tlu3@pchome.com.tw"));

                startActivity(i);
            }
        });

        findViewById(R.id.btnStartEmptyTestAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmptyTestAty.ACTION));
            }
        });

        findViewById(R.id.btnStartContextMethod).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelloAndroid.this, ContextMethod.class));
            }
        });

        findViewById(R.id.btnStartAppAty1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelloAndroid.this, ApplicationAty1.class));
            }
        });

        findViewById(R.id.btnStartAppAty2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelloAndroid.this, ApplicationAty2.class));
            }
        });

        findViewById(R.id.btnLearnService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelloAndroid.this, LearnSerivce.class));
            }
        });

        findViewById(R.id.btnLearnStartApp1Service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelloAndroid.this, LearnStartOtherAppService.class));
            }
        });

        findViewById(R.id.btnLearnBroadcastReceiver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelloAndroid.this, LearnBroadcastReveiver.class));
            }
        });

        System.out.println("A onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("A onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("A onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("A onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("A onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        System.out.println("A onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("A onDestroy");
    }


    @Override
    public void onClick(View v) {

    }
}
