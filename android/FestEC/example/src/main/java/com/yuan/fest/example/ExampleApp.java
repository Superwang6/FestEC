package com.yuan.fest.example;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.yuan.fest.latte.app.Latte;
import com.yuan.fest.latte.ec.icon.FontEcModule;
import com.yuan.fest.latte.net.interceptors.DebugInterceptor;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcons(new FontAwesomeModule())
                .withIcons(new FontEcModule())
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .configure();
    }
}
