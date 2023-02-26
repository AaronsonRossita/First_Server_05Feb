DROP TABLE IF EXISTS customer_order;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS student;

CREATE TABLE customer(
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(300) DEFAULT '',
    last_name varchar(300) DEFAULT '',
    email varchar(300) DEFAULT '',
    status varchar(300) DEFAULT 'REGULAR',
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
    payment_method varchar(300) NOT NULL DEFAULT 'CC',
    PRIMARY KEY (id)
);

INSERT INTO customer (first_name, last_name, email, status)
VALUES ('a','aa','a@mail.com','VIP'),
        ('b','bb','b@mail.com','VIP'),
        ('c','cc','c@mail.com','VIP'),
        ('e','ee','e@mail.com','VIP'),
        ('e','ee','e@mail.com','VIP'),
        ('f','ff','f@mail.com','VIP'),
        ('f','ff','f@mail.com','VIP');


INSERT INTO student (first_name, last_name, email, payment_method)
VALUES ('a','aa','a@mail.com','CC'),
        ('b','bb','b@mail.com','CASH'),
        ('c','cc','c@mail.com','VOUCHER'),
        ('e','ee','e@mail.com','CHECK'),
        ('e','ee','e@mail.com','CC'),
        ('f','ff','f@mail.com','VOUCHER'),
        ('f','ff','f@mail.com','VOUCHER');







