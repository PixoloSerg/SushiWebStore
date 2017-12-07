DROP DATABASE IF EXISTS sushistoredb;
CREATE DATABASE sushistoredb CHARACTER SET utf8;
USE sushistoredb;

CREATE TABLE CATEGORY (
    ID INT NOT NULL AUTO_INCREMENT,
    PARENTID INT,
    CATEGORYNAME VARCHAR(50) NOT NULL,
    DESCRIPTION VARCHAR(500),
    ICON VARCHAR(255),
    IMAGE VARCHAR(255),
    WEIGHT SMALLINT,
    VISIBLE BOOLEAN,
    INMENU BOOLEAN,
    MENUWEIGHT SMALLINT,
    
    PRIMARY KEY(ID),
    FOREIGN KEY(PARENTID) REFERENCES CATEGORY(ID)
);

INSERT INTO CATEGORY(CATEGORYNAME, DESCRIPTION, ICON, IMAGE, WEIGHT, VISIBLE, INMENU, MENUWEIGHT) VALUES 
('rolls', 'If you have somethings to say about this product you can write text here and it appeared in product description field.', 
'/images/catIcon.png', '/images/catImage.jpg',
10, true, true, 10),
('sushi', 'If you have somethings to say about this product you can write text here and it appeared in product description field.', 
'/images/catIcon.png', '/images/catImage.jpg',
9, true, true, 9),
('soups', 'If you have somethings to say about this product you can write text here and it appeared in product description field.', 
'/images/catIcon.png', '/images/catImage.jpg',
8, true, true, 8),
('salads', 'If you have somethings to say about this product you can write text here and it appeared in product description field.', 
'/images/catIcon.png', '/images/catImage.jpg',
7, true, true, 7),
('sets', 'If you have somethings to say about this product you can write text here and it appeared in product description field.', 
'/images/catIcon.png', '/images/catImage.jpg',
6, true, true, 6),
('beverages', 'If you have somethings to say about this product you can write text here and it appeared in product description field.', 
'/images/catIcon.png', '/images/catImage.jpg',
5, true, true, 5),
('hot', 'If you have somethings to say about this product you can write text here and it appeared in product description field.', 
'/images/catIcon.png', '/images/catImage.jpg',
4, true, false, 4),
('vegetarian', 'If you have somethings to say about this product you can write text here and it appeared in product description field.', 
'/images/catIcon.png', '/images/catImage.jpg',
3, true, false, 3),
('topping', 'If you have somethings to say about this product you can write text here and it appeared in product description field.', 
'/images/catIcon.png', '/images/catImage.jpg',
2, true, false, 2),
('from chef', 'If you have somethings to say about this product you can write text here and it appeared in product description field.', 
'/images/catIcon.png', '/images/catImage.jpg',
1, true, false, 1),
('sale', 'If you have somethings to say about this product you can write text here and it appeared in product description field.', 
'/images/catIcon.png', '/images/catImage.jpg',
0, true, false, 0);

CREATE TABLE GOODSGROUP (
    ID INT NOT NULL AUTO_INCREMENT,
    PARENTID INT,
    GROUPNAME VARCHAR(50),

    PRIMARY KEY(ID),
    FOREIGN KEY(PARENTID) REFERENCES GOODSGROUP(ID)
);

INSERT INTO GOODSGROUP(GROUPNAME) VALUES('root');

CREATE TABLE GOODS (
    ID INT NOT NULL AUTO_INCREMENT,
    GROUPID INT NOT NULL,
    GOODSNAME VARCHAR(100) NOT NULL,

    INGRIDIENTS VARCHAR(200),
    WEIGHT INT,
    PROTEIN INT,
    CALORIE INT,
    FAT INT,
    CARBOHYDRATE INT,
    DESCRIPTION VARCHAR(200),
    
    IMAGES VARCHAR(255),

    POPULAR BOOLEAN,
    POPULARITY TINYINT,
    RECOMMEND BOOLEAN,
    RECOMMENDATION TINYINT,
    SALE BOOLEAN,
    SALEWEIGHT TINYINT,
    ISNEW BOOLEAN,
    NEWER TINYINT,
    CHEF BOOLEAN,
    VEGETARIAN BOOLEAN,
    SPICY BOOLEAN,

    PRICE DECIMAL(12, 2) NOT NULL DEFAULT '0.00',
    POINT DECIMAL(7, 1) NOT NULL DEFAULT '0.0',
    PRIMARY KEY(ID),
    FOREIGN KEY(GROUPID) REFERENCES GOODSGROUP(ID)    
);

