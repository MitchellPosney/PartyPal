package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;

@Component
public class JdbcDjAccount implements DjAccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcDjAccount(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void songCreate(long genre_id, String song_title, String song_artist)
    {
        // create song
        String insertSong = "INSERT INTO song (genre_id,song_title,song_artist) values(?,?,?)";
        jdbcTemplate.update(insertSong, genre_id, song_title, song_artist);
    }
    @Override
    public void songRemove(long songId)
    {
        String sql = "DELETE FROM song WHERE id = ? ";
        jdbcTemplate.update(sql, songId);
    }

    @Override
    public void addSongToPlaylist(long songId, long playlistId)
    {
        // create song
        String insertSong = "INSERT INTO song_playlist (song_id,playlist_id) values(?,?)";
        jdbcTemplate.update(insertSong, songId, playlistId);
    }
    @Override
    public void removeSongFromPlaylist(long songId, long playlistId)
    {
        String sql = "DELETE FROM song_playlist WHERE song_id = ? AND playlist_id = ? ";
        jdbcTemplate.update(sql, songId, playlistId);
    }
    @Override
    public void createEvent(int hostId, int djId, int playlistId, String eventName, Date eventDate, Time startTime, int durationMinutes, String eventLocation)
    {
        String sql = "INSERT INTO event(event_host,event_dj,playlist_id,event_name,event_date,start_time,duration_minutes,event_location)";
    }

    @Override
    public SqlRowSet listAllSongs()
    {
        String availableSongs = "SELECT * FROM song";

        return jdbcTemplate.queryForRowSet(availableSongs);
    }
}
