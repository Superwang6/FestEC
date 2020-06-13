package com.yuan.fest.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuan.fest.latte.app.AccountManager;
import com.yuan.fest.latte.ec.database.DatabaseManager;
import com.yuan.fest.latte.ec.database.UserProfile;
import com.yuan.fest.latte.net.callback.ActionResult;

public class SignHandler {

    public static void onSignUp(String response, ISignListener signListener) {
        onSign(response);
        signListener.onSignUpSuccess();
    }

    public static void onSignIn(String response, ISignListener signListener) {
        onSign(response);
        signListener.onSignInSuccess();
    }

    private static void onSign(String response) {
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject(ActionResult.DATA.getMark());
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(profile);

        //已经注册并登录成功
        AccountManager.setSignState(true);
    }
}
