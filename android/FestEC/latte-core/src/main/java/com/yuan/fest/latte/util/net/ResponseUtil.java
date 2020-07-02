package com.yuan.fest.latte.util.net;

import com.alibaba.fastjson.JSONObject;
import com.yuan.fest.latte.net.callback.ActionCode;
import com.yuan.fest.latte.net.callback.ActionResult;

public class ResponseUtil {

    public static boolean checkCode(JSONObject response) {
        String code = response.getString(ActionResult.CODE.getMark());
        if (ActionCode.success.equals(code)) {
            return true;
        } else {
            return false;
        }
    }

}
