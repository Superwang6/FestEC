package com.yuan.fest.latte.util.toast;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    private static Toast mToast = null;

    public static void showMsg(Context context,String msg) {
        if(mToast == null) {
            mToast = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        } else {
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setText(msg);
        }
        mToast.show();
    }

    public static void showLongMsg(Context context,String msg) {
        if(mToast == null) {
            mToast = Toast.makeText(context,msg,Toast.LENGTH_LONG);
        } else {
            mToast.setDuration(Toast.LENGTH_LONG);
            mToast.setText(msg);
        }
        mToast.show();
    }

}
