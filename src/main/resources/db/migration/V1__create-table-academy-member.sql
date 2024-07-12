create table academy_members (
    id BIGSERIAL not null,
    name varchar(150) not null,
    email varchar(100) not null unique,
    member_category varchar(100) not null,
    is_active boolean default true,

    primary key(id)

);