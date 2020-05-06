create table body_parts
(
    id   bigint primary key auto_increment,
    name varchar(50) unique not null
);

create table level_of_advancement
(
    id   bigint primary key auto_increment,
    name varchar(50) unique not null
);

create table users
(
    id         bigint primary key auto_increment,
    username   varchar(50) unique not null,
    first_name varchar(50)        not null,
    last_name  varchar(50)        not null,
    password   varchar(60)        not null,
    age        int,
    height     numeric(4, 2),
    weight     numeric(4, 2)
);

create table roles
(
    id   bigint primary key auto_increment,
    name varchar(20) unique
);

create table user_roles
(
    user_id bigint not null,
    role_id bigint not null,

    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

create table exercises
(
    id                      bigint primary key auto_increment,
    name                    varchar(50),
    description             varchar(200),
    body_part_id            bigint  not null,
    level_of_advancement_id bigint  not null,
    user_id                 bigint  not null,
    has_expired             boolean not null default false,

    foreign key (body_part_id) references body_parts (id),
    foreign key (level_of_advancement_id) references level_of_advancement (id),
    foreign key (user_id) references users (id)
);

create table exercise_photos
(
    id          bigint primary key auto_increment,
    exercise_id bigint not null,
    url         varchar(200),
    name        varchar(200),


    foreign key (exercise_id) references exercises (id)
);

create table user_photos
(
    id      bigint primary key auto_increment,
    user_id bigint              not null,
    url     varchar(200) unique not null,

    foreign key (user_id) references users (id)
);

create table training_type
(
    id   bigint primary key auto_increment,
    name varchar(200) unique not null
);

create table trainings
(
    id                      bigint primary key auto_increment,
    name                    varchar(200),
    description             varchar(400),
    user_id                 bigint,
    level_of_advancement_id bigint,
    training_type_id        bigint,

    foreign key (user_id) references users (id),
    foreign key (level_of_advancement_id) references level_of_advancement (id),
    foreign key (training_type_id) references training_type (id)
);

create table training_exercises
(
    exercise_id  bigint,
    training_id  bigint,

    reps         int,
    time         int,
    sets         int,
    tempo        varchar(4),
    order_number int,
    description  varchar(400),

    foreign key (exercise_id) references exercises (id),
    foreign key (training_id) references trainings (id),
    primary key (exercise_id, training_id)
);

create table sessions
(
    id          bigint primary key auto_increment,
    training_id bigint not null,
    user_id     bigint not null,

    started_at  timestamp,
    comment     varchar(400),
    duration    int    not null,

    foreign key (training_id) references trainings (id),
    foreign key (user_id) references users (id)
);

create table session_exercises
(
    session_id   bigint not null,
    exercise_id  bigint not null,

    reps         int,
    time         int,
    sets         int,
    tempo        varchar(4),
    order_number int,
    description  varchar(400),

    foreign key (session_id) references sessions (id),
    foreign key (exercise_id) references exercises (id),
    primary key (session_id, exercise_id)
);

create table api_keys
(
    id          bigint primary key auto_increment,
    user_id     bigint unique not null,
    value       varchar(64) not null,
    has_expired boolean default false,

    foreign key (user_id) references users (id)
);