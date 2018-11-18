create database cmpe279;
CREATE TABLE IF NOT EXISTS Users(id serial PRIMARY KEY, uname VARCHAR(500) UNIQUE, fname VARCHAR(500), lname VARCHAR(500), password VARCHAR(500));


insert into Users (uname, fname, lname, password) values ('divyang', 'divyang', 'soni', 1234);
insert into Users (uname, fname, lname, password) values ('varun', 'varun', 'shah', 1234);
insert into Users (uname, fname, lname, password) values ('raj', 'raj', 'baraiya', 1234);

select * from users;

delete from users;
