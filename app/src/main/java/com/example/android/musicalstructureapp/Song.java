package com.example.android.musicalstructureapp;

public class Song {
    private String mArtistName;
    private String mAlbum;
    private int mAlbumImage;
    private String mSong;

    public Song(String mArtistName, String mAlbum, int mAlbumImage, String mSong) {
        this.mArtistName = mArtistName;
        this.mAlbum = mAlbum;
        this.mAlbumImage = mAlbumImage;
        this.mSong = mSong;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public String getmAlbum() {
        return mAlbum;
    }

    public int getmAlbumImage() {
        return mAlbumImage;
    }

    public String getmSong() {
        return mSong;
    }
}
