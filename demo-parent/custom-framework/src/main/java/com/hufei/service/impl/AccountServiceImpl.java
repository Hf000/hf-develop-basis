package com.hufei.service.impl;

import com.hufei.dao.AccountDao;
import com.hufei.service.AccountService;

/**
 * <p>  </p>
 * @author hufei
 * @date 2022/7/17 19:26
*/
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Override
    public String one() {
        System.out.println("AccountServiceImpl.one()方法执行");
        return accountDao.one();
    }
}
