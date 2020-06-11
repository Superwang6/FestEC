package com.yuan.fest.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuan.fest.latte.net.callback.ActionCode;
import com.yuan.fest.latte.net.callback.ActionResult;

public class SignHandler {

    public void onSignUp(String response) {
        JSONObject actionResultData = JSON.parseObject(response);
        if(ActionCode.success.equals(actionResultData.getString(ActionResult.CODE.name()))){
            JSONObject date = actionResultData.getJSONObject(ActionResult.DATA.name());
        }
    }
}
