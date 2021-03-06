package com.yuan.fest.latte.delegates.bottom;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.yuan.fest.latte.R;
import com.yuan.fest.latte.delegates.LatteDelegate;

public abstract class BottomItemDelegate extends LatteDelegate implements View.OnKeyListener {

    private long mExitTime = 0;
    private static final int EXIT_TIME = 2000;

    @Override
    public void onResume() {
        super.onResume();
        View rootView = getView();
        if(rootView != null){
            rootView.setFocusableInTouchMode(true);
            rootView.requestFocus();
            rootView.setOnKeyListener(this);
        }
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
            if((System.currentTimeMillis() - mExitTime) > EXIT_TIME){
                Toast.makeText(getContext(),"双击退出" + getString(R.string.app_name),Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                _mActivity.finish();
                if(mExitTime != 0) {
                    mExitTime = 0;
                }
            }
            return true;
        }
        return false;
    }
}
