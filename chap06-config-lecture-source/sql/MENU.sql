USE menu;

-- DROP TABLE `tbl_order`;
-- DROP TABLE `tbl_order_menu`;
-- DROP TABLE `tbl_payment`;
-- DROP TABLE `tbl_payment_order`;
-- DROP TABLE `tbl_menu`;
-- DROP TABLE `tbl_category`;

CREATE TABLE `tbl_category`
(
    `category_code`    MEDIUMINT  NOT NULL AUTO_INCREMENT COMMENT '카테고리코드',
    `category_name`    VARCHAR(30) NOT NULL COMMENT '카테고리명',
    `ref_category_code`    MEDIUMINT COMMENT '상위카테고리코드',
 PRIMARY KEY ( `category_code` ),
 FOREIGN KEY (`ref_category_code`) REFERENCES tbl_category (`category_code`)
)
 COMMENT = '카테고리';

CREATE TABLE `tbl_menu`
(
    `menu_code`    MEDIUMINT  NOT NULL AUTO_INCREMENT COMMENT '메뉴코드',
    `menu_name`    VARCHAR(30) NOT NULL COMMENT '메뉴명',
    `menu_price`    DECIMAL NOT NULL COMMENT '메뉴가격',
    `orderable_status`    CHAR(1) NOT NULL COMMENT '주문가능상태',
    `category_code`    MEDIUMINT NOT NULL COMMENT '카테고리코드',
 PRIMARY KEY ( `menu_code` ),
 FOREIGN KEY (`category_code`) REFERENCES tbl_category (`category_code`)
)
 COMMENT = '메뉴';

CREATE TABLE `tbl_order`
(
    `order_code`    MEDIUMINT  NOT NULL AUTO_INCREMENT COMMENT '주문코드',
    `order_date`    VARCHAR(8) NOT NULL COMMENT '주문일자',
    `order_time`    VARCHAR(8) NOT NULL COMMENT '주문시간',
    `total_order_price`    DECIMAL NOT NULL COMMENT '총주문금액',
 PRIMARY KEY ( `order_code` )
)
 COMMENT = '주문';

CREATE TABLE `tbl_order_menu`
(
    `order_code`    MEDIUMINT  NOT NULL COMMENT '주문코드',
    `menu_code`    MEDIUMINT NOT NULL COMMENT '메뉴코드',
    `order_amount`    DECIMAL NOT NULL COMMENT '주문수량',
 PRIMARY KEY ( `order_code`,`menu_code` ),
 FOREIGN KEY (`order_code`) REFERENCES tbl_order(`order_code`),
 FOREIGN KEY (`menu_code`) REFERENCES tbl_menu(`menu_code`)
)
 COMMENT = '주문별메뉴';

CREATE TABLE `tbl_payment`
(
    `payment_code`    MEDIUMINT  NOT NULL AUTO_INCREMENT COMMENT '결제코드',
    `payment_date`    VARCHAR(8) NOT NULL COMMENT '결제일',
    `payment_time`    VARCHAR(8) NOT NULL COMMENT '결제시간',
    `payment_price`    DECIMAL NOT NULL COMMENT '결제금액',
    `payment_type`    VARCHAR(6) NOT NULL COMMENT '결제구분',
 PRIMARY KEY ( `payment_code` )
)
 COMMENT = '결제';

CREATE TABLE `tbl_payment_order`
(
    `order_code`    DECIMAL NOT NULL COMMENT '주문코드',
    `payment_code`    DECIMAL NOT NULL COMMENT '결제코드',
 PRIMARY KEY ( `payment_code`,`order_code` )
)
 COMMENT = '결제별주문';

 
 INSERT INTO TBL_CATEGORY (category_name, ref_category_code) VALUES 
('식사', 1),
('음료', 2),
('디저트', 3),
('한식', 4),
('중식', 5);

INSERT INTO TBL_MENU (MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS) VALUES
('생마늘샐러드', 12000, 1, 'Y'),
('코다리마늘빵', 7000, 1, 'Y'),
('과메기커틀릿', 13000, 1, 'Y'),
('붕어빵초밥', 35000, 1, 'Y'),
('까나리코코넛쥬스', 9000, 2, 'Y'),
('흑마늘아메리카노', 9000, 2, 'Y'),
('열무김치라떼', 4500, 2, 'Y'),
('우럭스무디', 5000, 2, 'Y'),
('생갈치쉐이크', 6000, 2, 'Y'),
('갈릭미역파르페', 7000, 3, 'Y'),
('홍어마카롱', 9000, 3, 'Y'),
('정어리빙수', 10000, 3, 'Y'),
('날치알스크류바', 2000, 3, 'Y'),
('직화구이젤라또', 8000, 3, 'Y'),
('마라깐쇼한라봉', 22000, 3, 'Y'),
('돌미나리백설기', 5000, 3, 'Y'),
('민트미역국', 15000, 4, 'Y'),
('앙버터김치찜', 13000, 4, 'Y'),
('한우딸기국밥', 20000, 4, 'Y'),
('죽방멸치튀김우동', 11000, 5, 'Y'),
('아이스가리비관자육수', 6000, 5, 'Y');

commit;