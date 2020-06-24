package com.yuan.fest.controller;

import com.yuan.fest.common.CommonResult;
import com.yuan.fest.common.ResultCode;
import com.yuan.fest.entity.User;
import com.yuan.fest.exception.UnNormalException;
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


    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping("/signUp")
    public CommonResult signUp(User user) {
        try {
            if (user == null || user.getEmail() == null
                    || user.getNickName() == null
                    || user.getTelephone() == null
                    || user.getPassword() == null) {
                return CommonResult.failed(ResultCode.PARAM_ERROR);
            }
            User data = userService.signUp(user);
            return CommonResult.success(data);
        } catch (UnNormalException e) {
            e.printStackTrace();
            return CommonResult.failed(ResultCode.PARAM_ERROR,e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(ResultCode.EXCEPTION);
        }
    }

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @RequestMapping("/signIn")
    public CommonResult signIn(User user) {
        try {
            if (user == null || user.getTelephone() == null || user.getPassword() == null) {
                return CommonResult.failed(ResultCode.PARAM_ERROR);
            }
            User data = userService.signIn(user);
            return CommonResult.success(data);
        } catch (UnNormalException e) {
            e.printStackTrace();
            return CommonResult.failed(ResultCode.ERROR_LOGINFORUSERNAMEPASSWORK);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(ResultCode.EXCEPTION);
        }
    }
}
