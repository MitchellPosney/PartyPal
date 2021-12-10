package com.techelevator.model;

public class Song
{
    private Long genreId;
    private String songTitle;
    private String songArtist;

    public Song()
    {
    }

    public Song(Long genreId, String songTitle, String songArtist)
    {
        this.genreId = genreId;
        this.songTitle = songTitle;
        this.songArtist = songArtist;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }
}
