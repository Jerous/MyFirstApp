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
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        System.out.println("app1 Service onDestroy.");
    }
}
