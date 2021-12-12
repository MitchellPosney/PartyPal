package com.techelevator.dao;

import com.techelevator.model.Event;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcEventHostDao implements HostDao {
    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean updateEvent(Event updatedEvent, int eventId) {
        String sql = "UPDATE event " +
                "SET genre_id = ?, " +
                "event_name = ?, " +
                "start_time = ?, " +
                "duration_minutes = ?, " +
                "event_location = ? " +
                "WHERE event_id = ?;";

        return jdbcTemplate.update(sql, updatedEvent.getGenreId(), updatedEvent.getEventName(), updatedEvent.getStartTime(),
               updatedEvent.getEventMinutes(), updatedEvent.getEventLocation(), eventId) == 1;
    }

}
