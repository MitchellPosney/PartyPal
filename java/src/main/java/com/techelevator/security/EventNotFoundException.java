package com.techelevator.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "Event not found.")
public class EventNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public EventNotFoundException() {
        super("Event Details not found.");
    }
}
