package com.fdt.player;

import android.media.AudioManager;
import android.os.PowerManager;

import com.fdt.rxjava.MyApplication;

/**
 * Created by fudetian on 2018/7/18.
 */

public class PlayerManager {

    private ManagerMediaPlayer mMediaPlayer;

    private static class Singleton {
        private static PlayerManager instance = new PlayerManager();
    }

    public static PlayerManager getInstance() {
        return Singleton.instance;
    }

    private void  init() {
        mMediaPlayer = new ManagerMediaPlayer();
        mMediaPlayer.setWakeMode(MyApplication.getContext(), PowerManager.PARTIAL_WAKE_LOCK);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);






    }

}
