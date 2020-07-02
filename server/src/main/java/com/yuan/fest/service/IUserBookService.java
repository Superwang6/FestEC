package com.yuan.fest.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.fest.common.SearchParameter;
import com.yuan.fest.entity.UserBook;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王平远
 * @since 2020-07-02
 */
public interface IUserBookService extends IService<UserBook> {

    IPage<UserBook> queryBookshelfList(UserBook userBook, SearchParameter param);
}
