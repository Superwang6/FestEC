package com.yuan.fest.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.util.Patterns;
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

public class SignUpDelegate extends LatteDelegate {

    @BindView(R2.id.te_name)
    TextInputEditText mTeName;
    @BindView(R2.id.te_phone)
    TextInputEditText mTePhone;
    @BindView(R2.id.te_email)
    TextInputEditText mTeEmail;
    @BindView(R2.id.te_password)
    TextInputEditText mTePassword;
    @BindView(R2.id.te_re_password)
    TextInputEditText mTeRePassword;

    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.tv_link_sign_in)
    void onClickLinkSignIn() {
        start(new SignInDelegate());
    }

    @OnClick(R2.id.btn_sign_up)
    void onClickSignUp() {
        final String name = mTeName.getText().toString();
        final String phone = mTePhone.getText().toString();
        final String email = mTeEmail.getText().toString();
        final String password = mTePassword.getText().toString();

        if (checkForm(name, phone, email, password)) {
            String md5 = Md5Util.getMD5(password);
            RestClient.builder()
                    .url(Latte.getConfigurations().get(ConfigType.API_HOST.name()) + "signUp")
                    .params("nickName", name)
                    .params("telephone", phone)
                    .params("email", email)
                    .params("password", md5)
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            String code = JSON.parseObject(response).getString(ActionResult.CODE.getMark());
                            if (code.equals(ActionCode.SUCCESS)) {
                                SignHandler.onSignUp(response, mISignListener);
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

    private boolean checkForm(String name, String phone, String email, String password) {
        final String rePassword = mTeRePassword.getText().toString();

        boolean isPass = true;
        if (name == null || name.isEmpty()) {
            mTeName.setError("请输入姓名");
            isPass = false;
        } else {
            mTeName.setError(null);
        }

        if (phone == null || phone.isEmpty()) {
            mTePhone.setError("请输入电话");
            isPass = false;
        } else if (phone.length() != 11) {
            mTePhone.setError("输入电话错误");
            isPass = false;
        } else {
            mTePhone.setError(null);
        }

        if (email == null || email.isEmpty()) {
            mTeEmail.setError("请输入Email");
            isPass = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mTeEmail.setError("Email格式错误");
            isPass = false;
        } else {
            mTeEmail.setError(null);
        }

        if (password == null || password.isEmpty()) {
            mTePassword.setError("请输入密码");
            isPass = false;
        } else {
            mTePassword.setError(null);
        }

        if (rePassword == null || rePassword.isEmpty()) {
            mTeRePassword.setError("请重新输入密码");
            isPass = false;
        } else if (!rePassword.equals(password)) {
            mTeRePassword.setError("验证密码失败");
            isPass = false;
        } else {
            mTeRePassword.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
