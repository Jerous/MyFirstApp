package com.tellustek.jerous.myfirstapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LearnSerivce extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_serivce);

        intent = new Intent(LearnSerivce.this, MyService.class);

        //use this to refactor new View.OnClickListener()
        /*findViewById(R.id.btnStartService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startService(new Intent(LearnSerivce.this, MyService.class));

                startService(intent);
            }
        });

        findViewById(R.id.btnStopService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stopService(new Intent(LearnSerivce.this, MyService.class));

                stopService(intent);
            }
        });*/
        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);


        findViewById(R.id.btnStartBindService).setOnClickListener(this);
        findViewById(R.id.btnStopBindService).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartService:
                startService(intent);
                break;
            case R.id.btnStopService:
                stopService(intent);
                break;
            case R.id.btnStartBindService:
                bindService(intent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnStopBindService:
                unbindService(this);
                break;
        }
    }

    //when service bind then do
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("Service Connected.");
    }

    //when serivce was break or killed then do
    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
