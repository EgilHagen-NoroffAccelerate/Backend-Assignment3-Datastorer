# Assignment3

[![standard-readme compliant](https://img.shields.io/badge/standard--readme-OK-green.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)

# Movie Character Data Management System

### Authors
- [Lucas Tran](https://github.com/lucastrann)
- [Egil Hagen](https://github.com/egilhagen)

## Project Overview
This project is part of the Java Fullstack course at Noroff Accelerate. It involves the development of a PostgreSQL database using Hibernate and the deployment of a Web API to interact with the database.

## Technological Requirements
The development environment for this project includes the following tools and technologies:
- IntelliJ with Java 17
- Spring Web, Spring Data JPA, PostgreSQL, Lombok
- PostgreSQL with PgAdmin
- Docker for environment replication

## Business Rules

### Characters and Movies
- One movie contains many characters.
- A character can play in multiple movies.

### Movies and Franchises
- Each movie belongs to one franchise.
- A franchise can contain many movies.

## Data Requirements
The following entities are part of the database:

### Character
- Auto-incremented Id
- Full name
- Alias (if applicable)
- Gender
- Picture (URL to a photo, not stored as an image)

### Movie
- Auto-incremented Id
- Movie title
- Genre (comma-separated genres)
- Release year
- Director (string name)
- Picture (URL to a movie poster)
- Trailer (YouTube link)

### Franchise
- Auto-incremented Id
- Name
- Description

## Seeding
The database has been seeded with initial data using Spring's data.sql.

## Web API

### Generic CRUD
- Full CRUD operations are available for Movies, Characters, and Franchises.

### Updating Related Data
- Dedicated endpoints for updating characters in a movie and movies in a franchise.
- These endpoints allow efficient updates of relationships between entities.

### Reporting
- The application provides the following reports for getting all franvhises, movies and characters. 


## Documentation with Swagger
Open API has been created to assist users in understanding and interacting with the API endpoints.

## Maintainers

[@nicholaslennox](https://github.com/nicholaslennox)




