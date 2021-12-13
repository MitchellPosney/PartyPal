BEGIN TRANSACTION;

DROP TABLE IF EXISTS event;   
DROP TABLE IF EXISTS song_playlist;

DROP TABLE IF EXISTS song;  
DROP TABLE IF EXISTS playlist; 
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS dj; 
DROP TABLE IF EXISTS hosts; 
DROP TABLE IF EXISTS users; 
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50),
	CONSTRAINT PK_user PRIMARY KEY (user_id)
); 

 

CREATE TABLE genre ( 
        genre_id SERIAL, 
        genre_name varchar(50) NOT NULL UNIQUE,
        CONSTRAINT pk_genre_id PRIMARY KEY (genre_id)
);

INSERT INTO genre (genre_name)
VALUES ('Christmas'),
       ('Birthday Party'),
       ('90s Summer Party'),
       ('Wedding'),
       ('2021 Graduation');


CREATE TABLE song (  
        song_id SERIAL, 
        genre_id int, 
        song_title varchar(250) NOT NULL, 
        song_artist varchar(250) NOT NULL, 
        CONSTRAINT pk_song_id PRIMARY KEY (song_id),    
        CONSTRAINT fk_genre_id FOREIGN KEY (genre_id) REFERENCES genre(genre_id)     
);

COPY song 
FROM 'C:\Users\Public\songs.csv' 
DELIMITER ','
CSV HEADER;



CREATE TABLE playlist (  
        playlist_id SERIAL, 
        playlist_name varchar(50) NOT NULL,   
        CONSTRAINT pk_playlist_id PRIMARY KEY (playlist_id)
       
);       

CREATE TABLE song_playlist ( 
        song_id int, 
        playlist_id int,  
        CONSTRAINT fk_song_id FOREIGN KEY (song_id) REFERENCES song(song_id),  
        CONSTRAINT fk_playlist_id FOREIGN KEY (playlist_id) REFERENCES playlist(playlist_id)
        
);


CREATE TABLE event (  
        event_id SERIAL, 
        event_host int, 
        event_dj int,
        playlist_id int,   
        genre_id int,
        event_name varchar(50) NOT NULL, 
        event_date date, 
        start_time time, 
        duration_minutes int,  
        event_location varchar(50),
        CONSTRAINT pk_event_id PRIMARY KEY (event_id),   
        CONSTRAINT fk_genre_id FOREIGN KEY (genre_id) REFERENCES genre(genre_id),     
        CONSTRAINT fk_playlist_id FOREIGN KEY (playlist_id) REFERENCES playlist(playlist_id),   
        CONSTRAINT fk_event_host FOREIGN KEY (event_host) REFERENCES users(user_id),
        CONSTRAINT fk_event_dj FOREIGN KEY (event_dj) REFERENCES users(user_id)  
);  

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_EVENTHOST');
INSERT INTO users (username,password_hash,role) VALUES ('dj','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DJ');  


INSERT INTO playlist (playlist_name) VALUES ('Mitchell');


COMMIT TRANSACTION;
