package com.tellustek.jerous.myfirstapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LearnSerivce extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent intent;
    private EditText ServiceEditText;
    private TextView ServiceOutText;

    private MyService.Binder binder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_serivce);

        intent = new Intent(LearnSerivce.this, MyService.class);
        ServiceEditText = (EditText) findViewById(R.id.ServiceEditText);
        ServiceOutText = (TextView) findViewById(R.id.ServiceOutText);

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

        findViewById(R.id.btnSyncBindMessage).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartService:
                intent.putExtra("data", ServiceEditText.getText().toString());
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
            case R.id.btnSyncBindMessage:
                if (binder != null) {
                    binder.setData(ServiceEditText.getText().toString());
                }
                break;
        }
    }

    //when service bind then do
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("Service Connected.");

        binder = (MyService.Binder) service;

        //以下就可以訪問到myservice內部的數據，再activity中讀取
        binder.getService().setCallback(new MyService.Callback() {
            @Override
            public void onDataChange(String data) {
                //不能這樣寫，android的安全機制不允許直接修改Serivce中的new Thread
                //ServiceOutText.setText(data);
                //要另外用handler去call

                Message msg = new Message();  //建message存要傳遞的訊息
                Bundle b = new Bundle();  //建bundle存data
                b.putString("data", data);  //將data存到bundle中
                msg.setData(b);  //Message的setdata方法
                handler.sendMessage(msg);  //將msg傳到handler中

            }
        });
    }

    //when serivce was break or killed then do
    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            ServiceOutText.setText(msg.getData().getString("data"));
        }
    };
}
