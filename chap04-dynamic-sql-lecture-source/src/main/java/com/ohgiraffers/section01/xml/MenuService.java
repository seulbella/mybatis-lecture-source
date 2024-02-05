package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    private DynamicSqlMapper dynamicSqlMapper;
    public void selectMenuByPrice(int price) {

        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        /* 기본 자료형 타입으로는 if 조건문의 값을 비교할 수 없으므로 Map 타입으로 가공해서 전달한다.
        * (Map의 경우 key 값, DTO 객체의 경우 getter를 이용하여 값이 확인된다.) */
        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);

        List<MenuDTO> menuList = dynamicSqlMapper.selectMenuByPrice(map);

        if(menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }

        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = dynamicSqlMapper.searchMenu(searchCriteria);

        if(menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = dynamicSqlMapper.searchMenuBySupCategory(searchCriteria);

        if(menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuByRandomMenuCode(Set<Integer> randomMenuCodeList) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, Set<Integer>> criteria = new HashMap<>();
        criteria.put("randomMenuCodeList", randomMenuCodeList);
        List<MenuDTO> menuList = dynamicSqlMapper.searchMenuByRandomMenuCode(criteria);

        if(menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = dynamicSqlMapper.searchMenuByNameOrCategory(criteria);

        if(menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }

        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> criteria) {

        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        int result = dynamicSqlMapper.updateMenu(criteria);

        if(result > 0) {
            sqlSession.commit();
            System.out.println("메뉴 정보 변경에 성공하였습니다.");
        } else {
            sqlSession.rollback();
            System.out.println("메뉴 정보 변경에 실패하였습니다.");
        }

        sqlSession.close();

    }
}














