package com.yuan.fest.latte.ec.main.bookshelf;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.joanzapata.iconify.widget.IconTextView;
import com.yuan.fest.latte.delegates.LatteDelegate;
import com.yuan.fest.latte.ec.R;
import com.yuan.fest.latte.ec.R2;
import com.yuan.fest.latte.ec.entity.UserBook;

import java.util.List;

import butterknife.BindView;

public class ManagerShelfDelegate extends LatteDelegate {

    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;
    @BindView(R2.id.tb_index)
    Toolbar mToolbar = null;
    @BindView(R2.id.icon_cancel)
    IconTextView mIconCancel = null;
    @BindView(R2.id.icon_confirm)
    IconTextView mIconConfirm = null;
    @BindView(R2.id.tv_choose_all)
    TextView mChooseAll = null;
    @BindView(R2.id.tv_delete)
    TextView mDelete = null;

    private List<UserBook> mBookList;

    public ManagerShelfDelegate(List<UserBook> bookList) {
        this.mBookList = bookList;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_manager_bookshelf;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    private void initRecyclerView(List<UserBook> bookList) {
        BookshelfAdapter adapter = new BookshelfAdapter(bookList, getContext(), null);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
    }
}
