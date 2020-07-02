package com.yuan.fest.latte.ec.main.bookshelf;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.joanzapata.iconify.widget.IconTextView;
import com.yuan.fest.latte.app.ConfigType;
import com.yuan.fest.latte.app.Latte;
import com.yuan.fest.latte.delegates.bottom.BottomItemDelegate;
import com.yuan.fest.latte.ec.R;
import com.yuan.fest.latte.ec.R2;
import com.yuan.fest.latte.ec.entity.UserBook;
import com.yuan.fest.latte.net.RestClient;
import com.yuan.fest.latte.net.callback.ActionResult;
import com.yuan.fest.latte.net.callback.ISuccess;
import com.yuan.fest.latte.ui.refresh.RefreshHandler;
import com.yuan.fest.latte.util.net.ResponseUtil;

import java.util.List;

import butterknife.BindView;

public class BookshelfDelegate extends BottomItemDelegate {
    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;
    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mRefreshLayout = null;
    @BindView(R2.id.tb_index)
    Toolbar mToolbar = null;
    @BindView(R2.id.icon_index_scan)
    IconTextView mIconScan = null;
    @BindView(R2.id.et_search_view)
    AppCompatEditText mSearchView = null;

    private RefreshHandler mRefreshHandler = null;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mRefreshHandler = new RefreshHandler(mRefreshLayout);
    }

    /**
     * 第一页数据，进来以后直接加载
     */
    public void firstPage() {
        RestClient.builder()
                .url(Latte.getConfigurations().get(ConfigType.API_HOST.name()) + "/bookshelf/queryBookshelfList")
                .params("userId", 3)
                .params("pageNo", 1)
                .params("pageSize", 3)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        JSONObject jsonObject = JSON.parseObject(response);
                        if (ResponseUtil.checkCode(jsonObject)) {
                            List<UserBook> bookList = jsonObject.getJSONArray(ActionResult.DATA.getMark()).toJavaList(UserBook.class);
                            initRecyclerView(bookList);
                        }
                    }
                })
                .build()
                .get();
    }

    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        mRefreshLayout.setProgressViewOffset(true, 120, 300);
    }

    private void initRecyclerView(List<UserBook> bookList) {
        BookshelfAdapter adapter = new BookshelfAdapter(bookList,getContext());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
        firstPage();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }


}
