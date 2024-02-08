package com.ohgiraffers.admin.categoryManager.view;

import com.ohgiraffers.admin.categoryManager.model.dto.CategoryDTO;
import com.ohgiraffers.common.SearchCondition;

import java.util.List;

public class CategoryPrint {
    public void printAllCategoryList(List<CategoryDTO> allCategoryList) {
        System.out.println("===== 카테고리 목록 =====");
        for (CategoryDTO categoryDTO : allCategoryList) {
            System.out.println(categoryDTO);
        }
    }

    public void printCategoryList(List<CategoryDTO> categoryList, SearchCondition searchCondition) {

        String searchOption = "";
        switch (searchCondition.getOption()) {
            case "categoryCode":
                searchOption = "카테고리 코드로 검색한 결과";
                break;
            case "categoryName":
                searchOption = "카테고리명으로 검색한 결과";
                break;
        }

        System.out.println("========== " + searchOption + "목록 ==========");
        for (CategoryDTO categoryDTO : categoryList) {
            System.out.println(categoryDTO);
        }

        System.out.println("==================================");

    }


    public void printSuccessMessage(String successCode) {

        System.out.println("===== SUCCESS =====");

        String successMessage = "";
        switch (successCode) {
            case "insert" :
                successMessage = "신규 카테고리 등록을 완료했습니다."; break;
            case "update" :
                successMessage = "카테고리 수정을 완료했습니다."; break;
            case "delete" :
                successMessage = "카테고리 삭제를 완료했습니다."; break;
        }

        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {

        System.out.println("===== ERROR =====");

        String errorMessage = "";
        switch (errorCode) {
            case "selectAllCategoryList":
                errorMessage = "카테고리 전체 조회가 실패했습니다."; break;
            case "selectCategoryList":
                errorMessage = "카테고리 부분 조회를 실패했습니다."; break;
            case "insert":
                errorMessage = "카테고리 신규 삽입을 실패했습니다."; break;
            case "update":
                errorMessage = "카테고리 수정을 실패했습니다."; break;
            case "delete" :
                errorMessage = "카테고리 삭제를 실패했습니다."; break;
        }

        System.out.println(errorMessage);
    }

}
