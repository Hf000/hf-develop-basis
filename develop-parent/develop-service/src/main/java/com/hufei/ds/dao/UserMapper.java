package com.hufei.ds.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hufei.ds.beans.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hf
 * @since 2021-11-02 17:18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}