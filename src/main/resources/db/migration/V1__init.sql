create table body_parts
(
    id   bigint primary key,
    name varchar(50) unique not null
);

create table levels_of_advancement
(
    id   bigint primary key,
    name varchar(50) unique not null
);

create table users
(
    id           bigint primary key,
    username     varchar(50) unique not null,
    firstName    varchar(50)        not null,
    lastNameName varchar(50)        not null
);

create table exercises
(
    id                      bigint primary key,
    name                    varchar(50) unique not null,
    description             varchar(200)       not null,
    body_part_id            bigint             not null,
    level_od_advancement_id bigint             not null,
    user_id                 bigint             not null,

    foreign key (body_part_id) references body_parts (id),
    foreign key (level_od_advancement_id) references levels_of_advancement (id),
    foreign key (user_id) references users (id)
);
