package com.hufei.mpsb.controller;

import com.github.pagehelper.PageInfo;
import com.hufei.cp.response.ResponseVO;
import com.hufei.cp.utils.ResponseUtil;
import com.hufei.mpsb.pojo.po.User;
import com.hufei.mpsb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> 测试pageHelper </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/15 16:55
 */
@Slf4j
@RestController
@RequestMapping("pageHelper")
public class PageHelperController {

    @Autowired
    private UserService userService;

    @GetMapping("test")
    public ResponseVO<PageInfo<User>> findListUser() {
        PageInfo<User> listUser = userService.findListUser();
        User user = userService.findById(1);
        System.out.println("==========================================");
        log.info(user.toString());
        System.out.println("==========================================");
        return ResponseUtil.success(listUser);
    }

}
