package com.codegym.music_app.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SongDTO implements Validator {
    private Integer id;

    private String name;

    private String singer;

    private String musicType;

    public SongDTO() {
    }

    public SongDTO(String name, String singer, String musicType) {
        this.name = name;
        this.singer = singer;
        this.musicType = musicType;
    }

    public SongDTO(Integer id, String name, String singer, String musicType) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.musicType = musicType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO song = (SongDTO) target;

        String name = song.getName();
        ValidationUtils.rejectIfEmpty(errors, "name", "empty.invalidFormat");
        if (name.length() > 800) {
            errors.rejectValue("name", "nameLength.invalidFormat");
        }
        if (!name.matches("^[a-zA-Z0-9]*$")) {
            errors.rejectValue("name", "nameMatch.invalidFormat");
        }

        String singer = song.getSinger();
        ValidationUtils.rejectIfEmpty(errors, "singer", "empty.invalidFormat");
        if (singer.length() > 300) {
            errors.rejectValue("singer", "singerLength.invalidFormat");
        }
        if (!singer.matches("^[a-zA-Z]*$")) {
            errors.rejectValue("singer", "singerMatch.invalidFormat");
        }

        String musicType = song.getMusicType();
        ValidationUtils.rejectIfEmpty(errors, "musicType", "empty.invalidFormat");
        if (musicType.length() > 1000) {
            errors.rejectValue("musicType", "musicTypeLength.invalidFormat");
        }
        if (!musicType.matches("^[a-zA-Z0-9]*$")) {
            errors.rejectValue("musicType", "musicTypeMatch.invalidFormat");
        }
    }
}
