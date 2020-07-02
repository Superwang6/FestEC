package com.yuan.fest.latte.ec.entity;

public class UserBook {
    /**
     * 书id
     */
    private Integer bookId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 是否置顶，0否1是
     */
    private Integer isTopping;

    /**
     * 是否删除，0否1是
     */
    private Integer isRemove;

    /**
     * 书籍
     */
    private Book book;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsTopping() {
        return isTopping;
    }

    public void setIsTopping(Integer isTopping) {
        this.isTopping = isTopping;
    }

    public Integer getIsRemove() {
        return isRemove;
    }

    public void setIsRemove(Integer isRemove) {
        this.isRemove = isRemove;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
