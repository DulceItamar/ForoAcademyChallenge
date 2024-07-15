CREATE TABLE responses (

    id SERIAL primary key,
    message varchar(2500),
    creation_date TIMESTAMP not null,
     response_author_id BIGINT not null,
     post_id BIGINT not null,


    CONSTRAINT fk_post_id FOREIGN KEY (post_id) REFERENCES posts(id),
    CONSTRAINT fk_response_author_id FOREIGN KEY (response_author_id) REFERENCES academy_members(id)

);