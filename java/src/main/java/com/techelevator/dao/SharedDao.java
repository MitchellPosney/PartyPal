package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.Playlist;
import com.techelevator.model.Song;

import java.util.List;

public interface SharedDao {

    List<Event> getEventByName(String eventName);

    List<Song> getAvailableSongList(int genreId);

    void addSongToPlaylist(int songId, int playList);

    Event getEventByID (int eventId);

    List<Song> getCurrentPlaylist(int playlistId);
}
