package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.Playlist;
import com.techelevator.model.Song;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSharedDao implements SharedDao
{
    private JdbcTemplate jdbcTemplate;

    public JdbcSharedDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public List<Event> getEventByName(String eventName) {
        List<Event> eventList = new ArrayList<>();

        String sql = "SELECT event_id, event_host, event_dj, playlist_id, genre_id," +
                " event_name, event_date, start_time, duration_minutes, event_location " +
                "FROM event " +
                "WHERE event_name LIKE ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventName);
        while (results.next()) {
            Event event = mapRowToEvent(results);
            eventList.add(event);
        }
        return eventList;
    }
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

    @Override
    public List<Song> getAvailableSongList(int genreId) {
        List<Song> availableSongList = new ArrayList<>();
        String sql = "SELECT song_id, song_title, song_artist, song.genre_id " +
                "FROM song " +
                "INNER JOIN genre ON genre.genre_id = song.genre_id " +
                "WHERE genre.genre_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genreId);
        while (results.next()) {
            Song song = mapRowToSong(results);
            availableSongList.add(song);
        }
        return availableSongList;

    }

    @Override
    public void addSongToPlaylist(int songId, int playListId) {
        //we need to insert into song playlist and then return songList
        String sql = "INSERT INTO song_playlist (song_id, playlist_id) VALUES (?, ?); ";
       jdbcTemplate.update(sql, songId, playListId);
    }



    @Override
    public List<Song> getCurrentPlaylist(int playlistId) {
        List<Song> currentSongPlaylist = new ArrayList<>();
    String sql = "SELECT song.song_title, song.song_artist, song.song_id, song.genre_id " +
            "FROM song " +
            "INNER JOIN song_playlist ON song_playlist.song_id = song.song_id " +
            "WHERE song_playlist.playlist_id = ?;";
    SqlRowSet results = jdbcTemplate.queryForRowSet(sql, playlistId);
        while(results.next()) {
        Song song = mapRowToSong(results);
        currentSongPlaylist.add(song);
        }

        return currentSongPlaylist;
    }


    private Song mapRowToSong(SqlRowSet results) {
        Song song = new Song();
        song.setSongTitle(results.getString("song_title"));
        song.setSongArtist(results.getString("song_artist"));
        song.setSongId(results.getLong("song_id"));
        song.setGenreId(results.getLong("genre_id"));
       return song;
    }
    private Playlist mapRowToPlaylist(SqlRowSet results) {
        Playlist playlist = new Playlist();
        playlist.setPlaylistId(results.getInt("playlist_id"));
        playlist.setPlaylistName(results.getString("playlist_name"));

        return playlist;
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
