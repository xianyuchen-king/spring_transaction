package com.chenyqx.transaction.demo.test;

import com.chenyqx.transaction.demo.service.AccountService;
import com.chenyqx.transaction.demo.service.AccountService2Impl;
import com.chenyqx.transaction.demo.service.AccountService3Impl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMethod {
    @Autowired
    AccountService accountService;
    @Autowired
    AccountService2Impl accountService2;
    @Autowired
    AccountService3Impl accountService3;


    @Test
    public void testTransaction(){
//        accountService.transfer("aaa","bbb",200.00);
//        accountService2.transfer("bbb","aaa",200.00);
        accountService3.transfer("aaa","bbb",200.00);
    }
}
