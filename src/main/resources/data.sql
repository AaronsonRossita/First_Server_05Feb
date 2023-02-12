DROP TABLE IF EXISTS customer_order;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);

CREATE TABLE customer_order(
    id int NOT NULL AUTO_INCREMENT,
    customer_id int NOT NULL,
    item_name varchar(300) NOT NULL DEFAULT '',
    price decimal(100,2) NOT NULL DEFAULT '',
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

CREATE TABLE student(
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);






