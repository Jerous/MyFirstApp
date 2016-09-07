package com.tellustek.jerous.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContextMethod extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_context_method);

        //Context method by text
        tv = new TextView(ContextMethod.this);
        //tv.setText("Hello Context");
        tv.setText(R.string.hello_world);
        //setContentView(tv);
        System.out.println(getResources().getText(R.string.hello_world));

        iv = new ImageView(ContextMethod.this);
        iv.setImageResource(R.mipmap.ic_launcher);
        setContentView(iv);


    }
}
