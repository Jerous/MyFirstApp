package com.tellustek.jerous.myfirstapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.tellustek.jerous.app1.IAppRemoteBinder;

public class LearnStartOtherAppService extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent app1ServiceIntent;
    private EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_start_other_app_service);

        etInput = (EditText) findViewById(R.id.etInput);

        app1ServiceIntent = new Intent();
        //透過component可以顯示指名要啟動的intent，指定了package name and class name
        app1ServiceIntent.setComponent(new ComponentName("com.tellustek.jerous.app1", "com.tellustek.jerous.app1.app1Service"));

        findViewById(R.id.btnStartApp1Service).setOnClickListener(this);
        findViewById(R.id.btnStopApp1Service).setOnClickListener(this);

        findViewById(R.id.btnBindApp1Service).setOnClickListener(this);
        findViewById(R.id.btnUnbindApp1Service).setOnClickListener(this);

        findViewById(R.id.btnSyncApp1Serivce).setOnClickListener(this);

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
                binder = null;
                break;
            case R.id.btnSyncApp1Serivce:
                if (binder != null){
                    try {
                        binder.setData(etInput.getText().toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("Bind Service.");
        System.out.println(service);

        //因為記憶體位置不同，不可以直接這樣強制類型轉換，要用下面寫法
        //binder = (IAppRemoteBinder) service;
        binder = IAppRemoteBinder.Stub.asInterface(service);

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    private IAppRemoteBinder binder = null;
}
