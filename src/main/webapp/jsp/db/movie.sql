create table movie_test (
    m_number number(3) primary key,
    m_title varchar2(100 char) not null,
    m_actor varchar2(30 char) not null,
    m_img varchar2(200 char) not null,
    m_story varchar2(2000 char) not null
);

create sequence movie_test_seq;

insert into movie_test values (movie_test_seq.nextval, 'Inception', 'Leonardo DiCaprio', 'inception.jpg', 'A thief who steals corporate secrets through the use of dream-sharing technology.');
insert into movie_test values (movie_test_seq.nextval, 'The Dark Knight', 'Christian Bale', 'dark_knight.jpg', 'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham.');
insert into movie_test values (movie_test_seq.nextval, 'Interstellar', 'Matthew McConaughey', 'interstellar.jpg', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity survival.');
insert into movie_test values (movie_test_seq.nextval, 'The Matrix', 'Keanu Reeves', 'matrix.jpg', 'A computer hacker learns from mysterious rebels about the true nature of his reality.');
insert into movie_test values (movie_test_seq.nextval, 'Parasite', 'Song Kang-ho', 'parasite.jpg', 'Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.');
insert into movie_test values (movie_test_seq.nextval, 'About Time', 'Domhnall Gleeson', 'about_time.jpg', 'At the age of 21, Tim discovers he can travel in time and change what happens and has happened in his own life.');
insert into movie_test values (movie_test_seq.nextval, 'Joker', 'Joaquin Phoenix', 'joker.jpg', 'A mentally troubled comedian is disregarded and mistreated by society, embarking on a downward spiral of revolution.');
insert into movie_test values (movie_test_seq.nextval, 'Titanic', 'Leonardo DiCaprio', 'titanic.jpg', 'A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.');
insert into movie_test values (movie_test_seq.nextval, 'Avatar', 'Sam Worthington', 'avatar.jpg', 'A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.');

select * from movie_test;


