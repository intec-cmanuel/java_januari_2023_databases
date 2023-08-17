show databases;
create database accountapp;
use accountapp;

CREATE TABLE User (
    id int PRIMARY KEY,
    fname varchar(50),
    lname varchar(50),
    accEmail varchar(50),
    
    FOREIGN KEY(accEmail) REFERENCES Account(email)
);

drop table User;

show tables;
describe Account;

CREATE TABLE Account (
	email varchar(50) PRIMARY KEY,
    passw varchar(50) NOT NULL
);

select * from Account; 
drop table Account;
INSERT INTO Account VALUES ( 'Jean.Francais@chaudmail.com' , 'typo123' );
INSERT INTO User VALUES ('3904374', 'Jean', 'Francais', 'Jean.Francais@chaudmail.com');


INSERT INTO Account VALUES ( 'JeanJean@Jean.JEan' , 'Jean123' );