package com.techelevator.controller;


import com.techelevator.dao.HostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Event;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

//not working
//todo

@PreAuthorize("isAuthenticated()")
@CrossOrigin
@RestController
public class EventHostController {

    private HostDao eventHostDao;
    private UserDao userDao;

    public EventHostController(UserDao userDao, HostDao eventHostDao) {
        this.eventHostDao = eventHostDao;
        this.userDao = userDao;
    }

    //this is not going to work because principal is not working yet
    @RequestMapping (path = "/edit/event/{eventId}", method = RequestMethod.PUT)
    public boolean updateEvent(Principal principal, @Valid @RequestBody Event event, @PathVariable int eventId) {
        boolean result = eventHostDao.updateEvent(event, eventId);

        return result;
    }

    //todo
    //hosts have power to veto songs


}
