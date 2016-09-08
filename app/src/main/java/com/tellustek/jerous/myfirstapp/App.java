package com.tellustek.jerous.myfirstapp;

import android.app.Application;
import android.content.res.Configuration;

import java.util.Set;

/**
 * Created by Jerous on 2016/9/7.
 */
public class App extends Application {

    private String textData="default";

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public String getTextData() {
        return textData;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("App onCreate");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
