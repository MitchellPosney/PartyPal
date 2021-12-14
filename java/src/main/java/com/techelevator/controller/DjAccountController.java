package com.techelevator.controller;

import com.techelevator.dao.DjAccountDao;
import com.techelevator.dao.JdbcDjAccountDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Event;
import com.techelevator.model.Genre;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


@PreAuthorize("isAuthenticated()")
@CrossOrigin
@RestController
@RequestMapping(path="/DJ")

public class DjAccountController {

    private DjAccountDao djDao;
    private UserDao userDao;

    public DjAccountController(DjAccountDao djDao, UserDao userDao) {
        this.djDao = djDao;
        this.userDao = userDao;
    }

    //not working authorization
    //todo
    //front end make sure they put in amount of time
    @PreAuthorize("hasRole('ROLE_DJ')")
    @RequestMapping (path = "/create/event", method = RequestMethod.POST)
    public Event createEvent(Principal principal, @Valid @RequestBody Event event) {
       User user = userDao.findByUsername(principal.getName());
        return djDao.createEvent(event, user);
    }


    //working
    @PreAuthorize("hasRole('ROLE_DJ')")
    @RequestMapping(path = "/add/song/{songId}", method = RequestMethod.PUT)
    public void addSongToGenre(@RequestBody Genre genre, @PathVariable int songId) throws Exception {
        djDao.addSongToGenre(songId, genre);
    }

    //working
    @PreAuthorize("hasRole('ROLE_DJ')")
    @RequestMapping(path = "/remove/song/{songId}", method = RequestMethod.PUT)
    public void removeSongFromGenre(@RequestBody Genre genre, @PathVariable int songId) throws Exception {
        djDao.deleteSongFromGenre(songId, genre);
    }

}
