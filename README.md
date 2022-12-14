**Rest API Application for ICZ company. A simple web application for company project management.**

The example is aimed at verifying basic programming skills. Assumed
the solution time should not exceed one day.

Assignment

Create a simple web application for company project management.

1) Access to the application should be protected by a simple login process
(user name and password, simple form). 

2) After logging in, the list of projects is displayed to the user
and a menu with basic application operations: 

- list of projects; 
- new project; 
- editing project;
- deleting the project. 

It will be possible to map (add, remove) for the given project people who will work on the given project. 
It will also be possible to manage:

- add;
- subscribe; 
- edit the list of people in the application.

Project data that needs to be recorded:

- name, abbreviation, customer (string)

Data on people on the project:

- name, surname, role (number - PM, team leader, developer, ...)

The list of projects will be persistent. The data storage will be a relational embedded database
(H2, HSQL, ...)

All information related to individual projects and people should be displayed.

The application should be created in a three-layer architecture with separation of data, application and
presentation layer. The application should follow basic security principles which
they are intended to prevent unauthorized access to data.

Additional requirements

Create the application in the development environment of your choice. State the reasons for your use
of the chosen environment.

Design the application in such a way that it can be further developed - e.g.:

- replacing the data layer;
- FE or creating a REST API, etc., adding a separate table for records
customers, management of people's roles on the project, etc.

Evaluation method

Positively evaluated will be:

- compliance with the principles of object programming
- comprehensibility and structure of the code
- efficient and elegant procedures