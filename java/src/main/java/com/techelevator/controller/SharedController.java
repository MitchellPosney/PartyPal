package com.techelevator.controller;

import com.techelevator.dao.JdbcSharedDao;
import com.techelevator.dao.SharedDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Event;
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
    @RequestMapping(path = "events/{eventName}", method = RequestMethod.GET)
    public List<Event> getEventByName(@PathVariable String eventName) throws EventNotFoundException {
        List<Event> event = sharedDao.getEventByName(eventName);
        if (event.size() == 0 || event == null) {
            throw new EventNotFoundException();
        } else {
            return event;
        }
    }

    @RequestMapping(path = "playlist/{playlistID}", method = RequestMethod.GET)
    public ArrayList<Song> getPlaylist(@PathVariable int playlistId) throws EventNotFoundException {
        Event event = sharedDao.getEventPlaylist(playlistId);
        if (event == null) {
            throw new EventNotFoundException();
        } else {
            return event.getPlaylist();
        }
    }

    @RequestMapping(path = "availableSongs/{genreID}", method = RequestMethod.GET)
    public ArrayList<Song> getAvailableSongs(@PathVariable int genreId) throws EventNotFoundException {
        Event event = sharedDao.getAvailableSongs(genreId);
        if (event == null) {
            throw new EventNotFoundException();
        } else {
            return event.getPlaylist();
        }
    }
    @RequestMapping(path = "/addSongToPlaylist/{songID}", method = RequestMethod.PUT)
    public boolean addSongToPlaylist(@PathVariable int songId) throws EventNotFoundException {
        boolean result = false;
        result = sharedDao.addSongToPlaylist(songId);
       return result;
    }






}
