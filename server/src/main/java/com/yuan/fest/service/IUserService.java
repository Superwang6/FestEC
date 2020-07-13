package com.yuan.fest.service;

import com.yuan.fest.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王平远
 * @since 2020-06-23
 */
public interface IUserService extends IService<User> {

    User signUp(User user);

    User signIn(User user);

    void updateUser(User user);
}
