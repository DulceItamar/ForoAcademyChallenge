create table users (

    id BIGSERIAL not null,
    login varchar(100) not null,
    password varchar(300) not null,
    primary key(id)

);