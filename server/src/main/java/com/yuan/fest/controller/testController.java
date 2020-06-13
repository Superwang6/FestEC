package com.yuan.fest.controller;

import com.yuan.fest.common.CommonResult;
import com.yuan.fest.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @RequestMapping("/hello")
    public CommonResult<Object> test(){
        User user = new User();
        user.setUserId(1);
        user.setAddress("南京江宁");
        user.setAvatar("老王");
        user.setGender("男");
        user.setName("王平远");
        return CommonResult.success(user);
    }
}
