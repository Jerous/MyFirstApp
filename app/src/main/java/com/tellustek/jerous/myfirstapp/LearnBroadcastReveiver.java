package com.tellustek.jerous.myfirstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LearnBroadcastReveiver extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_broadcast_reveiver);

        findViewById(R.id.btnSendMsgToBroadcastReceiver).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSendMsgToBroadcastReceiver:
                //sendBroadcast(new Intent(this, MyReceiver.class));
                Intent i = new Intent(this, MyReceiver.class);
                i.putExtra("data", "這是送給Broadcast Receiver的訊息");
                sendBroadcast(i);
                break;
        }
    }
}
