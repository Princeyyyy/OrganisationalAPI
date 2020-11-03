CREATE DATABASE orgapi;

\c orgapi

CREATE TABLE news(
    id SERIAL PRIMARY KEY,
    title VARCHAR,
    content VARCHAR,
    departmentId INTEGER
);

CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    userPosition VARCHAR,
    role VARCHAR,
    departmentId INTEGER
);

CREATE TABLE departments(
    id SERIAL PRIMARY KEY,
    departmentName VARCHAR,
    description VARCHAR
);