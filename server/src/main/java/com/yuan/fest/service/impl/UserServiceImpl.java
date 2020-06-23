package com.yuan.fest.service.impl;

import com.yuan.fest.entity.User;
import com.yuan.fest.mapper.UserMapper;
import com.yuan.fest.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.fest.util.TimeKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王平远
 * @since 2020-06-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User signUp(User user) {
        user.setIsRemove(0);
        user.setCreateTime(TimeKit.getTimeStamp());
//        userMapper.insert(user);
        return null;
    }
}
