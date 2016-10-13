package com.tellustek.jerous.myfirstapp;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by Jerous on 2016/10/13.
 */
public class Permission {

    public static final String PERMISSION_SAY_HELLO = "com.tellustek.jerous.myfirstapp.permission.SAY_HELLO";

    //Context能讀取全局變數
    public static void sayHello(Context context){

        //透過context, 執行sayhello的程式是否有PERMISSION_SAY_HELLO權限
        int checkResult = context.checkCallingOrSelfPermission(PERMISSION_SAY_HELLO);

        //PERMISSION_GRANTED授與  PERMISSION_DENIED否認
        if (checkResult != PackageManager.PERMISSION_GRANTED){
            throw new SecurityException("執行sayHello方法需要有com.tellustek.jerous.myfirstapp.permission.SAY_HELLO權限");
        }

        System.out.println("sayHello, Jerous!");
    }

}
