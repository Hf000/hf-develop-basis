package com.hufei.mpsb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hufei.mpsb.mapper.UserMapper;
import com.hufei.mpsb.pojo.po.User;
import com.hufei.mpsb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>  </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/15 16:59
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(long id) {
        return userMapper.findById(id);
    }

    @Override
    public PageInfo<User> findListUser() {
        return PageHelper.startPage(1, 3).doSelectPageInfo(() -> userMapper.findAll());
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
