package com.yuan.fest.latte.util.net;

import java.util.List;

public class ParamUtil {
    public static <T> String getList(List<T> list) {
        if (list != null && list.size() > 0) {
            String s = list.toString();
            String s1 = s.substring(1, list.size() + 2 - 1);
            return s1;
        } else {
            return null;
        }
    }
}
