package com.yuan.fest.controller;


import com.yuan.fest.annotation.Log;
import com.yuan.fest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王平远
 * @since 2020-06-23
 */
@RestController
@RequestMapping("/fest/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/hello")
    public String hello(){
        int i = 1/1;
        System.out.println(i);
        return i+"";
    }
    @RequestMapping("/hello1")
    public String hello1(){
        int i = 1/1;
        System.out.println(i);
        return i+"";
    }
}