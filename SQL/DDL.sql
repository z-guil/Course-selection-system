create database if not exists project;
use project;

create table tb_student
(
    id int primary key auto_increment,
    name     varchar(30)  not null,
    password varchar(100) not null,
    studentClass varchar(50) not null default 'null',
    index s_index_name (name),
    index s_index_id (id)
);

create table tb_teacher
(
    id int primary key auto_increment,
    name     varchar(30)  not null,
    password varchar(100) not null,
    index t_index_name (name),
    index t_index_id (id)
);

create table tb_course
(
    id          int primary key auto_increment,
    title       varchar(30)  not null,
    teacherName varchar(30)  not null,
    place       varchar(100) not null,
    week        varchar(30)  not null,
    time        varchar(50)  not null,
    startToEnd  varchar(50)  not null,
    index c_index_title (title)
);

create table tb_s_c
(
    id         int primary key auto_increment,
    id_student int,
    id_course  int,
    foreign key (id_student) references tb_student (id),
    foreign key (id_course) references tb_course (id)
);

create table tb_t_c
(
    id         int primary key auto_increment,
    id_teacher int,
    id_course  int,
    foreign key (id_teacher) references tb_teacher (id),
    foreign key (id_course) references tb_course (id)
);

create table tb_root
(
    id         int primary key auto_increment,
    name     varchar(30)  not null,
    password varchar(100) not null

);