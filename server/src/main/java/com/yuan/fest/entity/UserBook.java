package com.yuan.fest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("user_book")
public class UserBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
}
