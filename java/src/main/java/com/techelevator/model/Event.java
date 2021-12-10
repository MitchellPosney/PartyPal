package com.techelevator.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Event {
    private int eventId;
    private String eventHost;
    private int eventHostID;
    private String eventDJ;
    private int eventDJId;
    private int genreId;
    private ArrayList<Song> playlist;
    private int playlistID;
    private String eventName;
    private Date eventDate;
    private Time startTime;
    private int eventMinutes;
    private String eventLocation;

    public Event() {

    }

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

    public int getEventHostID() { return eventHostID; }

    public int getEventDJId() { return eventDJId; }

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

    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    //setters
    public void setEventHost(String eventHost) { this.eventHost = eventHost; }

    public void setEventHostID(int eventHostID) { this.eventHostID = eventHostID; }

    public void setEventDJ(String eventDJ) { this.eventDJ = eventDJ; }

    public void setEventDJId(int eventDJId) { this.eventDJId = eventDJId; }

    public void setPlaylist(ArrayList<Song> playlist) { this.playlist = playlist; }

    public void setEventName(String eventName) { this.eventName = eventName; }

    public void setEventDate(Date eventDate) { this.eventDate = eventDate; }

    public void setStartTime(Time startTime) { this.startTime = startTime; }

    public void setEventMinutes(int eventMinutes) { this.eventMinutes = eventMinutes; }

    public void setEventLocation(String eventLocation) { this.eventLocation = eventLocation; }


}
