create table posts (
    id SERIAL primary key,
    academy_member_id BIGINT not null,
    title varchar(300),
    message varchar(2500),
     creation_date TIMESTAMP not null,

    CONSTRAINT fk_topics_academy_member_id FOREIGN KEY (academy_member_id) REFERENCES academy_members(id)

);