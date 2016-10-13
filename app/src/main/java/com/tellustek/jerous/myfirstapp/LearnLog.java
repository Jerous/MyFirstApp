package com.tellustek.jerous.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LearnLog extends AppCompatActivity {

    private static String TAG = "LearnLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_log);

        System.out.println("sout message");
        System.err.println("serr message");

        Log.e(TAG, "log.error msg");
        Log.w(TAG, "log.warning msg");
        Log.i(TAG, "log.info msg");
        Log.d(TAG, "log.debug msg");
        Log.v(TAG, "log.verbose msg");
    }
}
