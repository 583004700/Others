-- Create table 用户表
create table USERS
(
  id        VARCHAR2(255) not null,
  user_name VARCHAR2(255),
  password  VARCHAR2(255),
  real_name VARCHAR2(255)
);
-- Create/Recreate primary, unique and foreign key constraints
alter table USERS
  add constraint USERS_ID primary key (ID);

-- Create table 类型表
create table TYPE
(
  id   VARCHAR2(255) not null,
  name VARCHAR2(255)
);
alter table TYPE
  add constraint TYPE_ID primary key (ID);

-- Create table 业务处室表
create table BUSINESS_CS
(
  id   VARCHAR2(255),
  name VARCHAR2(255)
);

-- Create/Recreate primary, unique and foreign key constraints
alter table BUSINESS_CS
  add constraint BUSINESS_CS_ID primary key (ID);

-- Create table 脚本表
create table SCRIPTS
(
  id             VARCHAR2(255) not null,
  title          VARCHAR2(255),
  context        CLOB,
  type_id        VARCHAR2(255),
  user_id        VARCHAR2(255),
  business_cs_id VARCHAR2(255)
);

alter table SCRIPTS
  add constraint SCRIPTS_ID primary key (ID);