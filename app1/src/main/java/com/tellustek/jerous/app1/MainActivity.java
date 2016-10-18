package com.tellustek.jerous.app1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, app1Service.class);

        findViewById(R.id.btnStartFirstAppNewAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //startActivity(new Intent("com.tellustek.jerous.myfirstapp.intent.action.EmptyTestAty"));

                    //透過schme設定app協定，直接開啟EmptyAty2
                    startActivity(new Intent("com.tellustek.jerous.myfirstapp.intent.action.EmptyTestAty", Uri.parse("app://hello")));
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "無法啟動指定的activity", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btnStartApp1Service).setOnClickListener(this);
        findViewById(R.id.btnStopApp1Service).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartApp1Service:
                startService(intent);
                break;
            case R.id.btnStopApp1Service:
                stopService(intent);
                break;
        }
    }
}
