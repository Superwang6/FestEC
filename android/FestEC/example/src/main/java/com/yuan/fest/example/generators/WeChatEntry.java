package com.yuan.fest.example.generators;

import com.yuan.fest.latte.wechat.templetes.WXEntryTemplete;
import com.yuan.fest.latte_annotation.annotation.EntryGenerator;

@EntryGenerator(
        packageName = "com.yuan.fest.example",
        entryTemplete = WXEntryTemplete.class
)
public interface WeChatEntry {

}
