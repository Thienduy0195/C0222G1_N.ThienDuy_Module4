package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    Song findOne(Long id);

    void save(Song song);

    void update(Song song);

    void delete(Song song);

    List<Song> search(String songName);

}
