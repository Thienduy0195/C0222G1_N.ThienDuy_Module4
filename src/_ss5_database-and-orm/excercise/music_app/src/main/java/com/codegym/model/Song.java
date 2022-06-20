package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;
    private String songName;
    private String artist;
    private String songType;
    private String songPath;

    public Song() {
    }

    public Song(String songName, String artist, String songType, String songPath) {
        this.songName = songName;
        this.artist = artist;
        this.songType = songType;
        this.songPath = songPath;
    }

    public Song(Long songId, String songName, String artist, String songType, String songPath) {
        this.songId = songId;
        this.songName = songName;
        this.artist = artist;
        this.songType = songType;
        this.songPath = songPath;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }
}
