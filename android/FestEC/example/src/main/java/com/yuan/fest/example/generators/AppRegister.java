package com.yuan.fest.example.generators;

import com.yuan.fest.latte.wechat.templetes.AppRegisterTemplete;
import com.yuan.fest.latte_annotation.annotation.AppRegisterGenerator;

@AppRegisterGenerator(
        packageName = "com.yuan.fest.example",
        registerTemplete = AppRegisterTemplete.class
)
public interface AppRegister {
}
