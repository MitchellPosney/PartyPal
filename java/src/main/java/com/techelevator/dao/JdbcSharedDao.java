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

    @Override
    public void getEventByName(String eventName)
    {
        String event = "SELECT * FROM event WHERE event_name = ?";
        Event[] results = jdbcTemplate.queryForRowSet(event,eventName);
        mapRowToEvent();
    }

    public String getDj(long djId)
    {
        String event = "SELECT dj_name FROM dj WHERE dj_id = ?";
        return jdbcTemplate.queryForObject(event, String.class, djId);
    }
    public String getHost(long hostId)
    {
        String event = "SELECT host_name FROM host WHERE host_id = ?";
        return jdbcTemplate.queryForObject(event, String.class, hostId);
    }
    public List<Song> getPlaylist(long playlistId)
    {
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

    private Song mapRowToSong(SqlRowSet rs)
    {
        return new Song(rs.getLong("genre_id"),rs.getString("song_title"),rs.getString("song_artist"));
    }

    private Event mapRowToEvent(SqlRowSet rs)
    {
        return new Event(rs.getString("event_host"),rs.getString("event_dj"), (ArrayList<Song>) rs.getObject("event_id"),rs.getString("event_name"),rs.getDate("event_date"),rs.getTime("start_time"),rs.getInt("duration_minutes"),rs.getString("event_location"));
    }
}
