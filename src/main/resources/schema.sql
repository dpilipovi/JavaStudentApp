create table if not exists students
(
jmbag varchar(10) primary key,
firstname varchar(50) not null,
lastname varchar(50) not null,
numberOfEcts integer not null,
dateOfBirth date not null
);


create table if not exists COURSES
(
id int primary key not null,
name varchar(100) not null,
numberOfEcts integer not null
);





