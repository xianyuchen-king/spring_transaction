package com.chenyqx.transaction.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl implements AccountDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void outMoney(String out, Double money) {
        String sql = "update account set money = money - ? where name = ?";
        jdbcTemplate.update(sql, money, out);
    }


    @Override
    public void inMoney(String in, Double money) {
        String sql = "update account set money = money + ? where name = ?";
        jdbcTemplate.update(sql, money, in);
    }
}
