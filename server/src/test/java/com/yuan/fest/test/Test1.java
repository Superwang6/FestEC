package com.yuan.fest.test;

import com.yuan.fest.controller.UserController;
import com.yuan.fest.entity.User;
import com.yuan.fest.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {

    @Autowired
    private UserController userController;

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test1(){
        User user = new User();
        user.setId(3);
        user.setTelephone("1");
        userService.updateUser(user);
    }
}
