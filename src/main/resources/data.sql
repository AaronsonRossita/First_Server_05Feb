DROP TABLE IF EXISTS customer_order;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS student;

CREATE TABLE customer(
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    status varchar(300) NOT NULL DEFAULT 'REGULAR',
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

INSERT INTO customer (first_name, last_name, email)
VALUES ('a','aa','a@mail.com'),
        ('b','bb','b@mail.com'),
        ('c','cc','c@mail.com'),
        ('e','ee','e@mail.com'),
        ('e','ee','e@mail.com'),
        ('f','ff','f@mail.com'),
        ('f','ff','f@mail.com');








