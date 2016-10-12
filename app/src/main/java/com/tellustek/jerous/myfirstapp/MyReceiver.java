package com.tellustek.jerous.myfirstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    //建立action的約定成俗的格式
    public static final String ACTION = "com.tellustek.jerous.myfirstapp.intent.action.MyReceiver";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

        System.out.println("接收到訊息了!" + intent.getStringExtra("data"));
    }
}
