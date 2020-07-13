package com.yuan.fest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuan.fest.entity.User;
import com.yuan.fest.exception.UnNormalException;
import com.yuan.fest.mapper.UserMapper;
import com.yuan.fest.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.fest.util.TimeKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public User signUp(User user) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("is_remove",0).eq("telephone",user.getTelephone()).or().eq("email",user.getEmail());
        List<User> users = userMapper.selectList(qw);
        if(users != null && users.size() > 0) {
            throw new UnNormalException("注册失败，该手机号或邮箱已经注册");
        }
        user.setIsRemove(0);
        user.setCreateTime(TimeKit.getTimeStamp());
        //新用户注册赠送30点
        user.setPoint(30);
        userMapper.insert(user);
        return user;
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User signIn(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_remove",0);
        queryWrapper.eq("telephone",user.getTelephone());
        queryWrapper.eq("password",user.getPassword());
        User data = userMapper.selectOne(queryWrapper);
        if(data == null) {
            throw new UnNormalException("用户名或密码错误");
        }
        return data;
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userMapper.updateById(user);
        changeUser(user);
        userMapper.updateById(user);
    }

    private User changeUser(User user) {
        user.setTelephone("11");
        int a = 1/0;
        change2User(user);
        return user;
    }

    private User change2User(User user){
        user.setTelephone("111");
        return user;
    }


}
