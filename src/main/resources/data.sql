insert into students (jmbag,firstname,lastname,numberofects,dateofbirth) values ('0246077777','Pero','Peric',120,'1993-04-17');

insert into students (jmbag,firstname,lastname,numberofects,dateofbirth) values ('0246033333','Ilija','Ilic',100,'1998-04-17');

insert into courses (id,name,numberofects) values (1,'Web aplikacije u javi',7);

insert into courses (id,name,numberofects) values (2,'Android',6);

insert into courses (id,name,numberofects) values (3,'Zavrsni rad',15);

insert into student_course (student_jmbag,course_id) values ('0246077777',1);

insert into student_course (student_jmbag,course_id) values ('0246077777',2);

insert into student_course (student_jmbag,course_id) values ('0246033333',3);