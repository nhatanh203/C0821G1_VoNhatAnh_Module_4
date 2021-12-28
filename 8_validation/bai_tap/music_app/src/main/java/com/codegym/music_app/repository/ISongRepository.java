package com.codegym.music_app.repository;

import com.codegym.music_app.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository(value = "iSongRepo")
public interface ISongRepository extends JpaRepository<Song,Integer> {
}
