package com.example.android.musicalstructureapp;

public class Song {
    private String artistName;
    private String album;
    private int albumImage;
    private String song;

    public Song(String artistName, String album, int albumImage, String song) {
        this.artistName = artistName;
        this.album = album;
        this.albumImage = albumImage;
        this.song = song;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbum() {
        return album;
    }

    public int getAlbumImage() {
        return albumImage;
    }

    public String getSong() {
        return song;
    }
}
