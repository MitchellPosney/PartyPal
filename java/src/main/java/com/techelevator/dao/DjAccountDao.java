package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.User;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Time;
import java.util.Date;

public interface DjAccountDao
{
    void songCreate(long genre_id, String song_title, String song_artist);

    void songRemove(long songId);

    void addSongToPlaylist(long songId, long playlistId);

    void removeSongFromPlaylist(long songId, long playlistId);

    Event createEvent(Event event, User user);
    Event getEventByID(int eventId);

    SqlRowSet listAllSongs();

}
