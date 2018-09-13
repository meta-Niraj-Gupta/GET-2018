CREATE DATABASE employeePortal;

USE employeePortal;

CREATE TABLE employee(
empCode INT AUTO_INCREMENT PRIMARY KEY,
firstName VARCHAR(25) NOT NULL,
lastName VARCHAR(25) NOT NULL,
dob DATE NOT NULL,
gender VARCHAR(6) NOT NULL,
priamryContact VARCHAR(12) NOT NULL,
secondaryContact VARCHAR(12),
emailId VARCHAR(25) NOT NULL UNIQUE,
skypeId VARCHAR(25) UNIQUE,
profilePicture VARCHAR(50),
password VARCHAR(20) NOT NULL,
isActive BOOLEAN DEFAULT TRUE
);


CREATE TABLE jobTitleMaster(
jobCode INT AUTO_INCREMENT PRIMARY KEY,
jobTitle VARCHAR(25) NOT NULL UNIQUE
);

CREATE TABLE userRoles(
userRoleId INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(25) NOT NULL,
role VARCHAR(25) NOT NULL UNIQUE
);

CREATE TABLE skillsMaster(
skillId INT PRIMARY KEY AUTO_INCREMENT,
skillName VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE employeeSkills(
skillId INT PRIMARY KEY AUTO_INCREMENT,
empCode INT NOT NULL,
skillCode int NOT NULL,
FOREIGN KEY (skillCode) REFERENCES skillsMaster(skillId),
FOREIGN KEY (empCode) REFERENCES employee(empCode)
);

CREATE TABLE project(
projectId INTEGER PRIMARY KEY AUTO_INCREMENT,
description VARCHAR(100) NOT NULL,
startDate DATE NOT NULL,
endDate DATE,
projectLogo VARCHAR(50)
);

CREATE TABLE address(
addressId INTEGER PRIMARY KEY AUTO_INCREMENT,
empCode INT NOT NULL,
addLine1 VARCHAR(25) NOT NULL,
addLine2 VARCHAR(25),
city VARCHAR(25) NOT NULL,
state VARCHAR(25) NOT NULL,
pincode VARCHAR(25) NOT NULL,
FOREIGN KEY (empCode) REFERENCES employee(empCode)
);

CREATE TABLE jobDetails (
empCode int NOT NULL,
jobDetailId INTEGER PRIMARY KEY AUTO_INCREMENT,
dateOfJoining DATE NOT NULL,
totalExp SMALLINT NOT NULL,
jobCode INT NOT NULL,
reportingManager int,
teamLead INT,
currProjId INTEGER,
FOREIGN KEY (empCode) REFERENCES employee(empCode),
FOREIGN KEY (jobCode) REFERENCES jobTitleMaster(jobCode),
FOREIGN KEY (reportingManager) REFERENCES employee(empCode),
FOREIGN KEY (teamLead) REFERENCES employee(empCode),
FOREIGN KEY (currProjId) REFERENCES project(projectId)
);

SHOW tables;