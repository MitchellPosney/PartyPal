package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.Song;
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

//    @Override
//    public LigetEventByName(String eventName) {
//        String event = "SELECT * FROM event WHERE event_name = ?";
//        Event[] results = jdbcTemplate.queryForRowSet(event,eventName);
//        mapRowToEvent();
//    }

    @Override
    public List<Event> getEventByName(String eventName) {
        List<Event> eventList = new ArrayList<>();

        String sql = "SELECT event_id, event_host, event_dj, playlist_id, genre_id," +
                " event_name, event_date, start_time, duration_minutes, event_location " +
                "FROM event " +
//                "INNER JOIN dj ON event_dj = dj_id " +
//                "INNER JOIN hosts ON event_host = host_id dj_name, host_name," +
                "WHERE event_name LIKE ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventName);
        while (results.next()) {
            Event event = mapRowToEvent(results);
            eventList.add(event);
        }
        return eventList;
    }

    @Override
    public Event getEventPlaylist(int eventId) {
        return null;

    }

    @Override
    public Event getAvailableSongs(int genreId) {
        return null;
    }

    @Override
    public boolean addSongToPlaylist(int songId) {
        return false;
    }

    public String getDj(long djId) {
        String event = "SELECT dj_name FROM dj WHERE dj_id = ?";
        return jdbcTemplate.queryForObject(event, String.class, djId);
    }

    public String getHost(long hostId) {
        String event = "SELECT host_name FROM host WHERE host_id = ?";
        return jdbcTemplate.queryForObject(event, String.class, hostId);
    }

    public List<Song> getPlaylist(long playlistId) {
        String event2 = "SELECT *, c.username AS sender_name, d.username AS receiver_name FROM song_playlist " +
                "JOIN song_playlist AS a ON a.account_id = transfers.account_from " +
                "JOIN accounts AS b ON b.account_id = transfers.account_to " +
                "JOIN users AS c ON c.user_id = a.user_id " +
                "JOIN users AS d ON d.user_id = b.user_id " +
                "WHERE transfers.account_from = ? OR transfers.account_to = ?;";

        String event = "SELECT * FROM song " +
                        "JOIN song_playlist AS a ON a.account_id = transfers.account_from " +
                        "WHERE playlist_id = ?";
        List<Song> songs = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(event, String.class, playlistId);
        while(results.next()) {
            Song song = mapRowToSong(results);
            songs.add(song);
        }
        return songs;
    }

    private Song mapRowToSong(SqlRowSet rs) {
        return new Song(rs.getLong("genre_id"),rs.getString("song_title"),rs.getString("song_artist"));
    }

    private Event mapRowToEvent(SqlRowSet results) {
        Event event = new Event();
        event.setEventId(results.getInt("event_id"));
//        event.setEventHost(results.getString("host_name"));
//        event.setEventDJ(results.getString("dj_name"));
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
