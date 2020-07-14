package com.yuan.fest.latte.ec.main.bookshelf;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.yuan.fest.latte.ec.database.DatabaseManager;
import com.yuan.fest.latte.ec.database.User;
import com.yuan.fest.latte.ec.database.UserDao;
import com.yuan.fest.latte.ec.entity.UserBook;
import com.yuan.fest.latte.net.RestClient;
import com.yuan.fest.latte.net.callback.ActionCode;
import com.yuan.fest.latte.net.callback.ActionResult;
import com.yuan.fest.latte.net.callback.ISuccess;
import com.yuan.fest.latte.util.net.ResponseUtil;
import com.yuan.fest.latte.util.toast.ToastUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class BookshelfDelegate extends BottomItemDelegate {
    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;
    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mRefreshLayout = null;
    @BindView(R2.id.tb_index)
    Toolbar mToolbar = null;
    @BindView(R2.id.et_search_view)
    AppCompatEditText mSearchView = null;
    @BindView(R2.id.icon_index_search)
    IconTextView mIconSearch = null;
    @BindView(R2.id.icon_index_more)
    IconTextView mIconMore = null;

    @OnClick({R2.id.icon_index_search, R2.id.icon_index_more})
    public void doSearch(View view) {
        switch (view.getId()) {
            case R.id.icon_index_search:
                if (mSearchView != null) {
                    String searchText = mSearchView.getText().toString();
                    if (!"".equals(searchText)) {
                        Map<String, Object> params = new HashMap<>();
                        params.put("pageNo", 1);
                        params.put("pageSize", 12);
                        params.put("search", searchText);
                        queryBookshelfData(params);
                    }
                }
                break;
            case R.id.icon_index_more:
                break;
            default:
                break;
        }

    }

    @OnClick(R2.id.icon_index_more)
    public void doMore() {
        ToastUtil.showMsg(getContext(), "应该给哥哥");
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRefreshLayout.setRefreshing(true);
                if (mSearchView != null) {
                    String searchText = mSearchView.getText().toString();
                    if (!"".equals(searchText)) {
                        Map<String, Object> params = new HashMap<>();
                        params.put("pageNo", 1);
                        params.put("pageSize", 12);
                        params.put("search", searchText);
                        queryBookshelfData(params);
                    } else {
                        Map<String, Object> params = new HashMap<>();
                        params.put("pageNo", 1);
                        params.put("pageSize", 12);
                        queryBookshelfData(params);
                    }
                }
                mRefreshLayout.setRefreshing(false);
            }
        });
    }

    /**
     * 第一页数据，进来以后直接加载
     */
    public void queryBookshelfData(Map<String, Object> params) {
        User user = queryLocalUser();
        if (user != null) {
            RestClient.builder()
                    .url(Latte.getConfigurations().get(ConfigType.API_HOST.name()) + "/bookshelf/queryBookshelfList")
                    .params("userId", user.getId())
                    .params(params)
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            JSONObject jsonObject = JSON.parseObject(response);
                            if (ResponseUtil.checkCode(jsonObject, ActionCode.SUCCESS)) {
                                List<UserBook> bookList = jsonObject.getJSONArray(ActionResult.DATA.getMark()).toJavaList(UserBook.class);
                                initRecyclerView(bookList);
                            } else {
                                ResponseUtil.checkTemplate(jsonObject, getContext());
                            }
                        }
                    })
                    .build()
                    .get();
        }
    }

    /**
     * 查询本地存储的用户
     */
    private User queryLocalUser() {
        List<User> userList = DatabaseManager.getInstance().getDao().queryBuilder().orderDesc(UserDao.Properties.Id).list();
        User user = null;
        if (userList != null && userList.size() > 0) {
            user = userList.get(0);
        }
        return user;
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
        BookshelfAdapter adapter = new BookshelfAdapter(bookList, getContext());
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
        Map<String, Object> params = new HashMap<>();
        params.put("pageNo", 1);
        params.put("pageSize", 12);
        queryBookshelfData(params);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_bookshelf;
    }


}
