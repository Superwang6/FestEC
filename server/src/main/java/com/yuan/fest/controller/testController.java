package com.yuan.fest.controller;

import com.yuan.fest.common.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @RequestMapping("/hello")
    public CommonResult<Object> test(){
        return CommonResult.success();
    }
}
