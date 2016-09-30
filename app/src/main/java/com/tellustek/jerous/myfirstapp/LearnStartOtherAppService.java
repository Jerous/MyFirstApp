package com.tellustek.jerous.myfirstapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LearnStartOtherAppService extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent app1ServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_start_other_app_service);

        app1ServiceIntent = new Intent();
        //透過component可以顯示指名要啟動的intent，指定了package name and class name
        app1ServiceIntent.setComponent(new ComponentName("com.tellustek.jerous.app1", "com.tellustek.jerous.app1.app1Service"));

        findViewById(R.id.btnStartApp1Service).setOnClickListener(this);
        findViewById(R.id.btnStopApp1Service).setOnClickListener(this);

        findViewById(R.id.btnBindApp1Service).setOnClickListener(this);
        findViewById(R.id.btnUnbindApp1Service).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartApp1Service:
                startService(app1ServiceIntent);
                break;
            case R.id.btnStopApp1Service:
                stopService(app1ServiceIntent);
                break;
            case R.id.btnBindApp1Service:
                bindService(app1ServiceIntent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbindApp1Service:
                unbindService(this);
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("Bind Service.");
        System.out.println(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
