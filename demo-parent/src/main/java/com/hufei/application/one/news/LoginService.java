package com.hufei.application.one.news;

import org.springframework.beans.factory.annotation.Autowired;


public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public Object findUser(String username, String password) {
        return loginDao.query();
    }
}
