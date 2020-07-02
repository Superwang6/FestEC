package com.yuan.fest.latte.ec.main;

import android.graphics.Color;

import com.yuan.fest.latte.delegates.bottom.BaseBottomDelegate;
import com.yuan.fest.latte.delegates.bottom.BottomItemDelegate;
import com.yuan.fest.latte.delegates.bottom.BottomTabBean;
import com.yuan.fest.latte.delegates.bottom.ItemBuilder;
import com.yuan.fest.latte.ec.main.bookshelf.BookshelfDelegate;
import com.yuan.fest.latte.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

public class EcBottomDelegate  extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean,BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{icon-bookshelf}","书架"),new BookshelfDelegate());
        items.put(new BottomTabBean("{icon-book-city}","书城"),new BookshelfDelegate());
        items.put(new BottomTabBean("{icon-find}","发现"),new SortDelegate());
        items.put(new BottomTabBean("{icon-mine}","我的"),new BookshelfDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
