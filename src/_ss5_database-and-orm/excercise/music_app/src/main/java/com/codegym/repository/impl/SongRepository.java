package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import com.codegym.repository.BaseRepository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class SongRepository implements ISongRepository {
    @Override
    public List<Song> findAll() {
        String queryStr = "SELECT s FROM Song AS s";
        TypedQuery<Song> query = BaseRepository.entityManager.createQuery(queryStr, Song.class);
        return query.getResultList();
    }

    @Override
    public Song findOne(Long id) {
        String queryStr = "SELECT s FROM Song AS s WHERE s.songId = :id";
        TypedQuery<Song> query = BaseRepository.entityManager.createQuery(queryStr, Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(song);
        entityTransaction.commit();
    }

    @Override
    public void update(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(song);
        entityTransaction.commit();
    }

    @Override
    public void delete(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findOne(song.getSongId()));
        entityTransaction.commit();
    }

    @Override
    public List<Song> search(String songName) {
        String queryStr = "SELECT s FROM Song AS s WHERE s.songName like :name";
        TypedQuery<Song> query = BaseRepository.entityManager.createQuery(queryStr, Song.class);
        query.setParameter("name", "%" + songName + "%");
        return query.getResultList();
    }
}
