package com.yuan.fest.latte.ec.main.bookshelf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yuan.fest.latte.ec.R;
import com.yuan.fest.latte.ec.R2;
import com.yuan.fest.latte.ec.entity.UserBook;
import com.yuan.fest.latte.util.toast.ToastUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ManagerShelfAdapter extends RecyclerView.Adapter<ManagerShelfAdapter.ManagerShelfViewHolder> {

    private Context mContext;
    private List<UserBook> mUserBookList;
    public static final List<Integer> idList = new ArrayList<>();

    public ManagerShelfAdapter(Context context, List<UserBook> userBookList) {
        this.mContext = context;
        this.mUserBookList = userBookList;
    }

    @NonNull
    @Override
    public ManagerShelfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.book_item_manager, parent, false);
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        int height = displayMetrics.heightPixels;
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        layoutParams.height = height / 3;
        ManagerShelfViewHolder managerShelfViewHolder = new ManagerShelfViewHolder(inflate);
        return managerShelfViewHolder;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ManagerShelfViewHolder holder, int position) {
        UserBook userBook = mUserBookList.get(position);
        if (userBook.getBook() != null && userBook.getBook().getPicUrl() != null) {
            Glide.with(mContext).load(userBook.getBook().getPicUrl()).into(holder.mBookPic);
            holder.mDefaultName.setVisibility(View.GONE);
        } else {
            Glide.with(mContext).load(R.string.default_cover).into(holder.mBookPic);
            holder.mDefaultName.setText(userBook.getBook().getName());
        }
        if (userBook.getBook().getName() != null) {
            holder.mBookName.setText(userBook.getBook().getName());
        }
        holder.mParent.setTag(userBook.getId());

        holder.mState.setText(userBook.getBook().getState() == 0 ? "连载中" : "已完结");

        holder.mParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getBackground() == null) {
                    view.setBackground(view.getResources().getDrawable(R.drawable.book_forcus));
                    idList.add((Integer) view.getTag());
                } else {
                    view.setBackground(null);
                    Iterator<Integer> iterator = idList.iterator();
                    while (iterator.hasNext()) {
                        Integer id = iterator.next();
                        if (id == view.getTag()) {
                            iterator.remove();
                            break;
                        }
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserBookList.size();
    }

    static class ManagerShelfViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.v_choose)
        View mChoose;
        @BindView(R2.id.im_book_pic)
        ImageView mBookPic;
        @BindView(R2.id.tv_book_name)
        AppCompatTextView mBookName;
        @BindView(R2.id.tv_state)
        AppCompatTextView mState;
        @BindView(R2.id.tv_default_name)
        AppCompatTextView mDefaultName;
        @BindView(R2.id.ll_parent)
        LinearLayoutCompat mParent;

        public Integer id;

        public ManagerShelfViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
