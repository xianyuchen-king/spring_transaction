package com.chenyqx.transaction.demo.service;

import com.chenyqx.transaction.demo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * spring 事务模板控制事务
 */
@Service
public class AccountService2Impl implements AccountService{

    @Autowired
    private AccountDao accountDao; // 注入事务管理的模板
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void transfer(String out, String in, Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                accountDao.inMoney(in,money);
                int i = 1 / 0;
                accountDao.outMoney(out,money);
            }
        });
    }
}
