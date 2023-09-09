create database omsakthi;
use omsakthi;
show tables;
 create table VENDOR(
 ID int not null AUTO_INCREMENT,
 VENDORNAME varchar (50),
 GSTNUMBER varchar (50) UNIQUE,
 PAN VARCHAR(50),
 ADDRESSLINE1 varchar(50),
 ADDRESSLINE2 varchar(50),
 CITY varchar(50),
 STATE varchar(50),
 PINCODE varchar(10),
 COUNTRY varchar(50),
 PHONENUMBER varchar(10),
 PRIMARY KEY (id)
 );
create table INVOICE(
 INVOICEID int not null AUTO_INCREMENT,
 INVOICENUMBER varchar (50) UNIQUE,
 INVOICEDATE varchar (50) ,
 VENDORID varchar(50),
 
 TOTALAMOUNT DECIMAL(6,2),
 CGST INTEGER,
 SGST INTEGER,
 PRIMARY KEY (INVOICEID)
 );
 
create table PARTICULAR(
 ID int not null AUTO_INCREMENT,
 INVOICENUMBER varchar (50),
 ITEM varchar (50) ,
 HSN_SAC varchar(50),
 QUANTITY varchar(10),
 RATE DECIMAL(6,2),
 TOTALPRICE DECIMAL(6,2),
 PRIMARY KEY (ID),
 FOREIGN KEY (INVOICENUMBER)
 REFERENCES INVOICE (INVOICENUMBER)
 );
 
 
 create table user(
id int not null primary key auto_increment,
username varchar(20),
email varchar(50),
password varchar(120));

create table roles(
id int not null primary key auto_increment,
name varchar(20));

create table user_roles(
user_id bigint(20) primary key,
role_id int(11));

 
 
 commit;
 
 select * from INVOICE;
 select * from PARTICULAR;
SET FOREIGN_KEY_CHECKS = 0;
truncate table INVOICE;
truncate table PARTICULAR;
 SET FOREIGN_KEY_CHECKS = 1;
drop table INVOICE;

 ALTER TABLE INVOICE
MODIFY COLUMN TOTALAMOUNT int;

INSERT INTO roles (`id`,`name`) VALUES (1,'ROLE_USER');
INSERT INTO roles (`id`,`name`) VALUES (2,'ROLE_MODERATOR');
INSERT INTO roles(`id`,`name`) VALUES (3,'ROLE_ADMIN');