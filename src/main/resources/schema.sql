create table post
(
    id      int auto_increment primary key,
    title   varchar(255) not null,
    content text         not null
);

insert into post (title, content)
values ('Post 1', 'Post 1 Content');