INSERT INTO GOODS(GROUPID, GOODSNAME, INGRIDIENTS, WEIGHT, PROTEIN, CALORIE, FAT, CARBOHYDRATE, DESCRIPTION, IMAGES, 
POPULAR, POPULARITY, RECOMMEND, RECOMMENDATION, SALE, SALEWEIGHT, ISNEW, NEWER, CHEF, VEGETARIAN, SPICY, PRICE, POINT) VALUES
(1, 'Regular name', 'Fish, nori, cucumber, rise', 300, 15, 540, 43, 18, 
'I now many words but unfortunately it does not help me.', 
'/images/goodsImage.jpg',
false, 0, false, 0, true, 10, false, 0, true, false, true, 150.50, 50.0
),
(1, 'Regular name', 'Fish, nori, cucumber, rise', 300, 15, 540, 43, 18, 
'I now many words but unfortunately it does not help me.', 
'/images/goodsImage.jpg',
false, 0, false, 0, true, 10, false, 0, true, false, true, 250.50, 50.0
),
(1, 'Regular name', 'Fish, nori, cucumber, rise', 300, 15, 540, 43, 18, 
'I now many words but unfortunately it does not help me.', 
'/images/goodsImage.jpg',
false, 0, false, 0, true, 10, true, 5, true, false, true, 350.50, 50.0
),
(1, 'Regular name', 'Fish, nori, cucumber, rise', 300, 15, 540, 43, 18, 
'I now many words but unfortunately it does not help me.', 
'/images/goodsImage.jpg',
false, 0, true, 10, true, 10, true, 2, true, false, true, 450.50, 50.0
),
(1, 'Regular name', 'Fish, nori, cucumber, rise', 300, 15, 540, 43, 18, 
'I now many words but unfortunately it does not help me.', 
'/images/goodsImage.jpg',
false, 0, true, 9, true, 10, true, 3, true, false, true, 550.50, 50.0
),
(1, 'Regular name', 'Fish, nori, cucumber, rise', 300, 15, 540, 43, 18, 
'I now many words but unfortunately it does not help me.', 
'/images/goodsImage.jpg',
true, 10, true, 8, true, 10, false, 0, true, false, true, 650.50, 50.0
),
(1, 'Regular name', 'Fish, nori, cucumber, rise', 300, 15, 540, 43, 18, 
'I now many words but unfortunately it does not help me.', 
'/images/goodsImage.jpg',
true, 7, true, 7, false, 10, false, 0, true, false, true, 750.50, 50.0
),
(1, 'Regular name', 'Fish, nori, cucumber, rise', 300, 15, 540, 43, 18, 
'I now many words but unfortunately it does not help me.', 
'/images/goodsImage.jpg',
true, 4, true, 6, false, 10, false, 0, true, false, true, 850.50, 50.0
),
(1, 'Regular name', 'Fish, nori, cucumber, rise', 300, 15, 540, 43, 18, 
'I now many words but unfortunately it does not help me.', 
'/images/goodsImage.jpg',
true, 5, true, 5, false, 10, false, 0, true, false, true, 950.50, 50.0
),
(1, 'Regular name', 'Fish, nori, cucumber, rise', 300, 15, 540, 43, 18, 
'I now many words but unfortunately it does not help me.', 
'/images/goodsImage.jpg',
true, 10, true, 4, false, 10, false, 0, true, false, true, 310.50, 50.0
),
(1, 'Regular name', 'Fish, nori, cucumber, rise', 300, 15, 540, 43, 18, 
'I now many words but unfortunately it does not help me.', 
'/images/goodsImage.jpg',
true, 2, true, 3, false, 10, false, 0, true, false, true, 320.50, 50.0
),
(1, 'Regular name', 'Fish, nori, cucumber, rise', 300, 15, 540, 43, 18, 
'I now many words but unfortunately it does not help me.', 
'/images/goodsImage.jpg',
true, 1, true, 2, false, 10, false, 0, true, false, true, 350.50, 50.0
);

