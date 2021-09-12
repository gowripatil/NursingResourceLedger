## Description

Basic web application built using Spring boot for Rest APIs + Json Web Token for Authentication + Mysql for database + 
 Angular for front end.

Built the app using these references:
Spring boot + JWT + Mysql: https://www.netjstech.com/2021/02/spring-boot-spring-security-jwt-authentication.html
Angular: https://www.netjstech.com/2021/02/angular-spring-boot-jwt-authentication-login-example.html


Currently it renders a home page and register page. Submit button does not work due to issues 
with thymeleaf templating engine.

## Prerequsites 

### Install MySQL Server and tables

* Download installation package [here](https://dev.mysql.com/downloads/mysql/)
* Install MySQL server
* run command to for mysql prompt `sudo /usr/local/mysql/bin/mysql --password`
* run command to create mysql user `create user 'nrlmysqladmin'@'%'
identified by 'ThePassword';`
* run command to create sample database **nrl** `create database nrl;`
* run command to allow new user to access **nrl** database `grant
all on nursingresourceledger.* to 'nrlmysqladmin'@'%';`
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

# Installing Angular CLI

* run command to install angular CLI on mac
`npm install -g @angular/cli`


# Setting up project

* Clone NursingResource Legder repository
```
git clone https://github.com/gowripatil/NursingResourceLedger.git
```
* Open IDEA Intellij. Intellij installer can be found [here](https://www.jetbrains.com/idea/download/#section=mac)
* Import an existing project into Intellij.
* Lombok requires annotation processor: https://stackoverflow.com/questions/38911888/lombok-requires-annotation-processing


Run Server
* Go to Run -> Edit Configurations -> Click `+` button on the top left -> Select Spring boot
	* Set name as `NursingResourceLedgerApplication`
	* Set main class path to `com.cse682.nursingresourceledgerprototype.NursingResourceLedgerPrototype`
	* Check `Enable debug output`
	* Use defaults for the rest
	* Click `Apply` and `Ok`
	
* Go to Run -> Select `Run NursingResourceLedgerPrototypeApplication`

This runs rest apis at http://localhost:8080/home. Following are the rest apis
POST /auth/login - login a registered user. No authentication token required to access this page.
POST /auth/signup - register a new user as Admin or Nurse. No authentication token required to access this page.
GET /user/allusers - returns `Displays all users string`. Accessed by both nurse and admin. Dummy API
GET /user/displayuser - returns `Display only to nurse`. Accessed by nurse only. Dummy API.
GET /user/displayadmin - returns `Display only to admin`. Accessed by admin only.  Dummy API. 

# Starting Angular

* Go to `src/main/resources/nrl` folder and run `ng serve --open`

This starts angular application @ http://localhost:4200

