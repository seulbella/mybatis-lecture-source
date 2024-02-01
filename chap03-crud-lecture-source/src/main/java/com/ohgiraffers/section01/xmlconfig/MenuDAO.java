package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
        /* 메소드의 첫번째 인자로 어떠한 sql 구문을 수행할 것인지 전달한다.
        * mapper의 namespace와 id를 통해서 구분한다. */
        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }
}
