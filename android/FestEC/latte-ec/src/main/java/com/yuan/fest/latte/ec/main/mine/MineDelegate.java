package com.yuan.fest.latte.ec.main.mine;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.yuan.fest.latte.delegates.bottom.BottomItemDelegate;
import com.yuan.fest.latte.ec.R;

public class MineDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_mine;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
