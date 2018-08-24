package com.fdt.rxjava;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by fudetian on 2018/8/9.
 */

public class InstSucRecei extends BroadcastReceiver {
    private String apkfileName = "app-debug.apk";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (Intent.ACTION_PACKAGE_ADDED.equals(intent.getAction())) {
            Log.e("广播", "监听到系统广播,包被添加: ");
            //删除apk文件
            deleteApkfile(apkfileName);
        }

        if (Intent.ACTION_PACKAGE_REMOVED.equals(intent.getAction())) {
            Log.e("广播", "监听到系统广播,包被移除: ");
            Log.e("广播", "onReceive: " + intent.getDataString());
        }

        if (Intent.ACTION_PACKAGE_REPLACED.equals(intent.getAction())) {
            Log.e("广播", "监听到系统广播,包被替换: ");
            Log.e("广播", "onReceive: "+ intent.getPackage());
            deleteApkfile(apkfileName);
        }
    }

    public Boolean deleteApkfile(String apkFileName){
        //Apk文件路径可自定义，此处用 download 文件夹
        File apkfile = new File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                .getPath(), apkFileName);
        if (!apkfile.exists()) {
            Log.e("广播", "apkfile delete already! ");
        } else {
            //调用现成的文件操作方法删除文件
            if (apkfile.delete())
                Log.e("广播", "apkfile delete successfully! ");
        }
        return false;
    }
}
