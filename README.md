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

There are three user accounts

```
Admin - relicoh:123
User - smucibucik:123
Moderator uiop:123
```
Endpoints for Body Part Controller:
```
GET:
/bodyParts - in response you will get list of body parts.
/bodyParts/{id} - in response you will get specific body part by id.
```

Endpoints for Exercise Controller:

```
GET:
/exercises/{id} - in response you will get specific exercise by id.
/exercises - in response you will get list of tasks boards given user.

POST:
/exercises - by this endpoint you can add new exercise.

PATCH:
/exercises/{id} - by this endpoint you can update specific exercise by id.

DELETE:
/exercises/{id} - by this endpoint you can delete specific exercise by id.
```


Endpoints for Exercise Photo Controller:

```
GET:
/exercises/{id}/photos - in response you will get list of exercise photos by exercise id.

POST:
/exercises/photos - by this endpoint you can add new exercise photo.

PATCH:
/exercises/{id}/photos - by this endpoint you can update exercise photo by id.

DELETE:
/exercises/{id}/photos - by this endpoint you can delete exercise photo by id.
```

Endpoints for Session Controller :

```
GET:
/sessions - in response you will get list of sessions.
/users/{userId}/sessions{sessionId} - in response you will get specific session.
/sessions/{id} - in response you will get specific session.

POST:
/sessions - by this endpoint you can add new session.

PATCH:
/sessions/{id} - by this endpoint you can update session by id.

DELETE:
/sessions/{id} - by this endpoint you can delete session by id.

```

Endpoints for Session Exercise Controller :

```
GET:
/sessions/{id}/exercises - in response you will get list of exercises by session id.

POST:
/sessions/{id}/exercises - by this endpoint you can add new exercise to specific session.

PATCH:
/sessions/{sessionId}/exercises/{exerciseId} - by this endpoint you can update specific exercise.

DELETE:
sessions/{sessionId}/exercises/{exerciseId} - by this endpoint you can delete specific exercise.

```


Endpoints for Training Controller:

```
GET:
/trainings - in response you will get list of trainings.
/trainings/{id} - in response you will get specific training bt id.

POST:
/trainings - by this endpoint you can add new training.

PATCH:
/trainings/{id} - by this endpoint you can update training by id.

DELETE:
/trainings/{id} - by this endpoint you can delete training by id.

```

Endpoints for Training Exercise Controller:

```
GET:
/trainings/{id}/exercises - in response you will get list of exercises by training id.

POST:
/trainings/{id}/exercises - by this endpoint you can add new exercise to specific training.

```

Endpoints for User Controller:

```
GET:
/users - in response you will get list of users.
/users/{user_id} - in response you will get specific user by id.

POST:
/users - by this endpoint you can add new user.

PATCH:
/users/{id} - by this endpoint you can update specific user.

DELETE:
/users/{id} - by this endpoint you can delete specific user.

```


Endpoints for User Photo Controller:

```
GET:
/users/photos - in response you will get list of photos.
/users/photos/{userPhoto_id} - in response you will get list of photos given user.


POST:
/users/photos - by this endpoint you can add new photo.

PATCH:
/users/photos/{id} - by this endpoint you can update photo by id.

DELETE:
/users/photos/{id} - by this endpoint you can delete photo by id.

```
## Copyright and license

The code is released under the [MIT license](LICENSE?raw=true).
