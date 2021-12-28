package com.codegym.music_app.model;

import javax.persistence.*;

@Entity(name = "music_app")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "singer")
    private String singer;
    @Column(name = "music_type")
    private String musicType;

    public Song() {
    }

    public Song(Integer id, String name, String singer, String musicType) {
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
}
