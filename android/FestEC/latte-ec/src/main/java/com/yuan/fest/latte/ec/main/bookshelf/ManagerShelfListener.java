package com.yuan.fest.latte.ec.main.bookshelf;

import com.yuan.fest.latte.ec.entity.UserBook;

import java.util.List;

public interface ManagerShelfListener {
    void onClick(List<UserBook> bookList);
}
