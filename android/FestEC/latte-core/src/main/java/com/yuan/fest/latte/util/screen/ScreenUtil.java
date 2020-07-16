package com.yuan.fest.latte.util.screen;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;

public class ScreenUtil {

    public static Point getPoint(Activity activity) {
        Display defalutDisPlay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defalutDisPlay.getSize(point);
        return point;
    }
}
