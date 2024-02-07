package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    public void printAllProductList(List<ProductDTO> allProductList) {

        System.out.println("=========전체 제품 정보 목록==========");
        for(ProductDTO product : allProductList) {
            System.out.println(product);
        }
        System.out.println("===================================");

    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

        String searchOption = "";
        switch (searchCondition.getOption()) {
            case "productName" : searchOption = "제품명 검색 결과"; break;
            case "salesStore" : searchOption = "판매처 검색 결과"; break;
            case "newProduct" : searchOption = "이달의 신제품 회원"; break;
            case "nonProduction" : searchOption = "생산 중단 제품"; break;
        }

        System.out.println("=========" + searchOption + " 목록==========");
        for(ProductDTO product : productList) {
            System.out.println(product);
        }
        System.out.println("=====================================");

    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";

        switch (successCode) {
            case "registProduct" : successMessage = "신규 제품을 등록하였습니다. 환영합니다!"; break;
            case "modifyProduct" : successMessage = "제품 정보를 수정하였습니다. 감사합니다!"; break;
            case "deleteProduct" : successMessage = "제품 정보를 삭제하였습니다. 수고하셨습니다."; break;
        }

        System.out.println(successMessage);
        System.out.println("===================================");

    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";

        switch (errorCode) {
            case "selectAllProductList" : errorMessage = "조회 결과가 없습니다. (about 전체 제품 정보 목록 조회)"; break;
            case "selectProductList" : errorMessage = "조회 결과가 없습니다. (about 선택 제품 정보 조회)"; break;
            case "registProduct" : errorMessage = "신규 제품 등록을 실패하였습니다. 다시 시도해 주세요."; break;
            case "modifyProduct" : errorMessage = "제품 정보 수정을 실패하였습니다. 다시 시도해 주세요."; break;
            case "deleteProduct" : errorMessage = "제품 정보 삭제를 실패하였습니다. 다시 시도해 주세요."; break;
        }

        System.out.println(errorMessage);
        System.out.println("===================================");

    }


}
