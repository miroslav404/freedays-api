# Freedays - API

## Setup
1. Download and install mySQL
2. Create table:
 - `sudo mysql --password`
 - `mysql> create database db_example; -- Create the new database`
 - `mysql> create user 'dbuser'@'localhost' identified by 'ChooseYourPassword'; -- Creates the user`
 - `mysql> grant all on db_example.* to 'dbuser'@'localhost'; -- Gives all the privileges to the new user on the newly created database`
3. Update **src/main/resources/application.properties** with newly created db info 

## Run
enter in terminal **./gradlew bootRun**

## Available Requests
<br />**GET all companies**<br />
curl -i -H 'Accept: application/json' http://localhost:8080/api/companies
<br />**CREATE company**<br />
curl -i -H "Content-Type: application/json" -X POST -d '{"name": "Undabot"}' http://localhost:8080/api/companies
<br />**GET company by id**<br />
curl -i -H 'Accept: application/json' http://localhost:8080/api/companies/{id}
<br />**UPDATE company by id**<br />
curl -i -H "Content-Type: application/json" -X PUT -d '{"name": "Learning Spring Boot"}' http://localhost:8080/api/companies/{id}
<br />**DELETE company by id**<br />
curl -i -X DELETE http://localhost:8080/api/companies/{id}