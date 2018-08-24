package com.fdt;

import android.app.Application;

/**
 * Created by fudetian on 2018/8/16.
 */

public class MyApplication extends Application {
    public static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
