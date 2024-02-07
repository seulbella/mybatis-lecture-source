package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();
        do {
            System.out.println("===== Mapper Element 테스트 메뉴 =====");
            System.out.println("1. <cache> 테스트");
            System.out.println("2. <resultMap> 테스트");
            System.out.println("3. <sql> 테스트");
            System.out.println("4. <insert> 테스트");
            System.out.print("메뉴 번호를 입력 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : elementTestService.selectCacheTest(); break;
                case 2 : resultMapSubMenu(); break;
                case 3 : elementTestService.selectSqlTest(); break;
                case 4 : elementTestService.insertCategoryAndMenuTest(inputMenuAndCategory()); break;
            }
        } while(true);
    }

    private static MenuAndCategoryDTO inputMenuAndCategory() {
        Scanner sc = new Scanner(System.in);

        System.out.print("신규 카테고리명 : ");
        String categoryName = sc.nextLine();

        System.out.print("신규 메뉴명 : ");
        String menuName = sc.nextLine();
        System.out.print("신규 메뉴 가격 : ");
        int menuPrice = sc.nextInt();
        System.out.print("판매 등록 여부(Y/N) : ");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(categoryName);

        MenuAndCategoryDTO menuAndCategoryDTO = new MenuAndCategoryDTO();
        menuAndCategoryDTO.setMenuName(menuName);
        menuAndCategoryDTO.setMenuPrice(menuPrice);
        menuAndCategoryDTO.setOrderableStatus(orderableStatus);
        menuAndCategoryDTO.setCategory(categoryDTO);

        return menuAndCategoryDTO;
    }

    private static void resultMapSubMenu() {
        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();
        do {
            System.out.println("===== <resultMap> 서브 메뉴 =====");
            System.out.println("1. <resultMap> 테스트");
            System.out.println("2. <constructor> 테스트");
            System.out.println("3. <association> 테스트");
            System.out.println("4. <collection> 테스트");
            System.out.print("메뉴 번호를 입력 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : elementTestService.selectResultMapTest(); break;
                case 2 : elementTestService.selectResultMapConstructorTest(); break;
                case 3 : elementTestService.selectResultMapAssociationTest(); break;
                case 4 : elementTestService.selectResultMapCollectionTest(); break;
            }
        } while(true);
    }
}










