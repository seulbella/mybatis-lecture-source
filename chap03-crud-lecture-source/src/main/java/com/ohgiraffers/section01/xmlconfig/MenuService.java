package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;
import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSesstion;

import java.util.List;

public class MenuService {

    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSesstion();

        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

        sqlSession.close();

        return menuList;
    }
}
