/*==============================================================*/
/* Table: Employees                                             */
/*==============================================================*/
insert into Employees (firstName, lastName, phoneNumber, email, salary, role, password, username)
values ('Christiano', 'Ronaldo', '+421905123456', 'test@gmail.com', '1000000$', 'TEAM_LEADER', 'testPassword', 'C7'),
       ('John', 'Smith', '+421905123480', 'test2@gmail.com', '50000$', 'PM', 'testPassword2', 'Jo'),
       ('Michael', 'Jackson', '+421905123400', 'test3@gmail.com', '5000$', 'DEVELOPER', 'testPassword3', 'Mike'),
       ('Leonardo', 'DiCaprio', '+421905123450', 'test4@gmail.com', '5000$', 'SCIENTIST', 'testPassword4', 'Leo'),
       ('Brad', 'Pitt', '+421905123455', 'test5@gmail.com', '10000$', 'ENGINEER', 'testPassword5', 'Brad');

/*==============================================================*/
/* Table: Projects                                              */
/*==============================================================*/
insert into Projects (name, abbreviation, customer)
values ('Dokazovi', 'DKZ', 'SoftServe'),
       ('CarRentalSystem', 'CRS', 'DevPlus'),
       ('MarketPlace', 'MP', 'EPAM');