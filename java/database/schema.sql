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

CREATE TABLE hosts ( 
        host_id int, 
        host_name varchar(50) NOT NULL,
        CONSTRAINT pk_host_id PRIMARY KEY (host_id),  
        CONSTRAINT fk_host_id FOREIGN KEY (host_id) REFERENCES users(user_id) 
        
);   

CREATE TABLE dj ( 
        dj_id int, 
        dj_name varchar(50) NOT NULL,
        CONSTRAINT pk_dj_id PRIMARY KEY (dj_id),  
        CONSTRAINT fk_dj_id FOREIGN KEY (dj_id) REFERENCES users(user_id) 
        
);     

CREATE TABLE genre ( 
        genre_id SERIAL, 
        genre_name varchar(50) NOT NULL UNIQUE,
        CONSTRAINT pk_genre_id PRIMARY KEY (genre_id)
      
        
);     


CREATE TABLE song (  
        song_id SERIAL, 
        genre_id int, 
        song_title varchar(50) NOT NULL, 
        song_artist varchar(50) NOT NULL, 
        CONSTRAINT pk_song_id PRIMARY KEY (song_id),    
        CONSTRAINT fk_genre_id FOREIGN KEY (genre_id) REFERENCES genre(genre_id)     
);    


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
        duration_minutes int CHECK (duration_minutes >= 30),  
        event_location varchar(50),
        CONSTRAINT pk_event_id PRIMARY KEY (event_id),   
        CONSTRAINT fk_genre_id FOREIGN KEY (genre_id) REFERENCES genre(genre_id),     
        CONSTRAINT fk_playlist_id FOREIGN KEY (playlist_id) REFERENCES playlist(playlist_id),   
        CONSTRAINT fk_event_host FOREIGN KEY (event_host) REFERENCES hosts(host_id),
        CONSTRAINT fk_event_dj FOREIGN KEY (event_dj) REFERENCES dj(dj_id)  
);  

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_EVENTHOST');
INSERT INTO users (username,password_hash,role) VALUES ('dj','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DJ');  

INSERT INTO hosts (host_id, host_name) VALUES ((SELECT user_id FROM users WHERE username = 'user' AND role = 'ROLE_EVENTHOST'), 'Caroline');  
INSERT INTO dj (dj_id, dj_name) VALUES ((SELECT user_id FROM users WHERE username = 'dj' AND role = 'ROLE_DJ'), 'Caroline'); 
INSERT INTO genre (genre_name) VALUES ('Birthday');  
INSERT INTO song (genre_id, song_title, song_artist) VALUES ((SELECT genre_id FROM genre WHERE genre_name = 'Birthday'), 'Happy Birthday', 'Caroilne'); 
INSERT INTO playlist (playlist_name) VALUES ('Caroline Birthday Playlist');  
INSERT INTO song_playlist(playlist_id, song_id) VALUES ((SELECT song_id FROM song WHERE song_title = 'Happy Birthday'), ((SELECT playlist_id FROM playlist WHERE playlist_name = 'Caroline Birthday Playlist')));
INSERT INTO event (event_name) VALUES ('Caroline Birthday Party');


COMMIT TRANSACTION;
