package com.techelevator.controller;

import com.techelevator.dao.JdbcSharedDao;
import com.techelevator.dao.SharedDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Event;
import com.techelevator.model.Playlist;
import com.techelevator.model.Song;
import com.techelevator.security.EventNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@PreAuthorize("permitAll")
@RestController
public class SharedController
{
    private SharedDao sharedDao;
    private UserDao userDao;


    public SharedController(SharedDao sharedDao, UserDao userDao) {
        this.sharedDao = sharedDao;
        this.userDao = userDao;

    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "events/find", method = RequestMethod.GET)
    public List<Event> getEventByName(@RequestParam String name) throws EventNotFoundException {
        List<Event> event = sharedDao.getEventByName(name);
        if (event.size() == 0 || event == null) {
            throw new EventNotFoundException();
        } else {
            return event;
        }
    }
    @PreAuthorize("permitAll")
    @RequestMapping(path = "events/{eventId}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable int eventId) throws EventNotFoundException {
        Event event = sharedDao.getEventByID(eventId);
        if (event == null) {
        throw new EventNotFoundException();
        } else {
        return event;
        }
    }
    @PreAuthorize("permitAll")
    @RequestMapping(path = "events/playlist/{eventId}", method = RequestMethod.GET)
    public List<Song> getAvailableSong(@PathVariable int eventId) throws EventNotFoundException {
        Event event = sharedDao.getEventByID(eventId);
        List<Song> availableSongs = new ArrayList<>();
        if (event == null) {

        } else {
            availableSongs = sharedDao.getAvailableSongList(event.getGenreId());
        }

            return availableSongs;
    }
    @PreAuthorize("permitAll")
    @RequestMapping(path = "events/playlist/{playlistId}/{songId]", method = RequestMethod.GET)
    public Playlist addSongToPlaylist(@RequestBody Event event, @PathVariable int songId) throws Exception {

//        Playlist playlist = new Playlist();
//        playlist.setPlaylistId(event.getPlaylistID());


        return sharedDao.addSongToPlaylist(songId, event.getPlaylistID());
    }

    //events{events}
    //export populated database genres
    //grab ones from spotify
    //select all songs from the genre (avilable)
    // dj playlist (empty)
    // exporting data and setting up a genre id
    //drop it in
    //put still on the same page
    //auto refresh
    //





}
