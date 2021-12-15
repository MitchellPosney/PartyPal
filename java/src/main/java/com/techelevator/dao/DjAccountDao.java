package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.Genre;
import com.techelevator.model.User;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Time;
import java.util.Date;

public interface DjAccountDao {

    Event createEvent(Event event, User user, String playlistName);

    Event getEventByID(int eventId);

    Genre createGenre(Genre genre);

    void deleteGenre (int genreId);

    void addSongToGenre(int songId, Genre genre);

    void deleteSongFromGenre(int songId, Genre genre);

}
