package com.yuan.fest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 王平远
 * @since 2020-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 书名
     */
    private String name;

    /**
     * 封面
     */
    private String picUrl;

    /**
     * 作者
     */
    private String author;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 字数，（万字）
     */
    private Integer number;

    /**
     * 来源
     */
    private String source;

    /**
     * 状态，0连载中，1已完结
     */
    private Integer state;
}
