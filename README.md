# Myworkout-api
An app to track exercise progress. [Spring Boot] [Maven] [H2] [Flyway] [Security: Api Key]

## About

This is a simple api of application for tracking your exercises with 
**[Spring Boot](https://spring.io/projects/spring-boot)**
The backend of API is complete and secured via API key.



## Requirements
This demo is build with with Maven 3.6.x and Java 11

## Usage
Just start the application with the Spring Boot maven plugin (`mvn spring-boot:run`). The application is
running at [http://localhost:8080]

You can use the **H2-Console** for exploring the database under [http://localhost:8080/h2console](http://localhost:8080/h2console):


## Backend

There are three user accounts present to demonstrate the different levels of access to the endpoints in the API and the different authorization exceptions:

```
Admin - m:123
User - z:123
Disabled - disabled:123 (this user is deactivated)
```
Endpoints for :
```
GET:
- In response you will get list of tasks boards given user.


POST:
 By this endpoint you can add new tasks board.

PATCH:


DELETE:


```

Endpoints for :
```
GET:
- In response you will get list of tasks boards given user.


POST:
 By this endpoint you can add new tasks board.

PATCH:


DELETE:



## Copyright and license

The code is released under the [MIT license](LICENSE?raw=true).
