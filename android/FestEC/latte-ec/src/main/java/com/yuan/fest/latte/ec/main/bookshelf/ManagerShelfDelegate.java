package com.yuan.fest.latte.ec.main.bookshelf;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.joanzapata.iconify.widget.IconTextView;
import com.yuan.fest.latte.app.ConfigType;
import com.yuan.fest.latte.app.Latte;
import com.yuan.fest.latte.delegates.LatteDelegate;
import com.yuan.fest.latte.ec.R;
import com.yuan.fest.latte.ec.R2;
import com.yuan.fest.latte.ec.entity.UserBook;
import com.yuan.fest.latte.net.RestClient;
import com.yuan.fest.latte.net.callback.IError;
import com.yuan.fest.latte.net.callback.ISuccess;
import com.yuan.fest.latte.util.net.ParamUtil;
import com.yuan.fest.latte.util.toast.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

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

    @OnClick(R2.id.tv_delete)
    public void onDelete(View view){
        ToastUtil.showMsg(getContext(),"点击删除");
        RestClient.builder()
                .url(Latte.getConfigurations().get(ConfigType.API_HOST.name()) + "/bookshelf/removeBookshelfList")
                .params("idList", ParamUtil.getList(ManagerShelfAdapter.idList))
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        ToastUtil.showMsg(getContext(),"删除成功");
                        initRecyclerView();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }

    @OnClick(R2.id.tv_choose_all)
    public void onChooseAll(View view){

    }

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
        initRecyclerView();
    }

    private void initRecyclerView(){
        ManagerShelfAdapter managerShelfAdapter = new ManagerShelfAdapter(getContext(),mBookList);
        GridLayoutManager manager = new GridLayoutManager(getContext(),3);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(managerShelfAdapter);
    }
}
