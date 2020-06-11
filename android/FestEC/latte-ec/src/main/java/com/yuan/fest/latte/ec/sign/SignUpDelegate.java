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

    @OnClick(R2.id.tv_link_sign_in)
    void onClickLinkSignIn(){
        start(new SignInDelegate());
    }

    @OnClick(R2.id.btn_sign_up)
    void onClickSignUp() {
        if(checkForm()) {
            //TODO 上传信息到服务器
            Toast.makeText(getContext(), "成功", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkForm() {
        final String name = mTeName.getText().toString();
        final String phone = mTePhone.getText().toString();
        final String email = mTeEmail.getText().toString();
        final String password = mTePassword.getText().toString();
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
        } else if(!rePassword.equals(password)){
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
