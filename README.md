## Description

Basic web application built using Spring boot + Angular.

Currently it renders a home page and register page. Submit button does not work due to issues 
with thymeleaf templating engine.

## Prerequsites 

### Install MySQL Server

* Download installation package [here](https://dev.mysql.com/downloads/mysql/)
* Install MySQL server
* run command to for mysql prompt `sudo /usr/local/mysql/bin/mysql --password`
* run command to create mysql user `create user 'nrlmysqladmin'@'%'
identified by 'ThePassword';`
* run command to create sample database **usersr** `create database users;`
* run command to allow new user to access **users** database `grant
all on users.* to 'nrlmysqladmin'@'%';`

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

Access web application at https://localhost:8080/home

