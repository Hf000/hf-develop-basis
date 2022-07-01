package com.hufei.mps.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hufei.mps.pojo.po.User;

import java.util.List;

/**
 * mybatis-plus：需要继承BaseMapper这个对象
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();
}
