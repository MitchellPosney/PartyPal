package com.techelevator.controller;

import com.techelevator.dao.JdbcDjAccount;
import com.techelevator.dao.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/DJ")
public class DjAccountController
{
    private JdbcDjAccount dao;
    private UserDao userDao;
    private JdbcTemplate jdbcTemplate;

    public DjAccountController(JdbcDjAccount dao, UserDao userDao, JdbcTemplate jdbcTemplate)
    {
        this.dao = dao;
        this.userDao = userDao;
        this.jdbcTemplate = jdbcTemplate;
    }
    /*
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/songCreate", method = RequestMethod.POST)
    public void createSong(@PathVariable int genreId, String songTitle, String songArtist) {
        dao.songCreate(genreId,songTitle,songArtist);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeSong(@PathVariable long id) {
        dao.songRemove(id);
    }*/

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(path = "/addSongToPlaylist", method = RequestMethod.POST)
    public void addSongToPlaylist(@PathVariable long songId, long playlistId) {
        dao.addSongToPlaylist(songId,playlistId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/removeSongFromPlaylist", method = RequestMethod.DELETE)
    public void removeSongFromPlaylist(@PathVariable long songId, long playlistId) {
        dao.removeSongFromPlaylist(songId,playlistId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/availableSongs", method = RequestMethod.GET)
    public SqlRowSet availableSongs() {
        return dao.listAllSongs();
    }

}
