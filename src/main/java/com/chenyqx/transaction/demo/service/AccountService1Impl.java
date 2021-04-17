package com.chenyqx.transaction.demo.service;

import com.chenyqx.transaction.demo.dao.AccountDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * spring 事务管理器手动控制事务
 */
@Service
@Slf4j
@Primary
public class AccountService1Impl implements AccountService{
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Override
    public void transfer(final String out, final String in, final Double money) {
        //配置事务策略
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("transaction-point");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        //设置状态点
        TransactionStatus transactionStatus = transactionManager.getTransaction(def);
        try{
            accountDao.inMoney(in,money);
            int i = 1 / 0;
            accountDao.outMoney(out,money);
            transactionManager.commit(transactionStatus);
            System.out.println("成功提交");
        }catch (Exception e){
            transactionManager.rollback(transactionStatus);
            System.out.println("回滚了老铁");
        }
    }

}
