package com.yuan.fest.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.fastjson.JSON;
import com.google.android.material.textfield.TextInputEditText;
import com.yuan.fest.latte.app.ConfigType;
import com.yuan.fest.latte.app.Latte;
import com.yuan.fest.latte.delegates.LatteDelegate;
import com.yuan.fest.latte.ec.R;
import com.yuan.fest.latte.ec.R2;
import com.yuan.fest.latte.ec.main.EcBottomDelegate;
import com.yuan.fest.latte.net.RestClient;
import com.yuan.fest.latte.net.callback.ActionCode;
import com.yuan.fest.latte.net.callback.ActionResult;
import com.yuan.fest.latte.net.callback.IError;
import com.yuan.fest.latte.net.callback.ISuccess;
import com.yuan.fest.latte.util.encryption.Md5Util;
import com.yuan.fest.latte.util.toast.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.te_telephone)
    TextInputEditText mTeTelephone;
    @BindView(R2.id.te_password)
    TextInputEditText mTePassword;

    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn() {
        final String ePhone = mTeTelephone.getText().toString();
        final String password = mTePassword.getText().toString();
        String md5 = Md5Util.getMD5(password);
        if (checkForm(ePhone, password)) {
            RestClient.builder()
                    .url(Latte.getConfigurations().get(ConfigType.API_HOST.name()) + "signIn")
                    .params("telephone", ePhone)
                    .params("password", md5)
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            String code = JSON.parseObject(response).getString(ActionResult.CODE.getMark());
                            if (code.equals(ActionCode.success)) {
                                SignHandler.onSignIn(response, mISignListener);
                                startWithPop(new EcBottomDelegate());
                            } else {
                                String message = JSON.parseObject(response).getString(ActionResult.MESSAGE.getMark());
                                ToastUtil.showMsg(getContext(), message);
                            }
                        }
                    })
                    .error(new IError() {
                        @Override
                        public void onError(int code, String msg) {
                            ToastUtil.showMsg(getContext(), msg);
                        }
                    })
                    .build()
                    .post();
        }
    }

    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWeChatSignIn() {
        //TODO weChat登录
    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLinkSignUp() {
        start(new SignUpDelegate());
    }


    private boolean checkForm(String ePhone, String password) {
        boolean isPass = true;

        if (ePhone == null || ePhone.isEmpty()) {
            mTeTelephone.setError("请输入电话");
            isPass = false;
        } else {
            mTeTelephone.setError(null);
        }

        if (password == null || password.isEmpty()) {
            mTePassword.setError("请输入密码");
            isPass = false;
        } else {
            mTePassword.setError(null);
        }

        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
