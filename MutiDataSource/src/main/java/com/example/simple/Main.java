package com.example.simple;

import com.example.simple.model.TestModel;
import com.example.simple.mybatis.MybatisConfig;
import com.example.simple.mybatis.mapper.TestModelMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class Main {
    public static void main(String[] args) {
        MybatisConfig mybatisConfig = new MybatisConfig();
        SqlSessionFactory sqlSessionFactory = mybatisConfig.buildSqlSessionFactory("1");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestModel select = sqlSession.getMapper(TestModelMapper.class).select(1);
        System.out.printf(select.toString());
        SqlSessionFactory sqlSessionFactory1 = mybatisConfig.buildSqlSessionFactory("2");
        SqlSession sqlSession1 = sqlSessionFactory1.openSession();
        TestModel select1 = sqlSession1.getMapper(TestModelMapper.class).select(1);
        System.out.printf(select1.toString());
    }
}