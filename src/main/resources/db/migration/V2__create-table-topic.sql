create table topics (
    id SERIAL primary key,
    academy_member_id BIGINT not null,
    creation_date TIMESTAMP not null,
    title varchar(300),
    message varchar(2500),
    unsubscribe_reason varchar(180),

    CONSTRAINT fk_topics_academy_member_id FOREIGN KEY (academy_member_id) REFERENCES academy_members(id)

);