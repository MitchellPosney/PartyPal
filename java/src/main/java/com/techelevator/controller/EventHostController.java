package com.techelevator.controller;

import com.techelevator.dao.EventHostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Event;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


@PreAuthorize("isAuthenticated()")
@RestController
public class EventHostController {

    private EventHostDao eventHostDao;
    private UserDao userDao;

    public EventHostController(UserDao userDao, EventHostDao eventHostDao) {
        this.eventHostDao = eventHostDao;
        this.userDao = userDao;
    }


    @RequestMapping (path = "/edit/event/{eventId}", method = RequestMethod.PUT)
    public boolean updateEvent(Principal principal, @Valid @RequestBody Event event, @PathVariable int eventId) {
        boolean result = eventHostDao.updateEvent(event, eventId);

        return result;
    }


}
