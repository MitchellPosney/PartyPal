package com.techelevator.dao;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Time;
import java.util.Date;

public interface DjAccountDao
{
    void songCreate(long genre_id, String song_title, String song_artist);

    void songRemove(long songId);

    void addSongToPlaylist(long songId, long playlistId);

    void removeSongFromPlaylist(long songId, long playlistId);

    void createEvent(int hostId, int djId, int playlistId, String eventName, Date eventDate, Time startTime, int durationMinutes, String eventLocation);

    SqlRowSet listAllSongs();

}
