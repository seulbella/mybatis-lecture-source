package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.jdbc.SQL;

public class SelectBuilderProvider {

    /* SQL을 문자열 형태로 반환하는 메소드 */
    public String selectAllMenu() {

        return new SQL()
                .SELECT("menu_code")
                .SELECT("menu_name")
                .SELECT("menu_price")
                .SELECT("category_code")
                .SELECT("orderable_status")
                .FROM("tbl_menu")
                .WHERE("orderable_status = 'Y'")
                .toString();

    }

    public String searchMenuByNameOrCategory(SearchCriteria searchCriteria) {
        SQL sql = new SQL();

        sql.SELECT("menu_code")
                .SELECT("menu_name")
                .SELECT("menu_price")
                .SELECT("category_code")
                .SELECT("orderable_status")
                .FROM("tbl_menu");

        if("category".equals(searchCriteria.getCondition())) {
            sql.JOIN("tbl_category USING (category_code)")
                    .WHERE("orderable_status = 'Y'")
                    .AND()
                    .WHERE("category_name = #{ value }");
        } else if("name".equals(searchCriteria.getCondition())) {
            /* 가변인자를 이용하면 자동으로 AND로 조건이 처리되므로 OR()는 별도로 메소드를 사용해야 한다. */
            sql.WHERE("orderable_status = 'Y'", "menu_name LIKE CONCAT('%', #{ value }, '%')");
        }

        return sql.toString();
    }




}
