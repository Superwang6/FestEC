package com.yuan.fest.example.generators;

import com.yuan.fest.latte.wechat.templetes.WXPayEntryTemplete;
import com.yuan.fest.latte.annotation.PayEntryGenerator;

@PayEntryGenerator(
        packageName = "com.yuan.fest.example",
        payEntryTemplete = WXPayEntryTemplete.class
)
public interface WeChatPayEntry {
}
