package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryAndMenuDTO;
import com.ohgiraffers.common.CategoryDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;
import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementTestService {

    private ElementTestMapper elementTestMapper;

    public void selectCacheTest() {

        SqlSession sqlSession = getSqlSession();
        elementTestMapper = sqlSession.getMapper(ElementTestMapper.class);

        /* 최초 요청 시에는 시간이 걸리지만 그 이후에는 캐싱 된 데이터를 불러오기 때문에 시간이 걸리지 않는다. */
        for(int i = 0; i < 10; i++) {
            Long startTime = System.currentTimeMillis();

            List<String> nameList = elementTestMapper.selectCacheTest();
            System.out.println(nameList);

            Long endTime = System.currentTimeMillis();

            Long interval = endTime - startTime;
            System.out.println("수행 시간 : " + interval + "(ms)");

        }

        sqlSession.close();

    }

    public void selectResultMapTest() {

        SqlSession sqlSession = getSqlSession();
        elementTestMapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = elementTestMapper.selectResultMapTest();
        menuList.forEach(System.out::println);

        sqlSession.close();
    }

    public void selectResultMapConstructorTest() {
        SqlSession sqlSession = getSqlSession();
        elementTestMapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = elementTestMapper.selectResultMapConstructorTest();
        menuList.forEach(System.out::println);

        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {
        SqlSession sqlSession = getSqlSession();
        elementTestMapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuAndCategoryDTO> menuList = elementTestMapper.selectResultMapAssociationTest();
        menuList.forEach(System.out::println);

        sqlSession.close();
    }

    public void selectResultMapCollectionTest() {
        SqlSession sqlSession = getSqlSession();
        elementTestMapper = sqlSession.getMapper(ElementTestMapper.class);

        List<CategoryAndMenuDTO> categoryList = elementTestMapper.selectResultMapCollectionTest();
        categoryList.forEach(System.out::println);

        sqlSession.close();
    }

    public void selectSqlTest() {
        SqlSession sqlSession = getSqlSession();
        elementTestMapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = elementTestMapper.selectSqlTest();
        menuList.forEach(System.out::println);

        sqlSession.close();
    }

    public void insertCategoryAndMenuTest(MenuAndCategoryDTO menuAndCategoryDTO) {
        SqlSession sqlSession = getSqlSession();
        elementTestMapper = sqlSession.getMapper(ElementTestMapper.class);

        int result1 = elementTestMapper.insertNewCategory(menuAndCategoryDTO);
        int result2 = elementTestMapper.insertNewMenu(menuAndCategoryDTO);

        if(result1 > 0 && result2 > 0) {
            sqlSession.commit();
            System.out.println("신규 카테고리와 신규 메뉴 등록 완료");
        } else {
            sqlSession.rollback();
            System.out.println("신규 카테고리와 신규 메뉴 등록 실패");
        }

        sqlSession.close();
    }
}














