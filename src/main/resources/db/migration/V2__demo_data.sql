insert into body_parts (name) values ('Chest'), ('Upper back'), ('Legs'), ('Triceps');

insert into levels_of_advancement (name) values ( 'Basic'),('Advancement'),('Expert');

insert into users (username, firstname, lastname) values ( 'smucibucik', 'Radoslaw', 'Toczek' );
insert into users (username, firstname, lastname) values ( 'maxkarim', 'Czeslaw', 'Stefanski' );
insert into users (username, firstname, lastname) values ( 'smucikonik', 'Marek', 'Lubczyk' );

insert into exercises(name, description, body_part_id, level_of_advancement_id, user_id) values ( 'Dead Lift', 'Exercise with barel', 3,3,1 );
insert into exercises(name, description, body_part_id, level_of_advancement_id, user_id) values ( 'Bench press', 'Exercise with barel', 1,2,3 );
insert into exercises(name, description, body_part_id, level_of_advancement_id, user_id) values ( 'Running', 'Exercise on treadmill', 3, 1, 2 );

insert into exercise_photos(exercise_id, url) values ( 1, 'www.picture.com/picture1.jpg' );
insert into exercise_photos(exercise_id, url) values ( 2, 'www.picture.com/picture2.jpg' );
insert into exercise_photos(exercise_id, url) values ( 3, 'www.picture.com/picture3.jpg' );

insert into user_photos(user_id, url) values ( 1, 'www.picture.com/pictureOfUser1.jpg' );
insert into user_photos(user_id, url) values ( 2, 'www.picture.com/pictureOfUser2.jpg' );
insert into user_photos(user_id, url) values ( 3, 'www.picture.com/pictureOfUser3.jpg' );

insert into training_type(name) values ( 'Time' ),('Weight');

insert into trainings(name, description, user_id, levels_of_advancement_id, training_type_id) values ( 'Push A', 'Training to perform in mondays', 1, 2,2 );
insert into trainings(name, description, user_id, levels_of_advancement_id, training_type_id) values ( 'Pull A ', 'Training to perform in tuesdays', 1, 2,2 );
insert into trainings(name, description, user_id, levels_of_advancement_id, training_type_id) values ( 'Push B', 'Training to perform in mondays', 2, 3,2 );
insert into trainings(name, description, user_id, levels_of_advancement_id, training_type_id) values ( 'Pull B ', 'Training to perform in tuesdays', 2, 3,2 );

