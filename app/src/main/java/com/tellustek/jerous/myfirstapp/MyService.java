package com.tellustek.jerous.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private boolean serviceRunning = false;
    private String data = "This is bind message...";
    private int i;

    public MyService() {
    }

    //use textedit to change bind service message.
    public class Binder extends android.os.Binder {

        //讓service外可以訪問到service內的data變數
        public void setData(String data) {
            MyService.this.data = data;
        }

        //讓service外可以訪問到service內的東西
        public MyService getService() {
            return MyService.this;
        }
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

                i = 0;

                while (serviceRunning) {

                    i++;

                    String str = i+" : "+data;
                    System.out.println(str);


                    //傳出去service外面
                    if (callback != null) {
                        callback.onDataChange(str);
                    }

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



    //定義一個跟service外連接的介面function
    public static interface Callback{
        void onDataChange(String data);
    }

    //實例化callback
    private Callback callback = null;

    //定義callback介面的set與getCallback方法
    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public Callback getCallback() {
        return callback;
    }
}
