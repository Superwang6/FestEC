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
public class Chapter implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 书id
     */
    private Integer bookId;

    /**
     * 章节名称
     */
    private String name;

    /**
     * 是否已读，0否1是
     */
    private Integer isRead;

    /**
     * 是否缓存，0否1是
     */
    private Integer isCache;


}
