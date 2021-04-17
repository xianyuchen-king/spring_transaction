package com.chenyqx.transaction.demo.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class DBconfig {

    private static DataSource dataSource;

    static{
        try{
            Properties properties = new Properties();
            InputStream in = DBconfig.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Bean
    public DataSource dataSource(){
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public TransactionTemplate transactionTemplate(){
        return new TransactionTemplate(dataSourceTransactionManager());
    }
}
