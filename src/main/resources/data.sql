/*==============================================================*/
/* Table: Employees                                             */
/*==============================================================*/
insert into Employees (id, first_name, last_name, phone_number, email, salary, role, password, username)
values (1, 'Christiano', 'Ronaldo', '+421905123456', 'test@gmail.com', 50000.00, 'TEAM_LEADER', 'testPassword', 'C7'),
       (2,'John', 'Smith', '+421905123480', 'test2@gmail.com', 40000.00, 'PM', 'testPassword2', 'Jo'),
       (3, 'Michael', 'Jackson', '+421905123400', 'test3@gmail.com', 30000.00, 'DEVELOPER', 'testPassword3', 'Mike'),
       (4, 'Leonardo', 'DiCaprio', '+421905123450', 'test4@gmail.com', 20000.00, 'SCIENTIST', 'testPassword4', 'Leo'),
       (5, 'Brad', 'Pitt', '+421905123455', 'test5@gmail.com', 10000.00, 'ENGINEER', 'testPassword5', 'Brad');

/*==============================================================*/
/* Table: Projects                                              */
/*==============================================================*/
insert into Projects (name, abbreviation, customer)
values ('Dokazovi', 'DKZ', 'SoftServe'),
       ('CarRentalSystem', 'CRS', 'DevPlus'),
       ('MarketPlace', 'MP', 'EPAM');