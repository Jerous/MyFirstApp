package com.tellustek.jerous.myfirstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LearnBroadcastReveiver extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_broadcast_reveiver);

        findViewById(R.id.btnSendMsgToBroadcastReceiver).setOnClickListener(this);
        findViewById(R.id.btnRegisterBroadcastReceiver).setOnClickListener(this);
        findViewById(R.id.btnUnregisterBroadcastReceiver).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSendMsgToBroadcastReceiver:
                //sendBroadcast(new Intent(this, MyReceiver.class));
                //Intent i = new Intent(this, MyReceiver.class);

                //receiver建立action後需用隱式intent方式去建立intent
                Intent i = new Intent(MyReceiver.ACTION);
                i.putExtra("data", "這是送給Broadcast Receiver的訊息");
                sendBroadcast(i);
                break;
            case R.id.btnRegisterBroadcastReceiver:
                if (receiver == null){
                    receiver = new MyReceiver();

                    //IntentFilter有個約定成俗的格式，要先在receiver建立action
                    registerReceiver(receiver, new IntentFilter(MyReceiver.ACTION));
                }
                break;
            case R.id.btnUnregisterBroadcastReceiver:
                if (receiver != null){
                    unregisterReceiver(receiver);
                    receiver = null;
                }
                break;
        }
    }

    private MyReceiver receiver = null;
}
