package com.codegym.music_app.service;

import com.codegym.music_app.dto.SongDTO;
import com.codegym.music_app.model.Song;
import com.codegym.music_app.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    @Qualifier("iSongRepo")
    ISongRepository iSongRepo;

    @Override
    public List<Song> findAll() {
        return iSongRepo.findAll();
    }

    @Override
    public SongDTO findById(Integer id) {
        Song song = iSongRepo.findById(id).orElse(null);
        SongDTO songDTO = new SongDTO(song.getId(), song.getName(), song.getSinger(), song.getMusicType());
        return songDTO;
    }

    @Override
    public void save(Song song) {
        iSongRepo.save(song);
    }

    @Override
    public void save(SongDTO songDto) {
        Song song = new Song(songDto.getId(),songDto.getName(),songDto.getSinger(),songDto.getMusicType());
        iSongRepo.save(song);
    }
}
