package com.ohgiraffers.section03.remix;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSesstion() {

        if(sqlSessionFactory == null) {
            Environment environment = new Environment(
                    "dev",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(DRIVER, URL, USER, PASSWORD));

            Configuration configuration = new Configuration(environment);

            configuration.addMapper(MenuMapper.class);

            /* 아래는 컬럼명은 underscore 표기법으로 되어 있고 필드명은 camelcase 표기법으로 되어있는데
            * 해당 내용을 자동 매핑할 수 있는 메소드이다. */
//            configuration.setMapUnderscoreToCamelCase(true);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            }

        return sqlSessionFactory.openSession(false);
    }
}
