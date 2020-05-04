insert into body_parts (name) values ('Chest'), ('Upper back'), ('Legs'), ('Triceps');

insert into levels_of_advancement (name) values ( 'Basic'),('Advancement'),('Expert');

insert into users (username, first_name, last_name, password, age) values ( 'smucibucik', 'Radoslaw', 'Toczek', '$2a$10$VoUTR9bQZVxEjd5NTUqmgu4dr6jpNFP96Vf1aCiknD39/1QwZuZC6', 22);
insert into users (username, first_name, last_name, password, age) values ( 'maxkarim', 'Czeslaw', 'Stefanski', '$2a$10$Yi19c24vSFW9gHGQnnpQJ.V8mOYF3NHlIDUWf2Wu8r1.mKIUraFGm', 11);
insert into users (username, first_name, last_name, password, age) values ( 'relicoh', 'Marek', 'Lubczyk', '$2a$10$1h4cnaVllPQjO5EzPBiud.b7UQGR.upA6wBgGVNDqgskRA.0TjTDu',44);
insert into users (username, first_name, last_name, password, age) values ( 'uiop', 'Aleksander', 'Krysiuk', '$2a$10$G2KfV2bb/V400hqpCOpmzutdXXb.vB3HJCvPMeGaxl5t8lESKaEsu',8);


insert into roles (name) VALUES ( 'ROLE_USER' ), ('ROLE_ADMIN'), ('ROLE_MODERATOR');

insert into user_roles (user_id, role_id) values ( 1, 1 ), (2, 1), (3, 2), (3, 1), (4,3);

insert into exercises(name, description, body_part_id, level_of_advancement_id, user_id) values ( 'Dead Lift', 'Exercise with barel', 3,3,1 );
insert into exercises(name, description, body_part_id, level_of_advancement_id, user_id) values ( 'Bench press', 'Exercise with barel', 1,2,3 );
insert into exercises(name, description, body_part_id, level_of_advancement_id, user_id) values ( 'Running', 'Exercise on treadmill', 3, 1, 2 );

insert into exercise_photos(exercise_id, url, name) values ( 1, 'www.picture.com/picture1.jpg', ' pic 1');
insert into exercise_photos(exercise_id, url, name) values ( 2, 'www.picture.com/picture2.jpg', ' pic 2');
insert into exercise_photos(exercise_id, url, name) values ( 3, 'www.picture.com/picture3.jpg', ' pic 3');


insert into user_photos(user_id, url) values ( 1, 'www.picture.com/pictureOfUser1.jpg' );
insert into user_photos(user_id, url) values ( 2, 'www.picture.com/pictureOfUser2.jpg' );
insert into user_photos(user_id, url) values ( 3, 'www.picture.com/pictureOfUser3.jpg' );

insert into training_type(name) values ( 'Time' ),('Weight');

insert into trainings(name, description, user_id, levels_of_advancement_id, training_type_id) values ( 'Push A', 'Training to perform in mondays', 1, 2,2 );
insert into trainings(name, description, user_id, levels_of_advancement_id, training_type_id) values ( 'Pull A ', 'Training to perform in tuesdays', 1, 2,2 );
insert into trainings(name, description, user_id, levels_of_advancement_id, training_type_id) values ( 'Push B', 'Training to perform in mondays', 2, 3,2 );
insert into trainings(name, description, user_id, levels_of_advancement_id, training_type_id) values ( 'Pull B ', 'Training to perform in tuesdays', 2, 3,2 );

insert into training_exercises(exercise_id, training_id, reps, time, sets, tempo, order_number, description) values ( 1,1, 5, 120, 5,'2222',1, 'Training Exercise 1' );
insert into training_exercises(exercise_id, training_id, reps, time, sets, tempo, order_number, description) values ( 2,1, 5, 90, 3,'2332',2, 'Training Exercise 2' );
insert into training_exercises(exercise_id, training_id, reps, time, sets, tempo, order_number, description) values ( 3,1, 5, 100, 4,'2343',3, 'Training Exercise 3' );
insert into training_exercises(exercise_id, training_id, reps, time, sets, tempo, order_number, description) values ( 1,2, 5, 70, 5,'2244',1, 'Training Exercise 4' );

insert into sessions(training_id, user_id, comment, duration) values ( 4,1, 'The 1 session', 80 );
insert into sessions(training_id, user_id, comment, duration) values ( 2,2, 'The 2 session', 90 );
insert into sessions(training_id, user_id, comment, duration) values ( 1,2, 'The 3 session', 30 );
insert into sessions(training_id, user_id, comment, duration) values ( 3,1, 'The 4 session', 120 );

insert into session_exercises(session_id, exercise_id, reps, time, sets, tempo, order_number, description) values ( 1,1,5, 70, 5, 2432, 1, 'Session 1 exercises 1' );
insert into session_exercises(session_id, exercise_id, reps, time, sets, tempo, order_number, description) values ( 2,1,7, 350, 5, 2222, 2, 'Session 2 exercises 1' );
insert into session_exercises(session_id, exercise_id, reps, time, sets, tempo, order_number, description) values ( 2,2,7, 35, 5, 2222, 2, 'Session 2 exercises 2' );
insert into session_exercises(session_id, exercise_id, reps, time, sets, tempo, order_number, description) values ( 2,3,7, 35, 5, 2222, 2, 'Session 2 exercises 3' );
insert into session_exercises(session_id, exercise_id, reps, time, sets, tempo, order_number, description) values ( 3,2,5, 90, 5, 2112, 1, 'Session 3 exercises 2' );
insert into session_exercises(session_id, exercise_id, reps, time, sets, tempo, order_number, description) values ( 4,3,5, 120, 5, 2332, 2, 'Session 4 exercises 3' );


