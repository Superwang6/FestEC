package com.yuan.fest.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.fest.common.CommonResult;
import com.yuan.fest.common.ResultCode;
import com.yuan.fest.common.SearchParameter;
import com.yuan.fest.entity.UserBook;
import com.yuan.fest.service.IUserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王平远
 * @since 2020-07-02
 */
@RestController
@RequestMapping("/bookshelf")
public class BookshelfController {

    @Autowired
    private IUserBookService userBookService;

    /**
     * 查询某人的书架中的书籍列表
     * @param userBook
     * @return
     */
    @RequestMapping("/queryBookshelfList")
    public CommonResult queryBookshelfList(UserBook userBook, SearchParameter param){
        try {
            IPage<UserBook> userBookList = userBookService.queryBookshelfList(userBook,param);
            return CommonResult.success(userBookList);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(ResultCode.EXCEPTION);
        }
    }
}

