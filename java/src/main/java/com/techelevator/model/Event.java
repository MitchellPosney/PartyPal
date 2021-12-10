package com.techelevator.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Event
{
    String eventHost;
    String eventDJ;
    ArrayList<Song> playlist;
    String eventName;
    Date eventDate;
    Time startTime;
    int eventMinutes;
    String eventLocation;

    public Event(String eventHost, String eventDJ, ArrayList<Song> playlist, String eventName, Date eventDate, Time startTime, int eventMinutes, String eventLocation) {
        this.eventHost = eventHost;
        this.eventDJ = eventDJ;
        this.playlist = playlist;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.eventMinutes = eventMinutes;
        this.eventLocation = eventLocation;
    }

    public String getEventHost() {
        return eventHost;
    }

    public String getEventDJ() {
        return eventDJ;
    }

    public ArrayList<Song> getPlaylist() {
        return playlist;
    }

    public String getEventName() {
        return eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public int getEventMinutes() {
        return eventMinutes;
    }

    public String getEventLocation() {
        return eventLocation;
    }
}
