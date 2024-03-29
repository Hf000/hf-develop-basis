package com.hufei.mpsbs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.hufei.mpsbs.pojo.po.User;

import java.util.List;

/**
 * <p> user信息查询 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/15 16:58
 */
public interface UserService extends IService<User> {

    User findById(long id);

    PageInfo<User> findListUser();

    List<User> findAll();
}
