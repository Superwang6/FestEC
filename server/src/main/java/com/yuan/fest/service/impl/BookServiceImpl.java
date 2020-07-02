package com.yuan.fest.service.impl;

import com.yuan.fest.entity.Book;
import com.yuan.fest.mapper.BookMapper;
import com.yuan.fest.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王平远
 * @since 2020-07-02
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
