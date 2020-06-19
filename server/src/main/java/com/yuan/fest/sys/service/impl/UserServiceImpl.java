package com.yuan.fest.sys.service.impl;

import com.yuan.fest.sys.entity.User;
import com.yuan.fest.sys.mapper.UserMapper;
import com.yuan.fest.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王平远
 * @since 2020-06-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
