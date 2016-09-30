package com.tellustek.jerous.app1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class app1Service extends Service {
    public app1Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
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
