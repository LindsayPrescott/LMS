use lms;

create table courses (
	course_id int auto_increment,
    course_name varchar(30) unique,
    price double,
    course_description varchar(100),
    capacity int,
    primary key(course_id));

ALTER TABLE courses AUTO_INCREMENT = 100;

insert into courses(course_name, price, course_description, capacity)
values ('Calculus I', 350, 'An introduction to differential and integral calculus: the study of change.', 50);

insert into courses(course_name, price, course_description, capacity)
values ('Calculus II', 325, 'A continuation of Calculus one, covering integration and infinite series.', 40);