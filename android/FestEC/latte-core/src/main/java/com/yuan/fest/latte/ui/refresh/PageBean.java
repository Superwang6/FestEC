package com.yuan.fest.latte.ui.refresh;

public final class PageBean {
    /**
     * 每页显示条数
     */
    private Integer pageSize;

    /**
     * 当前页码数
     */
    private Integer pageNo;

    /**
     * 总数据条数
     */
    private Integer total;

    /**
     * 当前数据条数
     */
    private Integer currentCount;

    /**
     * 加载延迟
     */
    private int delayed;

    public Integer getPageSize() {
        return pageSize;
    }

    public PageBean setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public PageBean setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public PageBean setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getCurrentCount() {
        return currentCount;
    }

    public PageBean setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
        return this;
    }

    public int getDelayed() {
        return delayed;
    }

    public PageBean setDelayed(int delayed) {
        this.delayed = delayed;
        return this;
    }
}
