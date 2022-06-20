package com.codegym.service.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import com.codegym.repository.impl.SongRepository;
import com.codegym.service.ISongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    ISongRepository songRepository = new SongRepository();


    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findOne(Long id) {
        return songRepository.findOne(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void update(Song song) {
        songRepository.update(song);
    }

    @Override
    public void delete(Song song) {
        songRepository.delete(song);
    }

    @Override
    public List<Song> search(String songName) {
        return songRepository.search(songName);
    }


}
