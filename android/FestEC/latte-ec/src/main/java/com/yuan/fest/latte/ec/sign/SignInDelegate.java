package com.yuan.fest.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.yuan.fest.latte.app.ConfigType;
import com.yuan.fest.latte.app.Latte;
import com.yuan.fest.latte.delegates.LatteDelegate;
import com.yuan.fest.latte.ec.R;
import com.yuan.fest.latte.ec.R2;
import com.yuan.fest.latte.ec.main.EcBottomDelegate;
import com.yuan.fest.latte.net.RestClient;
import com.yuan.fest.latte.net.callback.IError;
import com.yuan.fest.latte.net.callback.IFailure;
import com.yuan.fest.latte.net.callback.ISuccess;

import butterknife.BindView;
import butterknife.OnClick;

public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.te_email)
    TextInputEditText mTeEmail;
    @BindView(R2.id.te_password)
    TextInputEditText mTePassword;

    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof ISignListener){
            mISignListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn() {
        String url = Latte.getConfigurations().get(ConfigType.API_HOST.name()) + "hello";
        if (checkForm()) {
            if(checkForm()) {
                RestClient.builder()
                        .url(Latte.getConfigurations().get(ConfigType.API_HOST.name()) + "hello")
                        .params("key","value")
                        .success(new ISuccess() {
                            @Override
                            public void onSuccess(String response) {
                                SignHandler.onSignIn(response,mISignListener);
                                startWithPop(new EcBottomDelegate());
                            }
                        })
                        .error(new IError() {
                            @Override
                            public void onError(int code, String msg) {
                                Toast.makeText(getContext(), "登录错误", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .failure(new IFailure() {
                            @Override
                            public void onFailure() {
                                Toast.makeText(getContext(), "登录失败", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build()
                        .post();
            }
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
