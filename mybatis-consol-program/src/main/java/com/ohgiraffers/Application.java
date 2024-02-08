package com.ohgiraffers;

import com.ohgiraffers.admin.AdminMenu;
import com.ohgiraffers.program.programManager.ProgramMenu;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        do {
            System.out.println("========== SNS 게시물 업로드 프로그램 ==========");
            System.out.println("1. 관리자 메뉴");
            System.out.println("2. 회원 메뉴");
            System.out.println("9. 프로그램 종료");
            System.out.println("원하시는 메뉴의 번호를 입력해주세요");
            System.out.print("=> ");

            Scanner sc = new Scanner(System.in);
            int selectMenu = sc.nextInt();

            switch (selectMenu) {
                case 1 : new AdminMenu().adminDisplayMenu(); break;
                case 2 : new ProgramMenu().programDisplayMenu(); break;
                case 9 :
                    System.out.println("프로그램을 종료합니다."); return;
                default:
                    System.out.println("잘못된 번호입니다. 다시 입력하세요.");
            }
        } while (true);
    }

}
