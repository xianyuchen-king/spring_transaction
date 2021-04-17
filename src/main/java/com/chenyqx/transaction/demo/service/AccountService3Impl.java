package com.chenyqx.transaction.demo.service;

import com.chenyqx.transaction.demo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 注解控制事务
 */
@Service
public class AccountService3Impl implements AccountService{

    @Autowired
    private AccountDao accountDao;

    @Transactional
    @Override
    public void transfer(String out, String in, Double money) {
        accountDao.inMoney(in,money);
//        int i = 1 / 0;
        accountDao.outMoney(out,money);
    }
}
