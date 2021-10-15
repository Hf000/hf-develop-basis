package com.hufei.mpsb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hufei.mpsb.pojo.po.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    User findById(Long id);

    List<User> findAll();

}
