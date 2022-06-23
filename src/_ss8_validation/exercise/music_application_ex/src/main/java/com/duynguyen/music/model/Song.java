package com.duynguyen.music.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;

    @NotEmpty
    @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of product!")
    private String songName;

    @NotEmpty
    @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of product!")
    private String artist;

    @NotEmpty
    @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of product!")
    private String songType;

    private String songPath;

    public Song() {
    }

    public Song(Long songId, @NotEmpty @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of product!") String songName, @NotEmpty @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of product!") String artist, @NotEmpty @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of product!") String songType, String songPath) {
        this.songId = songId;
        this.songName = songName;
        this.artist = artist;
        this.songType = songType;
        this.songPath = songPath;
    }

    public Song(@NotEmpty @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of product!") String songName, @NotEmpty @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of product!") String artist, @NotEmpty @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of product!") String songType, String songPath) {
        this.songName = songName;
        this.artist = artist;
        this.songType = songType;
        this.songPath = songPath;
    }

    public Song(@NotEmpty @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of product!") String songName) {
        this.songName = songName;
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
