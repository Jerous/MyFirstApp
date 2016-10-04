package com.tellustek.jerous.app1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class app1Service extends Service {
    public app1Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new IAppRemoteBinder.Stub() {
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }

            @Override
            public void setData(String data) throws RemoteException {
                app1Service.this.data = data;
            }
        };
    }

    //可用於接受從其他app傳遞過來的參數
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("app1 Service onCreate.");

        new Thread(){
            @Override
            public void run() {
                super.run();

                app1ServiceRunning = true;
                while (app1ServiceRunning) {

                    System.out.println(data);

                    try {
                        Thread.sleep(1000);
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

        System.out.println("app1 Service onDestroy.");

        app1ServiceRunning = false;
    }

    private String data = "This is default app1service message....";
    private boolean app1ServiceRunning = false;
}
