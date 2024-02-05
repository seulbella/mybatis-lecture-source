package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

public interface SqlBuilderMapper {

    @InsertProvider(type = SqlBuilderProvider.class, method = "insertMenu")
    int insertMenu(MenuDTO menuDTO);

    @UpdateProvider(type = SqlBuilderProvider.class, method = "updateMenu")
    int modifyMenu(MenuDTO menuDTO);

    /* Map 또는 getter가 있는 DTO를 사용할 때와 달리 기본 자료형 값을 전달하는 경우에는 param 어노테이션을 이용한다.
    * 또한 전달해야 하는 값이 2개 이상인 경우도 Param 어노테이션의 key 값으로 값을 찾을 수 있다.
    * 단, Provider 메소드의 매개변수 선언부는 없어야 한다.
    * */
    @DeleteProvider(type = SqlBuilderProvider.class, method = "deleteMenu")
    int deleteMenu(@Param("menuCode") int menuCode);
}










