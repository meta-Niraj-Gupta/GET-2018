DROP DATABASE IF EXISTS employee_portal;

CREATE DATABASE employee_portal;

USE employee_portal;

CREATE TABLE job_title(
   id INTEGER NOT NULL AUTO_INCREMENT,
   code VARCHAR(10) NOT NULL,
   title VARCHAR(30) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE skill(
   id INTEGER NOT NULL AUTO_INCREMENT,
   name VARCHAR(20) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE project(
   id INTEGER NOT NULL AUTO_INCREMENT,
   description VARCHAR(300) NOT NULL,
   start_date DATE NOT NULL,
   end_date DATE NOT NULL,
   project_logo VARCHAR(100) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE address(
   id INTEGER NOT NULL AUTO_INCREMENT,
   line_1 VARCHAR(100) NOT NULL,
   line_2 VARCHAR(100) NOT NULL,
   city INTEGER NOT NULL,
   state INTEGER NOT NULL,
   pincode INTEGER NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE employee(
   id INTEGER NOT NULL AUTO_INCREMENT,
   code VARCHAR(10),
   first_name VARCHAR(30) NOT NULL,
   middle_name VARCHAR(30),
   last_name VARCHAR(30) NOT NULL,
   dob DATE NOT NULL,
   gender CHAR NOT NULL,
   primary_contact VARCHAR(15) NOT NULL,
   secondary_contact VARCHAR(15) NOT NULL,
   email VARCHAR(50) NOT NULL,
   skype_id VARCHAR(30),
   profile_picture VARCHAR(100),
   password VARCHAR(50),
   address_id INTEGER NOT NULL,
   enabled BOOLEAN NOT NULL DEFAULT TRUE,
   is_admin BOOLEAN NOT NULL DEFAULT FALSE,
   PRIMARY KEY (id),
   FOREIGN KEY (address_id) REFERENCES address (id)
);

CREATE TABLE job_detail(
   id INTEGER NOT NULL AUTO_INCREMENT,
   employee_id INTEGER NOT NULL,
   doj DATE NOT NULL,
   experience INTEGER NOT NULL,
   job_title_id INTEGER NOT NULL,
   reporting_manager_id INTEGER NOT NULL,
   team_lead_id INTEGER NOT NULL,
   current_project_id INTEGER NOT NULL,
   PRIMARY KEY (id),
   FOREIGN KEY (employee_id) REFERENCES employee (id),
   FOREIGN KEY (job_title_id) REFERENCES job_title (id),
   FOREIGN KEY (team_lead_id) REFERENCES employee (id),
   FOREIGN KEY (reporting_manager_id) REFERENCES employee (id),
   FOREIGN KEY (current_project_id) REFERENCES project (id)
);