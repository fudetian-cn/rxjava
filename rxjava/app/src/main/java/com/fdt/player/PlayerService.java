package com.fdt.player;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.fdt.rxjava.MainActivity;
import com.fdt.rxjava.MyApplication;

/**
 * Created by fudetian on 2018/7/18.
 */

public class PlayerService extends Service {

    public static void startPlay() {
        Intent intent = new Intent();
        intent.setAction(PlayerConstants.SERVICE_ACTION_START);
        MyApplication.getContext().startService(intent);
    }

    public static void playPrevious() {
        Intent intent = new Intent();
        intent.setAction(PlayerConstants.SERVICE_ACTION_PREVIOUS);
        MyApplication.getContext().startService(intent);
    }

    public static void playNext() {
        Intent intent = new Intent();
        intent.setAction(PlayerConstants.SERVICE_ACTION_NEXT);
        MyApplication.getContext().startService(intent);
    }

    public static void stopPlay() {
        Intent intent = new Intent();
        intent.setAction(PlayerConstants.SERVICE_ACTION_STOP);
        MyApplication.getContext().startService(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null) {
            switch (intent.getAction()) {
                case PlayerConstants.SERVICE_ACTION_START:

                    break;
                case PlayerConstants.SERVICE_ACTION_PREVIOUS:

                    break;
                case PlayerConstants.SERVICE_ACTION_NEXT:

                    break;
                case PlayerConstants.SERVICE_ACTION_STOP:

                    break;

            }
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {


        super.onDestroy();
    }
}
