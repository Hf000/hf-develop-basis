package com.hufei.application.seven.news;


public class UserService {

    private UserDao userDao;
    private LogDao logDao;

    public void modify(){
        userDao.modify();
        logDao.recode();
    }
}
