package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class SelectBuilderService {
    private SelectBuilderMapper selectBuilderMapper;
    public void testSimpleStatement() {

        SqlSession sqlSession = getSqlSession();
        selectBuilderMapper = sqlSession.getMapper(SelectBuilderMapper.class);

        List<MenuDTO> menuList = selectBuilderMapper.selectAllMenu();

        if(menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }

        sqlSession.close();
    }

    public void testDynamicStatement(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        selectBuilderMapper = sqlSession.getMapper(SelectBuilderMapper.class);

        List<MenuDTO> menuList = selectBuilderMapper.searchMenuByNameOrCategory(searchCriteria);

        if(menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }

        sqlSession.close();
    }
}
