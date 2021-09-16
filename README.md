## Description

Basic web application built using Spring boot for Rest APIs + Json Web Token for Authentication + Mysql for database + 
 Angular for front end.

Built the app using these references:
Spring boot + JWT + Mysql: https://www.netjstech.com/2021/02/spring-boot-spring-security-jwt-authentication.html  
Angular: https://www.netjstech.com/2021/02/angular-spring-boot-jwt-authentication-login-example.html  

## Prerequsites 

### Install MySQL Server and tables

* Download installation package [here](https://dev.mysql.com/downloads/mysql/)
* Install MySQL server
* run command to for mysql prompt `sudo /usr/local/mysql/bin/mysql --password`
	* if working on Windows, you can also simply start a mysql command line client
* run command to create mysql user `create user 'nrlmysqladmin'@'%'
identified by 'ThePassword';`
* run command to create sample database **nrl** `create database nrl;`
* run command to allow new user to access **nrl** database `grant
all on nrl.* to 'nrlmysqladmin'@'%';`
* run command to create **users** table in **nrl** database
```$xslt
CREATE TABLE `nrl`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  `firstname` VARCHAR(30) NOT NULL,
  `lastname` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));
```
* run command to create **role** table in **nrl** database
```$xslt
CREATE TABLE `nrl`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
```
* run command to insert **Admin** and **Nurse** role into database
```$xslt
insert into nrl.role (name) values ("ROLE_ADMIN");
insert into nrl.role (name) values ("ROLE_NURSE");
```

* run command to create **user_role** table in **nrl** database
```$xslt
CREATE TABLE `nrl`.`user_role` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL);
```

* run commands to insert first admin user into **users** table 
```$xslt
insert into nrl.users (username, email, password, firstname, lastname) values ("username", "email", "password", "firstname", "lastname");
	* please be sure to put the actual data you desire for the admin user in the quotes above
insert into nrl.user_role (user_id, role_id) values (1, 1);
```

# Installing Angular CLI

* run command to install angular CLI in mac terminal or powershell
`npm install -g @angular/cli`
* this will require Node.js and npm which can be found [here](https://nodejs.org/en/download/)


# Setting up project

* Clone NursingResource Ledger repository
```
git clone https://github.com/gowripatil/NursingResourceLedger.git
```
* Open IDEA Intellij. Intellij installer can be found [here](https://www.jetbrains.com/idea/download/)
* Import an existing project into Intellij.


Run Server
* Go to Run -> Edit Configurations -> Click `+` button on the top left -> Select Spring boot
	* Set name as `NursingResourceLedgerApplication`
	* Set main class path to `com.cse682.nursingresourceledgerprototype.NursingResourceLedgerPrototypeApplication`
	* Check `Enable debug output`
	* Use defaults for the rest
	* Click `Apply` and `Ok`
	
* Go to Run -> Select `Run NursingResourceLedgerPrototypeApplication`

This runs rest apis at http://localhost:8080/home. Following are the rest apis:  
POST /auth/login - login a registered user. No authentication token required to access this page.    
POST /auth/signup - register a new user as Admin or Nurse. No authentication token required to access this page.

GET /auth/ledger/all -- returns all ledger info
POST /auth/ledger/add -- Adds a ledger entry
POST /auth/ledger/update -- Updates a ledger entry
JSONBody for ledger add/update
{
"id": 1,
"arrivalDate": "2020-10-10T07:00:00.000+00:00",
"arrivalRoom": "gh",
"purposeOfVisit": "asada",
"readmission": false,
"patientName": "testarossa",
"sex": "m",
"patientOrigin": "nrbas",
"lifeSavingDevices": "asdasd",
"transferLocation": "kilo",
"ventilatorSupport": true
}
# Starting Angular

* Go to `src/main/resources/nrl` folder and run `ng serve --open`

This starts angular application @ http://localhost:4200

