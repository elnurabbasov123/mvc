-- create table students (
--     id int not null auto_increment,
--     name varchar (20),
--     surname varchar (20),
--     student_class int,
--     birthday date,
--     email varchar(50),
--     course_code varchar(50),
--     phone varchar(20),
--     primary key (id)
-- );

insert into students(name,surname,student_class,birthday,email,course_code,phone) values
                                          ('Ayxan','Huseynov',4,'2010-05-07','huseynoff478@gmail.com','MY-001','055-656-5563'),
                                          ('Eli','Eliyev',7,'2012-02-04','elishka78@gmail.com','MY-002','050-565-3214'),
                                          ('Mecid','Qasimov',5,'2009-01-01','qasimov55@gmail.com','MY-003','077-896-3326'),
                                          ('Senan','Ceferov',6,'2008-09-03','senka23@gmail.com','MY-004','055-785-8535'),
                                          ('Aydin','Mirzoyev',9,'2007-11-09','mirzoyev89@gmail.com','MY-005','051-236-4656');

create table users(
    username varchar(50),
    password varchar(150),
    enabled int,
    primary key(username)
);

-- m88

insert into users(username, password, enabled) values('yusif','{noop}1',1),
                                                     ('hesen','{bcrypt}$2a$12$LZZMjIHNvOY.u0CJhFz0cOfNiHLMHNig6FKKR0te/vLWovedtU/V.',1),
                                                     ('eli','{noop}3',1),
                                                     ('huseyin','{noop}4',1),
                                                     ('anar','{noop}5',1);

create table authorities(
                      username varchar(50),
                      authority varchar(50)
);

insert into authorities(username,authority) values('yusif','read:all:students'),
                                                  ('yusif','open:new:student:page'),
                                                  ('yusif','save:student'),
                                                  ('yusif','delete:student'),

                                                  ('hesen','read:all:students'),
                                                  ('hesen','open:edit:student:page'),
                                                  ('hesen','save:student'),

                                                  ('eli','read:all:students'),
                                                  ('eli','open:new:student:page'),
                                                  ('eli','save:student'),

                                                  ('huseyin','read:all:students '),
                                                  ('huseyin','open:edit:student:page'),
                                                  ('huseyin','save:student'),
                                                  ('huseyin','delete:student'),

                                                  ('anar','read:all:students '),
                                                  ('anar','open:edit:student:page'),
                                                  ('anar','save:student'),
                                                  ('anar','delete:student'),
                                                  ('anar','open:new:student:page'),
                                                  ('anar','search:student');


-- read:all:students
-- open:new:student:page
-- save:student
-- delete:student
-- open:edit:student:page
-- search:student

insert into sectors(name) values('Az'),
                                ('Turk'),
                                ('Alman'),
                                ('Rus'),
                                ('Fransiz'),
                                ('Ingilis');

insert into programming_languages(name) values('Java'),
                                ('Python'),
                                ('Pascal'),
                                ('PHP'),
                                ('JavaScript'),
                                ('Hack'),
                                ('C'),
                                ('Scala');