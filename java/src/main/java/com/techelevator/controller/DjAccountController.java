package com.techelevator.controller;

import com.techelevator.dao.JdbcDjAccount;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Song;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

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
    @RequestMapping(value = "/addSongToPlaylist", method = RequestMethod.POST)
    public void addSongToPlaylist(@PathVariable long songId, long playlistId) {
        dao.addSongToPlaylist(songId,playlistId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "removeSongFromPlaylist", method = RequestMethod.DELETE)
    public void removeSongFromPlaylist(@PathVariable long songId, long playlistId) {
        dao.removeSongFromPlaylist(songId,playlistId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/DJ/availableSongs", method = RequestMethod.GET)
    public void availableSongs() {
        dao.listAllSongs();
    }
}
