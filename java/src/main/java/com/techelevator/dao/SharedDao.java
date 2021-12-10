package com.techelevator.dao;

import com.techelevator.model.Event;

import java.util.List;

public interface SharedDao
{
    List<Event> getEventByName(String eventName);
    Event getEventPlaylist(int eventId);
    Event getAvailableSongs(int genreId);
    boolean addSongToPlaylist(int songId);
}
