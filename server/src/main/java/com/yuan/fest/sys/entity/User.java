package com.yuan.fest.sys.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 王平远
 * @since 2020-06-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

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


}
