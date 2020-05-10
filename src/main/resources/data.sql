insert into students (jmbag,firstname,lastname,numberofects,dateofbirth) values ('0246077777', 'Pero', 'Peric', 120, '1993-04-17');

insert into students (jmbag,firstname,lastname,numberofects,dateofbirth) values ('0246033333', 'Ilija', 'Ilic', 100, '1998-04-17');

insert into courses (id,name,numberofects) values (1, 'Web aplikacije u javi', 7);

insert into courses (id,name,numberofects) values (2, 'Android', 6);

insert into courses (id,name,numberofects) values (3, 'Zavrsni rad', 15);

insert into student_course (student_jmbag,course_id) values ('0246077777', 1);

insert into student_course (student_jmbag,course_id) values ('0246077777', 2);

insert into student_course (student_jmbag,course_id) values ('0246033333', 3);

insert into user (id , username , password , firstname , lastname) values (1, 'admin', '$2a$10$mmwpv2nhHnXxXaOk1BC7j.ccPABitxaRiFfnHvaeIcgdSB5aQHfJe', 'admin', 'admin');

insert into user (id , username , password , firstname , lastname) values (2, 'user', '$2a$10$XaB1JhwcSn6bxELiQz.lleIHV.KtoF/aD7RBXmB2qI78qBl/EJ7HS', 'user', 'user');

insert into authority (id, name) values (1, 'ROLE_ADMIN');

insert into authority (id, name) values (2, 'ROLE_USER');

insert into user_authority (user_id, authority_id) values (1, 1);

insert into user_authority (user_id, authority_id) values (2, 2);