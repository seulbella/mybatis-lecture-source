package com.ohgiraffers.section03.remix;

import java.util.List;

public class PrintResult {
    public void printMenuList(List<MenuDTO> menuList) {
        System.out.println("===== 메뉴 목록 =====");
        for(MenuDTO menu : menuList) {
            System.out.println(menu);
        }
    }

    public void printMenu(MenuDTO menu) {
        System.out.println("===== 조회 된 메뉴 =====");
        System.out.println(menu);
    }

    public void printSuccessMessage(String successCode) {
        System.out.println("===== Success =====");
        String successMessage = "";
        switch (successCode) {
            case "insert" :
                successMessage = "신규 메뉴 등록이 완료 되었습니다."; break;
            case "update" :
                successMessage = "메뉴 수정이 완료되었습니다."; break;
            case "delete" :
                successMessage = "메뉴 삭제가 완료되었습니다."; break;
        }
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {
        System.out.println("===== Error =====");

        String errorMessage = "";
        switch (errorCode) {
            case "selectList" :
                errorMessage = "메뉴 목록 조회에 실패했습니다."; break;
            case "selectOne" :
                errorMessage = "해당하는 코드에 맞는 메뉴 조회에 실패했습니다"; break;
            case "insert" :
                errorMessage = "신규 메뉴 등록에 실패했습니다."; break;
            case "update" :
                errorMessage = "메뉴 수정에 실패했습니다."; break;
            case "delete" :
                errorMessage = "메뉴 삭제에 실패했습니다."; break;
        }

        System.out.println(errorMessage);

    }




}
