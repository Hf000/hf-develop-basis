package com.hufei.shop.service;

import com.hufei.shop.domain.User;

/**
 * <p>  </p>
 * @author hufei
 * @date 2022/7/17 20:03
*/
public interface UserService {
    /***
     * 根据用户名查询登录
     * @param username
     * @return
     */
    User findByUserName(String username);
}
