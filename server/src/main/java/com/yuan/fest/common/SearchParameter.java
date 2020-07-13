package com.yuan.fest.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SearchParameter {
    /**
     * 每页显示条数
     */
    private Integer pageSize;
    /**
     * 当前页码数
     */
    private Integer pageNo;
    /**
     * 记录开始数 = (pageNo - 1) * pageSize
     */
    private Integer offset;
    /**
     * 数据条数限制
     */
    private Integer limit;
    /**
     * 开始时间
     */
    private Integer stime;
    /**
     * 结束时间
     */
    private Integer etime;

    /**
     * 开始时间1
     */
    private Integer stime1;
    /**
     * 结束时间1
     */
    private Integer etime1;

    /**
     * 开始时间2
     */
    private Integer stime2;
    /**
     * 结束时间2
     */
    private Integer etime2;

    /**
     * 排序,0为升序,1为降序
     */
    private Integer order;

    /**
     * 排序字段
     */
    private String orderField;

    /**
     * 排序值
     */
    private String orderValue;

    /**
     * 搜索的内容
     */
    private String search;

    public Integer getOffset() {
        return (pageNo - 1) * pageSize;
    }

    public Integer getLimit() {
        return pageSize;
    }

    public <T> Page<T> convertIPage(T t) {
        Page<T> page = new Page<>(pageNo, pageSize);
        return page;
    }
}
