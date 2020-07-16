package com.yuan.fest.latte.ec.main.bookshelf;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ManagerShelfAdapter extends RecyclerView.Adapter<ManagerShelfAdapter.ManagerShelfViewHolder> {


    @NonNull
    @Override
    public ManagerShelfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ManagerShelfViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ManagerShelfViewHolder extends RecyclerView.ViewHolder{

        public ManagerShelfViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
