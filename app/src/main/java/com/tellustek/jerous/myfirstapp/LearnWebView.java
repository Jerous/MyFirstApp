package com.tellustek.jerous.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class LearnWebView extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_web_view);

        wv = (WebView) findViewById(R.id.wv);
        wv.loadUrl("http://www.tellustek.com");

    }
}
