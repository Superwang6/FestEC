package com.yuan.fest.latte.ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.yuan.fest.latte.app.AccountManager;
import com.yuan.fest.latte.app.IUserChecker;
import com.yuan.fest.latte.delegates.LatteDelegate;
import com.yuan.fest.latte.ec.R;
import com.yuan.fest.latte.ec.R2;
import com.yuan.fest.latte.ui.launcher.ILauncherListener;
import com.yuan.fest.latte.ui.launcher.OnLauncherFinishTag;
import com.yuan.fest.latte.ui.launcher.ScrollLauncherTag;
import com.yuan.fest.latte.util.storage.LattePreference;
import com.yuan.fest.latte.util.timer.BaseTimerTask;
import com.yuan.fest.latte.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    @BindView(R2.id.tv_launcher_timer)
    TextView mTvTimer = null;

    private Timer mTimer = null;
    private Integer mCount = 5;
    private ILauncherListener mILauncherListener;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {
        mTimer.cancel();
        mTimer = null;
        checkIsShowScroll();
    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask timerTask = new BaseTimerTask(this);
        mTimer.schedule(timerTask, 0, 1000);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener) {
            mILauncherListener = (ILauncherListener) activity;
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    //是否显示滑动启动
    private void checkIsShowScroll() {
        if (!LattePreference.getAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name())) {
            startWithPop(new LauncherScrollDelegate());
        } else {
            //检查登录
            AccountManager.checkAccount(new IUserChecker() {
                @Override
                public void onSignIn() {
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                    }
                }

                @Override
                public void onNotSignIn() {
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);
                    }
                }
            });
        }
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        mTimer.cancel();
                        mTimer = null;
                        checkIsShowScroll();
                    }
                }
            }
        });
    }
}
