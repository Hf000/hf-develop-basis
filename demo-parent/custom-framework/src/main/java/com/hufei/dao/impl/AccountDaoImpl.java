package com.hufei.dao.impl;

import com.hufei.dao.AccountDao;

/**
 * <p>  </p>
 * @author hufei
 * @date 2022/7/17 19:24
*/
public class AccountDaoImpl implements AccountDao{

    /**
     * 查询
     */
    @Override
    public String one() {
        System.out.println("Dao查询！");
        return "ok";
    }
}
