create table courses (
  id  serial not null,
  description varchar(255),
  name varchar(255),
  primary key (id));

create table orders (
  id  serial not null,
  course_id int4,
  student_id int4,
  tariff_id int4,
  teacher_id int4,
  primary key (id));

create table schedules (
  id  serial not null,
  date date,
  time time,
  student_id int4,
  teacher_id int4,
  primary key (id));

create table students (
  id  serial not null,
  birth_date date,
  email varchar(255),
  name varchar(255),
  phone_number varchar(255),
  photo varchar(255),
  rank float8,
  skype varchar(255),
  surname varchar(255),
  primary key (id));

create table teachers (
  id  serial not null,
  birth_date date,
  cv varchar(255),
  email varchar(255),
  name varchar(255),
  phone_number varchar(255),
  skype varchar(255),
  surname varchar(255),
  course_id int4,
  primary key (id));

create table teachers_students (
  student_id int4 not null,
  teacher_id int4 not null,
  primary key (student_id, teacher_id));

create table tariffs (
  id  serial not null,
  count int4,
  count_type varchar(255),
  duration int4,
  name varchar(255),
  price numeric(19, 2),
  timesaweek int4,
  primary key (id));

create table tasks (
  id  serial not null,
  created_date date,
  expiration_date date,
  name varchar(255),
  url varchar(255),
  student_id int4,
  teacher_id int4,
  primary key (id));

create table users (
  id  serial not null,
  birth_date date,
  email varchar(255),
  name varchar(255),
  surname varchar(255),
  password varchar(255),
  phone_number varchar(255),
  private_id int4,
  role varchar(255),
  skype varchar(255),
  token varchar(255),
  primary key (id));

CREATE VIEW schedule_count AS
  SELECT t.id, t.birth_date, t.cv, t.email, t.name, t.phone_number, t.skype, t.surname, t.course_id, COUNT(s.teacher_id)
  FROM teachers t
         LEFT JOIN schedules s
           ON s.teacher_id = t.id
  GROUP BY t.id;