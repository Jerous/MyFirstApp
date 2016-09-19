package com.tellustek.jerous.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private boolean serviceRunning = false;
    private String data = "This is default message...";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");

        return new Binder();
    }

    //when start service will run onStartCommand
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        System.out.println("on Start Command.");
        data = intent.getStringExtra("data");

        return super.onStartCommand(intent, flags, startId);
    }

    //when first time start service will run
    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("Service Create.");

        serviceRunning = true;

        new Thread() {
            @Override
            public void run() {
                super.run();

                while (serviceRunning) {
                    System.out.println(data);

                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        System.out.println("Service Destroy.");

        serviceRunning = false;
    }
}
