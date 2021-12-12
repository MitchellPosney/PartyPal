package com.techelevator.dao;

import com.techelevator.model.Event;

public interface EventHostDao {
    boolean updateEvent(Event event, int eventId);
}
