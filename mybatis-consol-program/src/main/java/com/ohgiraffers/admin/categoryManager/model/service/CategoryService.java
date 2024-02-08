package com.ohgiraffers.admin.categoryManager.model.service;

import com.ohgiraffers.admin.categoryManager.model.dao.CategoryDAO;
import com.ohgiraffers.admin.categoryManager.model.dto.CategoryDTO;
import com.ohgiraffers.common.SearchCondition;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class CategoryService {
    private CategoryDAO categoryDAO;

    /* 카테고리 전체 조회 */
    public List<CategoryDTO> selectAllCategoryList() {
        SqlSession sqlSession = getSqlSession();
        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        List<CategoryDTO> categoryList = categoryDAO.selectAllCategoryList();

        sqlSession.close();
        return categoryList;
    }

    /* 카테고리 검색 조회 */
    public List<CategoryDTO> selectCategoryByCondition(SearchCondition searchCondition) {
        SqlSession sqlSession = getSqlSession();
        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        List<CategoryDTO> categoryList = categoryDAO.selectCategoryByCondition(searchCondition);

        sqlSession.close();
        return categoryList;

    }

    /* 카테고리 추가 */
    public boolean addNewCategory(CategoryDTO categoryDTO) {
        SqlSession sqlSession = getSqlSession();
        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        int result = categoryDAO.insertCategory(categoryDTO);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }

    /* 카테고리 수정 */
    public boolean modifyCategory(CategoryDTO categoryDTO) {
        SqlSession sqlSession = getSqlSession();
        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        int result = categoryDAO.updateCategory(categoryDTO);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }

    /* 카테고리 삭제 */
    public boolean deleteCategory(int categoryCode) {
        SqlSession sqlSession = getSqlSession();
        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        int result = categoryDAO.deleteCategory(categoryCode);
        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }

}
