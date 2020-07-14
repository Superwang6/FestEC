package com.yuan.fest.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.fest.common.SearchParameter;
import com.yuan.fest.entity.UserBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 王平远
 * @since 2020-07-02
 */
@Repository
public interface UserBookMapper extends BaseMapper<UserBook> {

    IPage<UserBook> queryBookshelfList(IPage<UserBook> iPage, @Param("userBook") UserBook userBook, @Param("param") SearchParameter param);
}
