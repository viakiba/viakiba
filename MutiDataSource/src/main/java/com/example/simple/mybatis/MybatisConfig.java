package com.example.simple.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class MybatisConfig {

    public DataSource createDataSource(String serverId){
        if(serverId.equals("1")){
            return  get1DataSourceConfig();
        }
        if(serverId.equals("2")){
            return get2DataSourceConfig();
        }

        return null;
    }

    private DruidDataSource get1DataSourceConfig() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName("1");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/db1");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    private DruidDataSource get2DataSourceConfig() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName("2");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/db2");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    public SqlSessionFactory buildSqlSessionFactory(String serverId){
        DataSource dataSource = createDataSource(serverId);
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);

        configuration.addMappers("com.example.simple.mybatis.mapper");

        return new SqlSessionFactoryBuilder().build(configuration);
    }

}
