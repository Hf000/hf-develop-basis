package com.hufei.mpsbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hufei.mpsbs.pojo.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User findById(Long id);

    List<User> findAll();

}
