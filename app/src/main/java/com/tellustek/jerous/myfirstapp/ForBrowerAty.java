package com.tellustek.jerous.myfirstapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.URL;

public class ForBrowerAty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_brower_aty);

        //透過瀏覽器啟動時取得瀏覽器過來的資訊
        Uri uri = getIntent().getData();
        System.out.println(uri);
    }
}
