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
@CrossOrigin
@RestController
public class SharedController {

    private SharedDao sharedDao;
    private UserDao userDao;


    public SharedController(SharedDao sharedDao, UserDao userDao) {
        this.sharedDao = sharedDao;
        this.userDao = userDao;
    }

    //working
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

    //working
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

    //working
    @PreAuthorize("permitAll")
    @RequestMapping(path = "events/songs/{eventId}", method = RequestMethod.GET)
    public List<Song> getAvailableSong(@PathVariable int eventId) throws EventNotFoundException {
        Event event = sharedDao.getEventByID(eventId);
        List<Song> availableSongs = new ArrayList<>();
        if (event == null) {

        } else {
            availableSongs = sharedDao.getAvailableSongList(event.getGenreId());
        }

            return availableSongs;
    }

    //working
    @PreAuthorize("permitAll")
    @RequestMapping(path = "events/playlist/{eventId}", method = RequestMethod.GET)
    public List<Song> getCurrentPlaylist(@PathVariable int eventId) throws EventNotFoundException {
        Event event = sharedDao.getEventByID(eventId);
        List<Song> availableSongs = new ArrayList<>();
        if (event == null) {

        } else {
            availableSongs = sharedDao.getCurrentPlaylist(event.getPlaylistID());
        }
        return availableSongs;
    }


    //working
    @PreAuthorize("permitAll")
    @RequestMapping(path = "events/playlist/{songId}", method = RequestMethod.PUT)
    public void addSongToPlaylist(@RequestBody Event event, @PathVariable int songId) throws Exception {

        sharedDao.addSongToPlaylist(songId, event.getPlaylistID());
    }







}
