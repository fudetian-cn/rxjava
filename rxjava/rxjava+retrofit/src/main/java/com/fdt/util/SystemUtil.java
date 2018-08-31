package com.fdt.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.fdt.base.BaseApplication;


/**
 * Created by fudetian on 2018/8/27.
 */

public class SystemUtil {

    /**
     * 获取当前应用的报信息
     */
    public static PackageInfo getVersion() {
        Context context = BaseApplication.getContext();
        // 得到包管理器
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo infop = pm.getPackageInfo(context.getPackageName(), 0);
            return infop;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
