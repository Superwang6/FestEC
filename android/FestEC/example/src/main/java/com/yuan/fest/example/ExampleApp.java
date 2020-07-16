package com.yuan.fest.example;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.yuan.fest.latte.app.Latte;
import com.yuan.fest.latte.ec.database.DatabaseManager;
import com.yuan.fest.latte.ec.icon.FontEcModule;
import com.yuan.fest.latte.net.interceptors.DebugInterceptor;

import okhttp3.OkHttpClient;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcons(new FontAwesomeModule())
                .withIcons(new FontEcModule())
                .withApiHost("http://192.168.0.113:8090/")
//                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .configure();
        DatabaseManager.getInstance().init(this);
        initStetho();
    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this)).build());
    }
}
