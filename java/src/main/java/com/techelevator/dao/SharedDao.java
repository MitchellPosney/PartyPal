package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.Playlist;
import com.techelevator.model.Song;

import java.util.List;

public interface SharedDao
{
    List<Event> getEventByName(String eventName);

//    Event getEventPlaylist(int eventId);
    List<Song> getAvailableSongList(int genreId);
    Playlist addSongToPlaylist(int songId, int playList);
    Event getEventByID (int eventId);
    Playlist getCurrentPlaylist(int playlistId);
    List<Song> getCurrentSongs(int playlistId);
}
