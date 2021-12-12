package com.techelevator.controller;

import com.techelevator.dao.JdbcDjAccountDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Event;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping(path="/DJ")
public class DjAccountController
{
    private JdbcDjAccountDao djDao;
    private UserDao userDao;
    private JdbcTemplate jdbcTemplate;

    public DjAccountController(JdbcDjAccountDao djDao, UserDao userDao, JdbcTemplate jdbcTemplate)
    {
        this.djDao = djDao;
        this.userDao = userDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping (path = "/create/event", method = RequestMethod.POST)
    public Event createEvent(Principal principal, @Valid @RequestBody Event event) {
       User user = userDao.findByUsername(principal.getName());
        return djDao.createEvent(event, user);
    }


}
