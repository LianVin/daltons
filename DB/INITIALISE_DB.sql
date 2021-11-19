CREATE DATABASE DALTONS;

USE DALTONS;
-- CREATE TABLES
-- CREATE USER
CREATE TABLE USER (
	USER_ID INT AUTO_INCREMENT PRIMARY KEY,
	USERNAME VARCHAR(255) NOT NULL,
	FIRST_NAME VARCHAR(255) NOT NULL,
	LAST_NAME VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    ROLE_ID INT NOT NULL
);

CREATE TABLE ROLE (
	ROLE_ID INT AUTO_INCREMENT PRIMARY KEY,
    ROLE VARCHAR(255) NOT NULL
);

-- CREATE COMPARISONFOLDER
CREATE TABLE POST (
    POST_ID INT AUTO_INCREMENT PRIMARY KEY,
    TITLE VARCHAR(255) NOT NULL,
    TEXT VARCHAR(280),
    IS_CONCERT BOOLEAN,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    USER_ID INT
);

-- CREATE ITEM
CREATE TABLE PICTURE (
	PICTURE_ID INT AUTO_INCREMENT PRIMARY KEY,
	URL VARCHAR(255) NOT NULL,
    DESCRIPTION VARCHAR(255),
    POST_ID INT NOT NULL
 );
 
 CREATE TABLE COMMENT (
	COMMENT_ID INT AUTO_INCREMENT PRIMARY KEY,
    TEXT VARCHAR(280) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    POST_ID INT NOT NULL,
    USER_ID INT
 );

 -- CREATE FOREING KEYS
-- Einsatz --> Projekt
ALTER TABLE USER ADD CONSTRAINT FK_USER_ROLE FOREIGN KEY (ROLE_ID) REFERENCES ROLE(ROLE_ID);
ALTER TABLE POST ADD CONSTRAINT FK_POST_USER FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID);
ALTER TABLE PICTURE ADD CONSTRAINT FK_PICTURE_POST FOREIGN KEY (POST_ID) REFERENCES POST(POST_ID);
ALTER TABLE COMMENT ADD CONSTRAINT FK_COMMENT_POST FOREIGN KEY (POST_ID) REFERENCES POST(POST_ID);
ALTER TABLE COMMENT ADD CONSTRAINT FK_COMMENT_USER FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID);

COMMIT;
-- DATABASE SHOULD NOW BE WORKING

