package com.tellustek.jerous.myfirstapp;

import android.app.Application;

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
}
