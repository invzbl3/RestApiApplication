drop table if exists employees;

drop table if exists projects;

/*==============================================================*/
/* Table: projects                                              */
/*==============================================================*/
create table projects
(
    name          varchar(100) not null,
    abbreviation  varchar(100) not null,
    customer      varchar(100) not null
) CHARACTER SET utf8;

/*==============================================================*/
/* Table: employees                                             */
/*==============================================================*/
create table employees
(
    firstName   varchar(100) not null,
    lastName    varchar(100) not null,
    phoneNumber varchar(100) not null,
    email       varchar(100) not null,
    salary      double       not null,
    role        varchar(100) not null,
    password    varchar(100) not null,
    username    varchar(100) not null
) CHARACTER SET utf8;