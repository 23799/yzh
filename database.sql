CREATE DATABASE IF NOT EXISTS farm_db CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE farm_db;

CREATE TABLE IF NOT EXISTS land(
    id INT PRIMARY KEY AUTO_INCREMENT,
    landName VARCHAR(50),
    area VARCHAR(20),
    soilType VARCHAR(30),
    farmer VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS crop(
    id INT PRIMARY KEY AUTO_INCREMENT,
    landId INT,
    cropName VARCHAR(50),
    sowTime DATE,
    cycle VARCHAR(30),
    output VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    pwd VARCHAR(255)
);

INSERT INTO user(username,pwd) VALUES('admin','123456');
