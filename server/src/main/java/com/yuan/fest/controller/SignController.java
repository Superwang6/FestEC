package com.yuan.fest.controller;

import com.yuan.fest.common.CommonResult;
import com.yuan.fest.common.ResultCode;
import com.yuan.fest.entity.User;
import com.yuan.fest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 登录，注册
 */
@RestController
public class SignController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/signUp")
    public CommonResult signUp(User user){
        try {
            if(user == null || user.getEmail() == null
                    || user.getNickName() == null
                    || user.getTelephone() == null
                    || user.getPassword() == null) {
                return CommonResult.failed(ResultCode.PARAM_ERROR);
            }
            User data = userService.signUp(user);
            return CommonResult.success(data);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed();
        }
    }
}
