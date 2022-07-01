package com.hufei.ds.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hufei.ds.beans.entity.User;
import com.hufei.ds.dao.UserMapper;
import com.hufei.ds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hf
 * @since 2021-11-02 17:18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

     @Autowired
     private UserMapper userMapper;

}
