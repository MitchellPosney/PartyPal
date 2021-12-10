package com.techelevator.controller;

import com.techelevator.dao.JdbcDjAccount;
import com.techelevator.dao.JdbcSharedDao;
import com.techelevator.dao.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    @RequestMapping(path = "/getEventByName", method = RequestMethod.GET)
    public void getEventByName(@PathVariable String eventName) {
        dao.getEventByName(eventName);
    }

}
