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

**Additional requirements**

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
- programming code documentation
- solution architecture
- the complexity of project delivery for assessment

Above all, the following will be negatively evaluated:

- the unstructuredness of the code or the lack of transparency of the code
- duplicate code in several places
- untreated or inappropriately treated errors
- failure to meet the requirements specified in the assignment

**Conditions**

1. Use of Java language in versions 8 and above.
2. The application must be able to be compiled using Ant, Maven or Gradle without errors.
3. Use of the Spring Boot framework, or Spring, Spring MVC or Spring Security and others.
4. Use of appropriate technologies for access to the DB.
5. The presentation layer can be programmed using the well-known technologies.
HTML, CSS, JS or also using libraries jQuery, Angular, React, Vue, ...
6. The solution must be compilable and executable from source codes.
7. Creation of simple (max 1-2 A4) documentation for the solution.