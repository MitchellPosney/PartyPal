package com.techelevator.controller;

import com.techelevator.dao.JdbcDjAccount;
import com.techelevator.dao.JdbcSharedDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Event;
import com.techelevator.model.Song;
import com.techelevator.security.EventNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;

public class SharedController
{
    private JdbcSharedDao dao;
    private UserDao userDao;
    private JdbcTemplate jdbcTemplate;

    public SharedController(JdbcSharedDao dao, UserDao userDao, JdbcTemplate jdbcTemplate)
    {
        this.dao = dao;
        this.userDao = userDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    @ResponseStatus(value = HttpStatus.FOUND)
    @RequestMapping(path = "/events/{eventName}", method = RequestMethod.GET)
    public Event getEventByName(@PathVariable String eventName) throws EventNotFoundException {
        Event event = dao.getEventByName(eventName);
        if (event == null) {
            throw new EventNotFoundException();
        } else {
            return event;
        }
    }

    @RequestMapping(path = "/playlist/{playlistID}", method = RequestMethod.GET)
    public ArrayList<Song> getPlaylist(@PathVariable int playlistId) throws EventNotFoundException {
        Event event = dao.getEventPlaylist(playlistId);
        if (event == null) {
            throw new EventNotFoundException();
        } else {
            return event.getPlaylist();
        }
    }

    @RequestMapping(path = "/availableSongs/{genreID}", method = RequestMethod.GET)
    public ArrayList<Song> getAvailableSongs(@PathVariable int genreId) throws EventNotFoundException {
        Event event = dao.getAvailableSongs(genreId);
        if (event == null) {
            throw new EventNotFoundException();
        } else {
            return event.getPlaylist();
        }
    }
    @RequestMapping(path = "/addSongToPlaylist/{songID}", method = RequestMethod.PUT)
    public boolean addSongToPlaylist(@PathVariable int songId) throws EventNotFoundException {
        boolean result = false;
        result = dao.addSongToPlaylist(songId);
       return result;
    }






}
