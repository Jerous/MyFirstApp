package com.tellustek.jerous.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EmptyTestAty extends AppCompatActivity {

    public static final String ACTION = "com.tellustek.jerous.myfirstapp.intent.action.EmptyTestAty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_test_aty);
    }
}
