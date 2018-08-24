package com.fdt.rxjava;

import android.app.Application;
import android.content.Context;

/**
 * Created by fudetian on 2018/7/17.
 */

public class MyApplication extends Application {

    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationContext = getApplicationContext();
    }

    public static Context getContext() {
        return applicationContext;
    }
}
