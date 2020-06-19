package com.yuan.fest.example;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.yuan.fest.latte.app.ConfigType;
import com.yuan.fest.latte.app.Latte;
import com.yuan.fest.latte.delegates.LatteDelegate;
import com.yuan.fest.latte.net.RestClient;
import com.yuan.fest.latte.net.callback.IError;
import com.yuan.fest.latte.net.callback.IFailure;
import com.yuan.fest.latte.net.callback.ISuccess;

public class ExampleDelegate extends LatteDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
//        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url(Latte.getConfigurations().get(ConfigType.API_HOST) + "hello")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
