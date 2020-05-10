create table if not exists students
(
JMBAG varchar(10) primary key,
firstname varchar(50) not null,
lastname varchar(50) not null,
numberofects integer not null,
dateofbirth date not null
);


create table if not exists courses
(
id int primary key not null,
name varchar(100) not null,
numberofects integer not null
);

create table if not exists student_course
(
student_jmbag varchar(10) not null,
course_id int not null,
PRIMARY KEY (`student_jmbag`,`course_id`),
CONSTRAINT `student_course_1`
FOREIGN KEY (`student_jmbag`) REFERENCES `students` (`JMBAG`),
CONSTRAINT `student_course_2`
FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
);

create table if not exists user
(
id int primary key not null,
username varchar(100) not null,
password varchar(250) not null,
firstname varchar(250) not null,
lastname varchar(250) not null
);

create table if not exists authority
(
id int primary key not null,
name varchar(100) not null
);

create table if not exists user_authority
(
user_id int not null,
authority_id int not null,
PRIMARY KEY (`user_id`,`authority_id`),
CONSTRAINT `fk_userid`
FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
CONSTRAINT `fk_authorityid`
FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`)
);




