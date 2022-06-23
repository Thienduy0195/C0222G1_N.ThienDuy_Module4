package com.duynguyen.music.repository;

import com.duynguyen.music.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ISongRepository extends JpaRepository<Song, Long> {
    @Query(value = "select * from song", nativeQuery = true)
    List<Song> findAllSong();

    @Query(value = "select * from song", nativeQuery = true)
    Page<Song> findAllSongPage(Pageable pageable);

    @Query(value = "select * from song where song_id = :id", nativeQuery = true)
    Song getSongById(@Param("id") Long id);

    @Query(value = "delete from song where song_id=:id", nativeQuery = true)
    @Modifying
    void deleteSong(@Param("id") Long id);

    @Query(value = "select * from song where song_name like :songName", nativeQuery = true)
    Page<Song> searchBySongName(@Param("songName") String songName, Pageable pageable);
}
