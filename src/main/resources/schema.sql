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
)





