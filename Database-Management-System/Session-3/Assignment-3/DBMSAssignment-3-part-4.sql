DROP DATABASE form;

CREATE DATABASE IF NOT EXISTS form;

USE form;

CREATE TABLE IF NOT EXISTS state (
    state_id INT NOT NULL AUTO_INCREMENT,
    state_name VARCHAR(30) UNIQUE,
    PRIMARY KEY (state_id)
);

CREATE TABLE IF NOT EXISTS city (
    city_id INT NOT NULL AUTO_INCREMENT,
    city_name VARCHAR(20) NOT NULL,
    state_id INT NOT NULL,
    PRIMARY KEY (city_id),
    FOREIGN KEY(state_id) REFERENCES state(state_id)
);

CREATE TABLE IF NOT EXISTS zipcode (
    zip_code INT NOT NULL,
    city_id INT NOT NULL,
    PRIMARY KEY (zip_code),
    FOREIGN KEY(city_id) REFERENCES city(city_id)
);


LOAD DATA INFILE 'C:/Users/Brothers/Desktop/DBMSAssignment/Assignment-3/Data/state_details.tsv' INTO TABLE state(state_name);
LOAD DATA INFILE 'C:/Users/Brothers/Desktop/DBMSAssignment/Assignment-3/Data/city_details.tsv' INTO TABLE city (city_name, state_id);
LOAD DATA INFILE 'C:/Users/Brothers/Desktop/DBMSAssignment/Assignment-3/Data/zip_details.tsv' INTO TABLE zipcode;


SELECT zip_code, city.city_name AS 'City Names', state.state_name AS 'States'
FROM zipcode 
JOIN city ON zipcode.city_id = city.city_id
JOIN state ON city.state_id = state.state_id
ORDER BY state.state_name, city.city_name;


