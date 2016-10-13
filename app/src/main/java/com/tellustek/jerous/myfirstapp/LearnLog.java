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

        //JAVA內建的訊息
        System.out.println("sout message");
        System.err.println("serr message");

        //ANDROID內建的訊息
        Log.e(TAG, "log.error msg"); //錯誤用
        Log.w(TAG, "log.warning msg"); //警告用
        Log.i(TAG, "log.info msg"); //普通用
        Log.d(TAG, "log.debug msg"); //DEBUG用
        Log.v(TAG, "log.verbose msg"); //廢話用

        Log.e("MSG", "log.error no tag msg");

        Permission.sayHello(this);
    }
}
