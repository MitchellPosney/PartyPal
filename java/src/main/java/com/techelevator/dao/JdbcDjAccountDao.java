package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.Genre;
import com.techelevator.model.Song;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcDjAccountDao implements DjAccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcDjAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
//    @Override
//    public void songCreate(long genre_id, String song_title, String song_artist)
//    {
//        // create song
//        String insertSong = "INSERT INTO song (genre_id,song_title,song_artist) values(?,?,?)";
//        jdbcTemplate.update(insertSong, genre_id, song_title, song_artist);
//    }
//    @Override
//    public void songRemove(long songId)
//    {
//        String sql = "DELETE FROM song WHERE id = ? ";
//        jdbcTemplate.update(sql, songId);
//    }
//
//    @Override
//    public void addSongToPlaylist(long songId, long playlistId)
//    {
//        // create song
//        String insertSong = "INSERT INTO song_playlist (song_id,playlist_id) values(?,?)";
//        jdbcTemplate.update(insertSong, songId, playlistId);
//    }
//    @Override
//    public void removeSongFromPlaylist(long songId, long playlistId)
//    {
//        String sql = "DELETE FROM song_playlist WHERE song_id = ? AND playlist_id = ? ";
//        jdbcTemplate.update(sql, songId, playlistId);
//    }

    @Override
    public Event getEventByID(int eventId) {
        Event event = null;
        String sql = "SELECT * " +
                "FROM event " +
                "WHERE event_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventId);
        if (results.next()) {
            event = mapRowToEvent(results);
        }
        return event;
    }

    public Genre getGenreById(int genreId) {
        Genre genre = null;
        String sql = "SELECT * " +
                "FROM genre " +
                "WHERE genre_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genreId);
        if (results.next()) {
            genre = mapRowToGenre(results);
        }
        return genre;
    }

    @Override
    public Genre createGenre(Genre genre) {
        String sql = "INSERT INTO genre(genre_name) " +
                "VALUES (?) RETURNING genre_id;";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class, genre.getGenreName());

        return getGenreById(newId);
    }

    @Override
    public void deleteGenre(int genreId) {

            String sql1 = " UPDATE event SET genre_id = ? WHERE genre_id = ?;";
            jdbcTemplate.update(sql1, null, genreId);

            String sql2 = " UPDATE song SET genre_id = ? WHERE genre_id = ?;";
            jdbcTemplate.update(sql2, null, genreId);

            String sql = " DELETE FROM genre WHERE genre_id = ?;";
            jdbcTemplate.update(sql,genreId);

    }


    @Override
    public Event createEvent(Event event, User user) {
        String sql = "INSERT INTO event(event_host, event_dj, playlist_id, event_name, genre_id, event_date, start_time, duration_minutes, event_location) " +
                "VALUES (?,?,?,?,?,?,?,?,?) RETURNING event_id;";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class, event.getEventHostID(), user.getId(), event.getPlaylistID(), event.getEventName(),
        event.getGenreId(), event.getEventDate(), event.getStartTime(), event.getEventMinutes(), event.getEventLocation());

        return getEventByID(newId);
    }

    @Override
    public SqlRowSet listAllSongs()
    {
        String availableSongs = "SELECT * FROM song";
        List<Song> songs = new ArrayList<>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(availableSongs);
        while (rowSet.next())
        {
            songs.add(mapRowToSong(rowSet));
        }
        return rowSet;
    }

    @Override
    public void addSongToGenre(int songId, Genre genre) {
        String sql = " UPDATE song SET genre_id = ? WHERE song_id = ?;";
        jdbcTemplate.update(sql, genre.getGenreId(), songId);
    }

    @Override
    public void deleteSongFromGenre(int songId, Genre genre) {
        String sql = " UPDATE song SET genre_id = ? WHERE song_id = ? AND genre_id = ?;";
        jdbcTemplate.update(sql, null, songId, genre.getGenreId());
    }

    private Genre mapRowToGenre (SqlRowSet results){
        Genre genre = new Genre();
        genre.setGenreId(results.getInt("genre_id"));
        genre.setGenreName(results.getString("genre_name"));
        return genre;
    }

    private Song mapRowToSong(SqlRowSet rs)
    {
        Song song = new Song();
        song.setGenreId(rs.getLong("genre_id"));
        song.setSongArtist(rs.getString("song_title"));
        song.setSongTitle(rs.getString("song_artist"));
        return song;
    }

    private Event mapRowToEvent(SqlRowSet results) {
        Event event = new Event();
        event.setEventId(results.getInt("event_id"));
//        event.setEventHost(results.getString("host_name"));
//        event.setEventDJ(results.getString("dj_name"));
        event.setEventName(results.getString("event_name"));
        event.setEventHostID(results.getInt("event_host"));
        event.setEventDJId(results.getInt("event_dj"));
        event.setPlaylistID(results.getInt("playlist_id"));
        event.setGenreId(results.getInt("genre_id"));
        event.setEventDate(results.getDate("event_date"));
        event.setStartTime(results.getTime("start_time"));
        event.setEventMinutes(results.getInt("duration_minutes"));
        event.setEventLocation(results.getString("event_location"));


        return event;


    }
}
