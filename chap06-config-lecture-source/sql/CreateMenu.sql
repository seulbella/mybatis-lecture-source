create user ohgiraffers@'%' identified by 'ohgiraffers';

create database menu;

grant all privileges on menu.* to ohgiraffers@'%';

show grants for ohgiraffers@'%';