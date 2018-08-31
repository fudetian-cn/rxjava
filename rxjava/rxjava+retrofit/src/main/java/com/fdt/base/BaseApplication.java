package com.fdt.base;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;

import com.fdt.net.NetWorkManager;


/**
 * Created by fudetian on 2018/8/27.
 */

public class BaseApplication extends Application {
    // 布局渲染器
    public static LayoutInflater mInflater;
    // 应用程序
    public static BaseApplication mInstance;
    //上下文
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mInstance = this;

        mContext = getApplicationContext();

        NetWorkManager.getInstance().init();


    }

    /**
     * @Description描述:获取上下文对象
     */
    public static Context getContext() {
        return mContext;
    }

    /**
     * @Description描述:获取应用程序对象
     */
    public static BaseApplication getInstance() {
        return mInstance;
    }

    /**
     * @Description描述:获得布局渲染器
     */
    public static LayoutInflater getInflater() {
        return mInflater;
    }
}
