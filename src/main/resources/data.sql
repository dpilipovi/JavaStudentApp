insert into students (jmbag,firstname,lastname,numberOfEcts,dateOfBirth) values ('0246077777','Pero','Peric',120,'1993-04-17');

insert into students (jmbag,firstname,lastname,numberOfEcts,dateOfBirth) values ('0246033333','Ilija','Ilic',100,'1998-04-17');

insert into courses (id,name,numberOfEcts) values (1,'Web aplikacije u javi',7);

insert into courses (id,name,numberOfEcts) values (2,'Android',6);

insert into courses (id,name,numberOfEcts) values (3,'Zavrsni rad',15);

insert into student_course (student_jmbag,course_id) values ('0246077777',1);

insert into student_course (student_jmbag,course_id) values ('0246077777',2);

insert into student_course (student_jmbag,course_id) values ('0246033333',3);