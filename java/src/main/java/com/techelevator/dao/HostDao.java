package com.techelevator.dao;

import com.techelevator.model.Event;

public interface HostDao {

    boolean updateEvent(Event event, int eventId);
}
