package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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
        Event results = jdbcTemplate.queryForRowSet(event,eventName);
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
    public String getPlaylist(long playlistId)
    {
        String event = "SELECT host_name FROM host WHERE host_id = ?";
        return jdbcTemplate.queryForRowSet(event, String.class, playlistId);
    }

    private Event mapRowToEvent(SqlRowSet rs)
    {
        return = new Event(rs.getString("event_host"),rs.getString("event_dj"), (ArrayList<Song>) rs.getObject("event_id"),rs.getString("event_name"),rs.getDate("event_date"),rs.getTime("start_time"),rs.getInt("duration_minutes"),rs.getString("event_location"));
    }
}
