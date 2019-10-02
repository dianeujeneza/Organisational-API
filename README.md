## Organisational Api
#### This is an application that can help a company to record user their departments and news of each department, 02/10/2019
#### By Diane Ujeneza
## Description
This is a web application that will help an organisation to save some of the datas such as their names, the departments they belong to and news 
of each department.
## Development server

Run `gradle run` for a dev server. Navigate to `http://localhost:4567/`. The app will automatically reload if you change any of the source files.
## Setup/Installation Requirements
Clone the repository to your local machine from the **[online repository]**
https://github.com/dianeujeneza/Organisational-API

If you already have git and java prerequisites installed in your machine continue to the next step,

If you do not have java in your system you can visit the java dev site and get the installation process and you will find some commands you can use on your terminal.

If you are not conversant on the usage of git you can visit https://github.com and clear guidelines on how to use git are outlined.

#### PostgresSQL for Database
       * CREATE DATABASE management;
       * \c management;
       * CREATE TABLE users (id SERIAL PRIMARY KEY, userName VARCHAR,departmentId);
       * CREATE TABLE departments (id SERIAL PRIMARY KEY,depName,depDescription);
       *CREATE TABLE department_news(departmentId,newsId);
       * CREATE DATABASE management_test WITH TEMPLATE management;

## Behavior Driven Development(BDD)

*INPUTS: -Names of the user
         -Their departments names
         -News of department
       
*OUTPUTS:Retrieved data from database
## Known Bugs
For now users cant'be able to view after inserting informations but they can view them in the database
## Technologies Used
JAVA,SPARK Framework,BOOTSTRAP,POSTGRES
## Support and contact details
If countered a problem please don't hesitate to email me on dianesis17@gmail.com.
### License
[UMD]
Copyright (c) {2019} Diane Ujeneza.