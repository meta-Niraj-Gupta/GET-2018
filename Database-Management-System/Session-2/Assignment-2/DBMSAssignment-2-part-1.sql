/*
Creating database
*/

CREATE DATABASE storefront;

/*
Displaying database
*/

SHOW DATABASES;

/*
Using database storefront
*/

USE storefront;

/*
Creating product table
*/

CREATE TABLE Product(
product_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(100) NOT NULL,
price FLOAT NOT NULL,
stock INT NOT NULL,
description VARCHAR(100),
date_added DATE NOT NULL,
last_updated DATE NOT NULL
);

/*
Creating category table
*/

CREATE TABLE Category(
category_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
category_name VARCHAR(100) NOT NULL,
parent_category INT NOT NULL
);

/*
Creating product category relation table
*/

CREATE TABLE Product_Category_Relation(
category_id INT NOT NULL,
product_id int NOT NULL,
FOREIGN KEY(category_id) REFERENCES category(category_id),
FOREIGN KEY(product_id) REFERENCES product(product_id)
);

/*
Creating Product Image
*/

CREATE TABLE Product_image(
image_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
image_name VARCHAR(100) NOT NULL,
image_url VARCHAR(100) NOT NULL,
product_id INT,
FOREIGN KEY(product_id) REFERENCES product(product_id)
);

/*
Creating table user
*/

CREATE TABLE User(
user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
type enum('S', 'A') NOT NULL DEFAULT 'S',
registration_date DATE NOT NULL
);

/*
Creating table Address
*/

CREATE TABLE Address(
address_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
user_id INT NOT NULL,
street VARCHAR(100),
city VARCHAR(50) NOT NULL,
state VARCHAR(50) NOT NULL,
country VARCHAR(50) NOT NULL DEFAULT 'India',
zip INT(6) NOT NULL,
phone VARCHAR(10) NOT NULL,
FOREIGN KEY(user_id) REFERENCES User(user_id)
);

/*
Creating Order table
*/

CREATE TABLE Product_order(
order_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
address_id INT,
date DATE NOT NULL,
FOREIGN KEY(address_id) REFERENCES Address(address_id)
);

/*
Creating Order Detail table
*/

CREATE TABLE Order_detail(
detail_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
order_id INT,
price FLOAT NOT NULL,
status enum('shipped', 'returned', 'cancelled') NOT NULL,
last_updated DATE NOT NULL,
product_id INT,
quantity INT NOT NULL DEFAULT 1,
FOREIGN KEY(order_id) REFERENCES Product_order(order_id)
);

/*
command to display all the table names present in StoreFront
*/

SHOW TABLES;

/*
command to remove Product table of the StoreFront database.
*/
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE Product;

/*
Creating product table again
*/

CREATE TABLE Product(
product_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,order_detail
product_name VARCHAR(100) NOT NULL,
price FLOAT NOT NULL,
stock INT NOT NULL,
description VARCHAR(100),
date_added DATE NOT NULL,
last_updated DATE NOT NULL
);

