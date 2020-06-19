package com.yuan.fest.example;

import android.widget.Toast;

import com.yuan.fest.latte.activities.ProxyActivity;
import com.yuan.fest.latte.delegates.LatteDelegate;
import com.yuan.fest.latte.ec.launcher.LauncherDelegate;
import com.yuan.fest.latte.ec.main.EcBottomDelegate;
import com.yuan.fest.latte.ec.sign.ISignListener;
import com.yuan.fest.latte.ec.sign.SignInDelegate;
import com.yuan.fest.latte.ec.sign.SignUpDelegate;
import com.yuan.fest.latte.ui.launcher.ILauncherListener;
import com.yuan.fest.latte.ui.launcher.OnLauncherFinishTag;

public class ExampleActivity extends ProxyActivity implements ISignListener, ILauncherListener {

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                Toast.makeText(this,"启动结束，用户登录了",Toast.LENGTH_LONG).show();
                start(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this,"启动结束，用户没登录",Toast.LENGTH_LONG).show();
                startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
