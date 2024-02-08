package com.ohgiraffers.admin.categoryManager.model.dao;

import com.ohgiraffers.admin.categoryManager.model.dto.CategoryDTO;
import com.ohgiraffers.common.SearchCondition;

import java.util.List;

public interface CategoryDAO {
    List<CategoryDTO> selectAllCategoryList();

    List<CategoryDTO> selectCategoryByCondition(SearchCondition searchCondition);

    /* int를 반환하는 이유는 이 메서드들이 데이터베이스와 상호 작용하여 데이터를 추가, 수정 또는 삭제하기
    * 때문에 작업의 성공 여부를 호출한 측에 알려주는 것이다. 1이 반환되면 성공 아니면(0) 실패함. */
    int insertCategory(CategoryDTO categoryDTO);

    int updateCategory(CategoryDTO categoryDTO);

    int deleteCategory(int categoryCode);

}
