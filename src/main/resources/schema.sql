create table if not exists students
(
jmbag varchar(10) primary key,
firstname varchar(50) not null,
lastname varchar(50) not null,
numberOfEcts integer not null,
dateOfBirth date not null
);


create table if not exists courses
(
id int primary key not null,
name varchar(100) not null,
numberOfEcts integer not null
);

create table if not exists student_course
(
student_jmbag int not null,
course_id int not null,
PRIMARY KEY (`student_jmbag`,`course_id`),
FOREIGN KEY (`student_jmbag`) REFERENCES `students` (`jmbag`),
FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
)





