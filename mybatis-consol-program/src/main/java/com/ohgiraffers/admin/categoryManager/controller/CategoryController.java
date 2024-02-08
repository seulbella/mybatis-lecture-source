package com.ohgiraffers.admin.categoryManager.controller;

import com.ohgiraffers.admin.categoryManager.model.dto.CategoryDTO;
import com.ohgiraffers.admin.categoryManager.model.service.CategoryService;
import com.ohgiraffers.admin.categoryManager.view.CategoryPrint;
import com.ohgiraffers.common.SearchCondition;

import java.util.List;
import java.util.Map;

public class CategoryController {

    /* SERVICE */
    private CategoryService categoryService = new CategoryService();

    /* VIEW */
    private CategoryPrint categoryPrint = new CategoryPrint();

    /* 카테고리 전체 조회 */
    public List<CategoryDTO> selectAllCategoryList(){
        List<CategoryDTO> categoryList = categoryService.selectAllCategoryList();

        if ( categoryList != null ) {
            categoryPrint.printAllCategoryList(categoryList);
        } else {
            categoryPrint.printErrorMessage("selectAllCategoryList");
        }

        return categoryList;
    }

    /* 카테고리 부분 검색 조회 */
    public void selectCategoryByCondition(SearchCondition searchCondition){

        List<CategoryDTO> categoryList = categoryService.selectCategoryByCondition(searchCondition);

        if(categoryList != null && !categoryList.isEmpty()){
            categoryPrint.printCategoryList(categoryList, searchCondition);
        } else {
            categoryPrint.printErrorMessage("selectCategoryList");
        }

    }

    /* 카테고리 추가 */
    public void addNewCategory(CategoryDTO categoryDTO) {

        if(categoryService.addNewCategory(categoryDTO)){
            categoryPrint.printSuccessMessage("insert");
        } else {
            categoryPrint.printErrorMessage("insert");
        }
    }

    /* 카테고리 수정 */
    public void modifyCategory(CategoryDTO categoryDTO) {

        if(categoryService.modifyCategory(categoryDTO)){
            categoryPrint.printSuccessMessage("update");
        } else {
            categoryPrint.printErrorMessage("update");
        }
    }

    /* 카테고리 삭제 */
    public void deleteCategory(Map<String, String> parameter) {

        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        if (categoryService.deleteCategory(categoryCode)) {
            categoryPrint.printSuccessMessage("delete");
        } else {
            categoryPrint.printErrorMessage("delete");
        }
    }
}
