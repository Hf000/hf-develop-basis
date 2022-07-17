package com.hufei.controller;

import com.hufei.domain.User;
import com.hufei.framework.util.RequestMapping;
import com.hufei.service.AccountService;

/**
 * <p>  </p>
 * @author hufei
 * @date 2022/7/17 19:22
*/
public class AccountController {

    private AccountService accountService;

    /***
     * 查询一条记录
     */
    @RequestMapping(value = "/account/one")
    public String one(){
        System.out.println("执行了one!");
        String result = null;//accountService.one();
        return "/WEB-INF/pages/one.jsp";
    }

    /***
     * 查询一条记录
     */
    @RequestMapping(value = "/account/info")
    public User info(){
        User user = new User();
        user.setName("王五");
        user.setAddress("深圳");
        return user;
    }
}
