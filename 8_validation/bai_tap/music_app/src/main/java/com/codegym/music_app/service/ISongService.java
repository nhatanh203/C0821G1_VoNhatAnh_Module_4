package com.codegym.music_app.service;

import com.codegym.music_app.dto.SongDTO;
import com.codegym.music_app.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    SongDTO findById(Integer id);

    void save(Song song);

    void save(SongDTO songDto);
}
