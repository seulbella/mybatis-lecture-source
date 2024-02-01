package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    /* SqlSessionFactory는 애플리케이션을 실행하는 동안 존재해야 하며
    * 애플리케이션이 실행되는 동안 여러 차례 SqlSesstionFactory를 다시 빌드하지 않는 것이 좋은 형태이다.
    * 애플리케이션 스코프로 관리하기 가장 간단한 방법은 싱글톤 패턴을 이용하는 것이다.
    * singleton : 오로지 1개의 객체만 생성
    * */
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSesstion() {

        /* 최초 실행 시 sqlSesstionFactory 객체가 없으면 생성하고 생성 된 뒤에는 if문에 진입하지 않는다. */
        if(sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                /* SqlSesstionFactoryBuilder를 SqlSessionFactory를 생성한 후에도 유지할 필요는 없다.
                * 따라서 메소드 스코프로 만든다. */
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /* SqlSession은 Thread에 안전하지 않고, 공유되지 않아야하므로 요청 시마다 생성한다. */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println("sqlSessionFactory.hashCode() : " + sqlSessionFactory.hashCode());
        System.out.println("sqlSession.hashCode() : " + sqlSession.hashCode());


        return sqlSession;
    }
}
