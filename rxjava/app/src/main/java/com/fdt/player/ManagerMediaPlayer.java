package com.fdt.player;

import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by fudetian on 2018/7/18.
 */

public class ManagerMediaPlayer extends MediaPlayer implements MediaPlayer.OnCompletionListener {
    private Status mStatus;

    private OnCompletionListener mOnCompletionListener;

    public enum Status {
        IDLE, INITIALIZED, STARTED, PAUSED, STOPPEDE, COMPLETED
    }

    public ManagerMediaPlayer() {
        super();
        super.setOnCompletionListener(this);
        mStatus = Status.IDLE;
    }

    @Override
    public void reset() {
        super.reset();
        mStatus = Status.IDLE;
    }

    @Override
    public void setDataSource(String path) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        super.setDataSource(path);
        mStatus = Status.INITIALIZED;
    }

    @Override
    public void start() throws IllegalStateException {
        super.start();
        mStatus = Status.STARTED;
    }

    @Override
    public void pause() throws IllegalStateException {
        super.pause();
        mStatus = Status.PAUSED;
    }

    @Override
    public void stop() throws IllegalStateException {
        super.stop();
        mStatus = Status.STOPPEDE;
    }

    @Override
    public void setOnCompletionListener(OnCompletionListener listener) {
        this.mOnCompletionListener = listener;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mStatus = Status.COMPLETED;
        if (mOnCompletionListener != null) {
            mOnCompletionListener.onCompletion(mp);
        }
    }

    public Status getmStatus() {
        return mStatus;
    }

    public void setmStatus(Status mStatus) {
        this.mStatus = mStatus;
    }

    public boolean isComplete() {
        return mStatus == Status.COMPLETED;
    }
}
