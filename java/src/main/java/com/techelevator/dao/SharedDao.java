package com.techelevator.dao;

import com.techelevator.model.Event;

public interface SharedDao
{
    Event getEventByName(String eventName);
    Event getEventPlaylist(int eventId);
    Event getAvailableSongs(int genreId);
    boolean addSongToPlaylist(int songId);
}
