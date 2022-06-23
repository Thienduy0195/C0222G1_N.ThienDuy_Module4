package com.duynguyen.music.service;

import com.duynguyen.music.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);

    List<Song> getSongList();

    Song findOne(Long id);

    void save(Song song);

    void update(Song song);

    void delete(Song song);

    Page<Song> search(String songName, Pageable pageable);

}
