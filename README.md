# Rabobank Assignment for Authorizations Area

## Background Information

A Power of Attorney is used when someone (grantor) wants to give access to his/her account to someone else (grantee).
This could be read access or write access. In this way the grantee can read/write in the grantors account.
Notice that this is a simplified version of reality.

## What's inside

This is a working application which contains:
* Application structure
* Dependencies and configuration
* Swagger implementation
* Prometheus
* Docker setup
* Integration and unit test.

### Modules

This application service contains 3 modules as following:

#### API

* This module contains configurations, rest controllers and also connect the other two modules

#### Data

* This module contains Mongo DB configuration, repositories, mappers, dao implementations and database models.

#### Domain

* This module contains services, enums and DTOs.

### Dependencies

* lombok
* Validation
* Spring Security
* Mongo DB
* Open UI - Swagger
* Actuator and Prometheus
* JWT

## Setup

### Installation
* Setup JDK 11
```shell script
sudo apt install default-jdk
```

### Building and deploying the application
The project uses Maven as a build tool.
1. Clean, Build and run tests
```shell script
mvn clean install
```

2. Run with Docker
```shell script
docker-compose up
```

### API Documentation
```shell script
http://localhost:8080/swagger-ui.html
```

### Application Metrics
```shell script
http://localhost:8080/management/prometheus
```

### Rest API Endpoints

The following are the rest APIs:

* #### Authentication
```shell script
Post Request: http://localhost:8080/api/authenticate
```

* #### Create Account
```shell script
Post Request: http://localhost:8080/api/accounts
```

* #### Create Power of Attorney
```shell script
Post Request: http://localhost:8080/api/powerofattorney
```

* #### Get Power of Attorney of User
```shell script
Get Request: http://localhost:8080/api/powerofattorney
```