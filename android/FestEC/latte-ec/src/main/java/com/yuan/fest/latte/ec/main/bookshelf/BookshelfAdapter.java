package com.yuan.fest.latte.ec.main.bookshelf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yuan.fest.latte.ec.R;
import com.yuan.fest.latte.ec.R2;
import com.yuan.fest.latte.ec.entity.UserBook;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookshelfAdapter extends RecyclerView.Adapter<BookshelfAdapter.ViewHolder> {

    private final List<UserBook> mUserBookList;
    private final Context mContext;

    public BookshelfAdapter(List<UserBook> userBookList, Context context) {
        this.mUserBookList = userBookList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        UserBook userBook = mUserBookList.get(position);
//        Glide.with(mContext).load(userBook.getBook().getPicUrl()).into(holder.mImageView);
//        holder.mTvBookName.setText(userBook.getBook().getName());
//        holder.mTvBookState.setText(userBook.getBook().getState() == 0 ? "连载中" : "已完结");
        holder.mTvBookName.setText("哈哈哈");
    }

    @Override
    public int getItemCount() {
        return mUserBookList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R2.id.im_book_pic)
        ImageView mImageView;
//        @BindView(R2.id.tv_book_name)
        AppCompatTextView mTvBookName;
//        @BindView(R2.id.tv_state)
        AppCompatTextView mTvBookState;

        public ViewHolder(@NonNull View view) {
            super(view);
//            ButterKnife.bind(view);
            mImageView = view.findViewById(R.id.im_book_pic);
            mTvBookName = view.findViewById(R.id.tv_book_name);
            mTvBookState = view.findViewById(R.id.tv_state);
        }

    }
}
