package com.codegym.demo_full_md4.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user_type")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_type_id")
    private Integer id;
    @Column(name = "user_type_name")
    private String nameType;

    @OneToMany(mappedBy = "userType", cascade = CascadeType.ALL)
    private List<User> user;

    public UserType() {
    }

    public UserType(Integer id, String nameType, List<User> user) {
        this.id = id;
        this.nameType = nameType;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
