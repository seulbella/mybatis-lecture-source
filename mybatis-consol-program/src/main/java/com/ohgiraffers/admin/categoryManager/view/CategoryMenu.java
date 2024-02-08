package com.ohgiraffers.admin.categoryManager.view;

import com.ohgiraffers.admin.categoryManager.controller.CategoryController;
import com.ohgiraffers.admin.categoryManager.model.dto.CategoryDTO;
import com.ohgiraffers.common.SearchCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CategoryMenu {

    public void adminCategoryDisplayMenu() {
        Scanner sc = new Scanner(System.in);
        CategoryController categoryController = new CategoryController();

        do {
            System.out.println("========== 카테고리 관리 메뉴 ==========");
            System.out.println("1. 전체 카테고리 조회");
            System.out.println("2. 부분 카테고리 조회");
            System.out.println("3. 카테고리 추가");
            System.out.println("4. 카테고리 수정");
            System.out.println("5. 카테고리 삭제");
            System.out.println("9. 이전 메뉴로");
            System.out.println("원하시는 관리 메뉴 번호를 선택해주세요");
            System.out.print("=> ");

            int selectMenu = sc.nextInt();

            switch (selectMenu) {
                case 1 : categoryController.selectAllCategoryList(); break;
                case 2 :
                    SearchCondition searchCondition = inputSearchCondition();
                    if(searchCondition != null) categoryController.selectCategoryByCondition(searchCondition); break;
                case 3 : categoryController.addNewCategory(inputNewCategoryInfo()); break;
                case 4 : categoryController.modifyCategory(inputModifyCategoryInfo()); break;
                case 5 : categoryController.deleteCategory(inputDeleteCategoryInfo()); break;
                case 9 :
                    System.out.println("========상위 메뉴로 이동합니다.========"); return;
                default :
                    System.out.println("잘못된 번호입니다. 확인 후 다시 입력해주세요."); break;
            }

        } while (true);
    }

    /* 부분 검색 */
    private SearchCondition inputSearchCondition() {
        Scanner sc = new Scanner(System.in);
        String option = "";
        String value = "";

        System.out.println("=========================================");
        System.out.println("조회 하고 싶은 조건을 선택하세요.");
        System.out.println("=========================================");
        System.out.println("1. 카테고리 코드로 조회");
        System.out.println("2. 카테고리 이름으로 조회");
        System.out.println("9. 이전 메뉴로 ");
        System.out.println("=========================================");
        System.out.println("원하는 조건의 번호를 입력해주세요.");
        System.out.print("=> ");
        int selectMenu = sc.nextInt();

        switch (selectMenu) {
            case 1 :
                sc.nextLine();
                option = "categoryCode";
                System.out.println("조회할 카테고리 코드를 입력해주세요.");
                System.out.print("=> ");
                value = sc.nextLine();
                break;
            case 2 :
                sc.nextLine();
                option = "categoryName";
                System.out.println("조회할 카테고리 이름을 입력해주세요.");
                System.out.print("=> ");
                value = sc.nextLine();
                break;
            case 9 :
                System.out.println("========== 상위 메뉴로 이동합니다. =========="); return null;
            default :
                System.out.println("잘못된 번호입니다. 확인 후 다시 입력해주세요.");
        }

        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setOption(option);
        searchCondition.setValue(value);

        return searchCondition;

    } /* 부분 검색 end */

    /* 카테고리 등록 */
    private CategoryDTO inputNewCategoryInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("새로운 카테고리를 등록합니다");
        CategoryDTO categoryDTO = new CategoryDTO();
        getCategoryInfo(categoryDTO);
        System.out.println("=====================================");

        return categoryDTO;

    }
    private static CategoryDTO getCategoryInfo(CategoryDTO categoryDTO) {
        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("등록할 코드 번호를 입력하세요.");
        System.out.print("=> ");
        int categoryCode = sc.nextInt();
        sc.nextLine();

        System.out.println("등록할 카테고리명을 입력하세요");
        System.out.print("=> ");
        String categoryName = sc.nextLine();

        System.out.println("신규 플랫폼이면 null을, 해당하는 플랫폼이 있으면 그 코드를 입력하세요.");
        System.out.print("=> ");
        String refCategoryCodeStr = sc.nextLine();

        // 문자열을 정수로 변환
        Integer refCategoryCode = null;
        if (!refCategoryCodeStr.equals("null")) {
            refCategoryCode = Integer.parseInt(refCategoryCodeStr);
        }

        categoryDTO.setCategoryName(categoryName);
        categoryDTO.setCategoryCode(categoryCode);
        categoryDTO.setRefCategoryCode(refCategoryCode);

        return categoryDTO;

    } /* 카테고리 등록 end */

    /* 카테고리 수정 */
    private static CategoryDTO inputModifyCategoryInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("수정할 카테고리의 코드를 입력해주세요");
        System.out.print("=> ");
        int categoryCode = sc.nextInt();

        System.out.println("카테고리명을 입력해주세요.");
        System.out.print("=> ");
        sc.nextLine();
        String categoryName = sc.nextLine();

        System.out.println("구분할 플랫폼의 코드를 입력해주세요. (해당사항 없으면 null 값 입력)");
        System.out.print("=> ");
        String refCategoryCodeStr = sc.nextLine();

        CategoryDTO categoryDTO = new CategoryDTO();

        // 문자열을 정수로 변환
        Integer refCategoryCode = null;
        if (!refCategoryCodeStr.equals("null")) {
            refCategoryCode = Integer.parseInt(refCategoryCodeStr);
        }

        categoryDTO.setCategoryCode(categoryCode);
        categoryDTO.setCategoryName(categoryName);
        categoryDTO.setRefCategoryCode(refCategoryCode);

        return categoryDTO;
    } /* 카테고리 수정 end */

    /* 카테고리 삭제 */
    private static Map<String, String> inputDeleteCategoryInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("삭제할 카테고리 코드를 입력해주세요.");
        System.out.print("=> ");
        String categoryCode = sc.nextLine();
        System.out.println();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("categoryCode", categoryCode);

        return parameter;

    } /* 카테고리 삭제 end */

}
