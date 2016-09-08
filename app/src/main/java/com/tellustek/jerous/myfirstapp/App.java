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

    //App start then do this
    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("App onCreate");
    }

    //App stop then do terminate
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    //when memory isnt' enought then do it
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    //release memory when stop app
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    //when system config change then do it
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
