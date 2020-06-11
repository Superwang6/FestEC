package com.yuan.fest.latte.util.timer;

import java.util.TimerTask;

public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener listener) {
        this.mITimerListener = listener;
    }

    @Override
    public void run() {
        if(mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }
}
