package com.duynguyen.music.service.impl;

import com.duynguyen.music.model.Song;
import com.duynguyen.music.repository.ISongRepository;
import com.duynguyen.music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    ISongRepository iSongRepository;

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return iSongRepository.findAllSongPage(pageable);
    }

    @Override
    public List<Song> getSongList() {
        return iSongRepository.findAllSong();
    }

    @Override
    public Song findOne(Long id) {
        return iSongRepository.getSongById(id);
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public void update(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public void delete(Song song) {
        iSongRepository.deleteSong(song.getSongId());
    }

    @Override
    public Page<Song> search(String songName, Pageable pageable) {
        return iSongRepository.searchBySongName("%" + songName + "%", pageable);
    }
}
