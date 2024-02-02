package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
        /* 메소드의 첫번째 인자로 어떠한 sql 구문을 수행할 것인지 전달한다.
        * mapper의 namespace와 id를 통해서 구분한다. */
        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {
        /* 메소드의 두번째 인자로 sql 구문을 수행할 때 필요한 값을 전달한다. */
        return sqlSession.selectOne("MenuMapper.selectMenuByMenuCode", menuCode);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int menuCode) {

        return sqlSession.delete("MenuMapper.deleteMenu", menuCode);
    }
}
