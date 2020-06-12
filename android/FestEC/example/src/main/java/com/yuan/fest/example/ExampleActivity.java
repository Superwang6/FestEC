package com.yuan.fest.example;

import com.yuan.fest.latte.activities.ProxyActivity;
import com.yuan.fest.latte.delegates.LatteDelegate;
import com.yuan.fest.latte.ec.sign.SignUpDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new SignUpDelegate();
    }

}
