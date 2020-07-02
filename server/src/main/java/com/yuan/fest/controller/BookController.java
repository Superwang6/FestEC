package com.yuan.fest.controller;


import com.yuan.fest.common.CommonResult;
import com.yuan.fest.entity.User;
import com.yuan.fest.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王平远
 * @since 2020-07-02
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    public CommonResult queryBookList(){


        return null;
    }

}