CREATE TABLE GOODS_CATEGORY (
    CATEGORYID INT NOT NULL,
    GOODSID INT NOT NULL,

    PRIMARY KEY(CATEGORYID, GOODSID),
    FOREIGN KEY(CATEGORYID) REFERENCES CATEGORY(ID),
    FOREIGN KEY(GOODSID) REFERENCES GOODS(ID)
);

INSERT INTO GOODS_CATEGORY VALUES
(1, 1),(1, 2),(1, 3),(1, 4),(1, 5),(1, 6),(1, 7),(1, 8),
(2, 3),(2, 7),(2, 12),(2, 11),
(3, 3),(3, 4),(3, 5),(3, 8),(3, 9),(3, 10),(3, 11),
(4, 1),(4, 2),(4, 3),(4, 4),(4, 5),(4, 7),(4, 9),(4, 12),
(5, 1),(5, 2),(5, 3),(5, 4),(5, 5),(5, 6),
(6, 2),(6, 3),(6, 4),(6, 5),(6, 6),(6, 7),
(7, 7),(7, 8),(7, 9),(7, 10),(7, 11),(7, 12);

CREATE TABLE CLIENT (
    ID INT NOT NULL AUTO_INCREMENT,
    FIRSTNAME VARCHAR(50),
    LASTNAME VARCHAR(50),
    EMAIL VARCHAR(50),
    ADDRESS VARCHAR(100),
    POINTS DECIMAL(7,1),
    
    PRIMARY KEY(ID)
);

CREATE TABLE INVOICE (
    ID BIGINT NOT NULL AUTO_INCREMENT,
    CLIENTID INT,
    INVOICEDATE DATETIME NOT NULL,
    ADDRESS VARCHAR(150),
    DESCRIPTION VARCHAR(300),
    TOTALAMOUNT INT NOT NULL,
    TOTALSUM DECIMAL(12, 2) NOT NULL,
    POINTSSUM DECIMAL(7,1) NOT NULL,

    PRIMARY KEY(ID),
    FOREIGN KEY(CLIENTID) REFERENCES CLIENT(ID)
);

CREATE TABLE LINEITEM (
    ID BIGINT NOT NULL AUTO_INCREMENT,
    INVOICEID BIGINT NOT NULL,
    GOODSID INT NOT NULL,
    PRICE DECIMAL(12, 2) NOT NULL,
    SUMM DECIMAL(12, 2) NOT NULL,
    AMOUNT INT NOT NULL,
    POINT DECIMAL(7,1) NOT NULL DEFAULT 0,

    PRIMARY KEY(ID),
    FOREIGN KEY(INVOICEID) REFERENCES INVOICE(ID),
    FOREIGN KEY(GOODSID) REFERENCES GOODS(ID)
);

CREATE TABLE ADDRESS (
    ID INT NOT NULL AUTO_INCREMENT,
    CITY VARCHAR(50) NOT NULL,
    DISTRICT VARCHAR(50),
    STREET VARCHAR(50),
    STREETNUMBER SMALLINT,
    PHONE VARCHAR(15) NOT NULL,

    PRIMARY KEY(ID)
);

INSERT INTO ADDRESS(CITY, DISTRICT, STREET, STREETNUMBER, PHONE) VALUES
('Detroit', 'District', 'Avenu', 12, '4821232141'),
('Pita', 'District', 'Avenu', 5, '5467788216'),
('Greensboro', 'District', 'Avenu', 32, '4708921654'),
('New-York', 'District', 'Avenu', 21, '7805432819'),
('Washington', 'District', 'Avenu', 11, '9805765428');


