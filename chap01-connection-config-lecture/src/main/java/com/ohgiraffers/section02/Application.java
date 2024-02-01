package com.ohgiraffers.section02;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {

    public static void main(String[] args) {

        String resource = "mybatis-config.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(false);
            /* mapper.xml 파일의 namespace와 select 태그의 id를 통해 찾아온다.
            * namespace.id */
            java.util.Date date = sqlSession.selectOne("mapper.selectDate");
            System.out.println(date);

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
