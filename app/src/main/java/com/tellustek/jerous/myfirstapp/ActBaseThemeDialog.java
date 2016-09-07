package com.tellustek.jerous.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActBaseThemeDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_base_theme_dialog);
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("C onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("C onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("C onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("C onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        System.out.println("C onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("C onDestroy");
    }
}
