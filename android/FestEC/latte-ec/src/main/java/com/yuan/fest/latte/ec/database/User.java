package com.yuan.fest.latte.ec.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity(nameInDb = "user")
public class User {

    @Id
    private Long id;

    /**
     * 名称
     */
    private String name;

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

    @Generated(hash = 1916947261)
    public User(Long id, String name, String nickName, String email, String telephone, Integer gender, String address, Integer isRemove, Integer createTime, Integer lastSignInTime, String lastSignInIp, String picUrl, Integer point) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.telephone = telephone;
        this.gender = gender;
        this.address = address;
        this.isRemove = isRemove;
        this.createTime = createTime;
        this.lastSignInTime = lastSignInTime;
        this.lastSignInIp = lastSignInIp;
        this.picUrl = picUrl;
        this.point = point;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIsRemove() {
        return isRemove;
    }

    public void setIsRemove(Integer isRemove) {
        this.isRemove = isRemove;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getLastSignInTime() {
        return lastSignInTime;
    }

    public void setLastSignInTime(Integer lastSignInTime) {
        this.lastSignInTime = lastSignInTime;
    }

    public String getLastSignInIp() {
        return lastSignInIp;
    }

    public void setLastSignInIp(String lastSignInIp) {
        this.lastSignInIp = lastSignInIp;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
