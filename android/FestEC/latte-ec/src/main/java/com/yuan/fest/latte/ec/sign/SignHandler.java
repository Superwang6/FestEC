package com.yuan.fest.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuan.fest.latte.app.AccountManager;
import com.yuan.fest.latte.ec.database.DatabaseManager;
import com.yuan.fest.latte.ec.database.User;
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
        final Long id = profileJson.getLong("id");
        final String name = profileJson.getString("name");
        final String nickName = profileJson.getString("nickName");
        final String email = profileJson.getString("email");
        final String telephone = profileJson.getString("telephone");
        final Integer gender = profileJson.getInteger("gender");
        final String address = profileJson.getString("address");
        final Integer isRemove = profileJson.getInteger("isRemove");
        final Integer createTime = profileJson.getInteger("createTime");
        final Integer lastSignInTime = profileJson.getInteger("lastSignInTime");
        final String lastSignInIp = profileJson.getString("lastSignInIp");
        final String picUrl = profileJson.getString("picUrl");
        final Integer point = profileJson.getInteger("point");

        final User user = new User(id,name,nickName,email,telephone,gender,address,isRemove,createTime,lastSignInTime,lastSignInIp,picUrl,point);
        DatabaseManager.getInstance().getDao().insert(user);

        //已经注册并登录成功
        AccountManager.setSignState(true);
    }
}
