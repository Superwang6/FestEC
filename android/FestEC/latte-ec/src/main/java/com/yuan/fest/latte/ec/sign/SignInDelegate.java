package com.yuan.fest.latte.ec.sign;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.yuan.fest.latte.delegates.LatteDelegate;
import com.yuan.fest.latte.ec.R;
import com.yuan.fest.latte.ec.R2;

import butterknife.BindView;
import butterknife.OnClick;

public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.te_email)
    TextInputEditText mTeEmail;
    @BindView(R2.id.te_password)
    TextInputEditText mTePassword;

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn() {
        if (checkForm()) {
            //TODO 登录
            Toast.makeText(getContext(), "登录", Toast.LENGTH_SHORT).show();
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


    private boolean checkForm() {
        final String email = mTeEmail.getText().toString();
        final String password = mTePassword.getText().toString();

        boolean isPass = true;

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
