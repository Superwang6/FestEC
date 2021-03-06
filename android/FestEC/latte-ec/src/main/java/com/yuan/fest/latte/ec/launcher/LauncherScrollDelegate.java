package com.yuan.fest.latte.ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.Nullable;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.yuan.fest.latte.app.AccountManager;
import com.yuan.fest.latte.app.IUserChecker;
import com.yuan.fest.latte.delegates.LatteDelegate;
import com.yuan.fest.latte.ec.R;
import com.yuan.fest.latte.ui.launcher.ILauncherListener;
import com.yuan.fest.latte.ui.launcher.LauncherHolderCreator;
import com.yuan.fest.latte.ui.launcher.OnLauncherFinishTag;
import com.yuan.fest.latte.ui.launcher.ScrollLauncherTag;
import com.yuan.fest.latte.util.storage.LattePreference;

import java.util.ArrayList;
import java.util.List;

public class LauncherScrollDelegate extends LatteDelegate implements OnItemClickListener {

    private ConvenientBanner<Integer> mConvenientBanner = null;
    private static final List<Integer> INTEGERS = new ArrayList<>();
    private ILauncherListener mILauncherListener;

    private void initBanner() {
        INTEGERS.add(R.mipmap.scroll_01);
        INTEGERS.add(R.mipmap.scroll_02);
        INTEGERS.add(R.mipmap.scroll_03);

        mConvenientBanner
                .setPages(new LauncherHolderCreator(), INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_forcus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(false);
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
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanner();
    }

    @Override
    public void onItemClick(int position) {
        if (position == INTEGERS.size() - 1) {
            LattePreference.setAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(),true);
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
}
