package com.tellustek.jerous.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ApplicationAty1 extends AppCompatActivity {

    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_aty1);

        textView = (TextView) findViewById(R.id.AppAtyTextView);
        editText = (EditText) findViewById(R.id.AppAtyeditText);

        textView.setText("共享的數據是："+ getApp().getTextData());

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((App)getApplicationContext()).setTextData(editText.getText().toString());

                textView.setText("共享的數據是："+editText.getText().toString());
            }
        });
    }

    public App getApp() {
        return (App) getApplicationContext();
    }
}
