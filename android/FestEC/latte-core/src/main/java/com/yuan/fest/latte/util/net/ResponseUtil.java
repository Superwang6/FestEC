package com.yuan.fest.latte.util.net;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;
import com.yuan.fest.latte.net.callback.ActionCode;
import com.yuan.fest.latte.net.callback.ActionResult;
import com.yuan.fest.latte.util.toast.ToastUtil;

public class ResponseUtil {

    /**
     * 校验某验证码
     * @param response
     * @param codeStr
     * @return
     */
    public static boolean checkCode(JSONObject response,String codeStr) {
        String code = response.getString(ActionResult.CODE.getMark());
        if (codeStr.equals(code)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 校验异常模版
     * @param response
     * @param context
     */
    public static void checkTemplate(JSONObject response, Context context){
        String code = response.getString(ActionResult.CODE.getMark());
        if (ActionCode.EXCETPION.equals(code)) {
            ToastUtil.showMsg(context,"异常错误");
        } else if (ActionCode.ERROR.equals(code)){
            ToastUtil.showMsg(context,"操作失败");
        } else if(ActionCode.PARAM_ERROR.equals(code)){
            ToastUtil.showMsg(context,"参数错误");
        }
    }

}
