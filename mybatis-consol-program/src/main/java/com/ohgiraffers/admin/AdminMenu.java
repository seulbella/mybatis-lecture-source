package com.ohgiraffers.admin;

import com.ohgiraffers.admin.categoryManager.view.CategoryMenu;

import java.util.Scanner;

public class AdminMenu {

    public void adminDisplayMenu() {
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("========== 관리자 메뉴 ==========");
            System.out.println("1. 카테고리 관리 메뉴");
            System.out.println("9. 이전 메뉴로");
            System.out.println("원하는 관리자 메뉴 번호를 선택하세요");
            System.out.print("=> ");
            int selectMenu = sc.nextInt();

            switch (selectMenu) {
                case 1 : new CategoryMenu().adminCategoryDisplayMenu(); break;
                case 9 :
                    System.out.println("이전 메뉴로"); return;
                default:
                    System.out.println("잘못된 번호입니다. 다시 입력하세요.");
            }
        } while (true);
    }

}