CREATE TABLE SHOPINFO (
    ID INT NOT NULL,
    OFFERTITLE VARCHAR(50),
    OFFERTEXT VARCHAR(300),
    SHOPSLOGAN VARCHAR(100),
    RECOMMENDBLOCKTITLE VARCHAR(50),
    RECOMMENDBLOCKTEXT VARCHAR(300),
    SALEBLOCKTITLE VARCHAR(50),
    SALEBLOCKTEXT VARCHAR(300),
    ABOUTTITLE VARCHAR(50),
    ABOUTMSGTITLE VARCHAR(50),
    ABOUTMSGTEXT VARCHAR(1000),
    ABOUTSERVICEPHONE VARCHAR(12),
    POPULARBANDTITLE VARCHAR(50),
    NEWBANDTITLE VARCHAR(50),

    PRIMARY KEY(ID)
);

INSERT INTO SHOPINFO VALUES(1,
"Summer menu", "This is text that describe our offers.",
"Amazing, incredible, unbelevable, teriffic, fine",
"We recommend", "Our recommendation text goes here",
"Our sale", "We need more money, please buy something",
"About us", "SUSHI STORE", 
"There must be relly massive text about us to blow away doubts about who we are There must be relly massive text about us to blow away doubts about who we are There must be relly massive text about us to blow away doubts about who we are There must be relly massive text about us to blow away doubts about who we are There must be relly massive text about us to blow away doubts about who we are",
"2124235467",
"POPULAR", "NEW"
);

CREATE TABLE SCHEDULE (
    ID INT NOT NULL,
    WORKBEGIN DECIMAL(4,2) NOT NULL DEFAULT 8.00,
    WORKEND DECIMAL(4,2) NOT NULL DEFAULT 18.00,

    PRIMARY KEY(ID)
);

INSERT INTO SCHEDULE VALUES
(1, 9.00, 22.00),
(2, 9.00, 22.00),
(3, 9.00, 22.00),
(4, 9.00, 22.00),
(5, 9.00, 22.00),
(6, 10.00, 20.00),
(7, 10.00, 20.00);

CREATE TABLE ADDRESS_SCHEDULE (
    ADDRESSID INT NOT NULL,
    SCHEDULEID INT NOT NULL,
    
    PRIMARY KEY(SCHEDULEID, ADDRESSID),
    FOREIGN KEY(SCHEDULEID) REFERENCES SCHEDULE(ID),
    FOREIGN KEY(ADDRESSID) REFERENCES ADDRESS(ID)
);

INSERT INTO ADDRESS_SCHEDULE VALUES
(1,1),(1,2),(1,3),(1,5),(1,6),(1,7),
(2,1),(2,2),(2,3),(2,5),(2,6),(2,7),
(3,1),(3,2),(3,3),(3,5),(3,6),(3,7),
(4,1),(4,2),(4,3),(4,5),(4,6),(4,7),
(5,1),(5,2),(5,3),(5,5),(5,6),(5,7);


DROP DATABASE IF EXISTS sushiusers;
CREATE DATABASE sushiusers;
USE sushiusers;

CREATE TABLE USERS (
    USERNAME VARCHAR(50) NOT NULL,
    USERPASSWORD VARCHAR(100) NOT NULL,
    
    PRIMARY KEY(USERNAME, USERPASSWORD)
);

CREATE TABLE USERSROLES (
    USERROLE VARCHAR(50) NOT NULL,

    PRIMARY KEY(USERROLE)
);

CREATE TABLE USER_ROLE (
    USERNAME VARCHAR(50) NOT NULL,
    USERROLE VARCHAR(50) NOT NULL,

    PRIMARY KEY(USERNAME, USERROLE),
    FOREIGN KEY(USERNAME) REFERENCES USERS(USERNAME),
    FOREIGN KEY(USERROLE) REFERENCES USERSROLES(USERROLE)
);


