package com.yuan.fest.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 王平远
 * @since 2020-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 密码，md5 32位加密
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 性别，0男，1女
     */
    private Integer gender;

    /**
     * 地址
     */
    private String address;

    /**
     * 是否删除，0否1是
     */
    private Integer isRemove;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 最后登录时间
     */
    private Integer lastSignInTime;

    /**
     * 最后登录ip
     */
    private String lastSignInIp;

    /**
     * 头像地址
     */
    private String picUrl;

    /**
     * 费用点数，一天扣1点
     */
    private Integer point;
}
