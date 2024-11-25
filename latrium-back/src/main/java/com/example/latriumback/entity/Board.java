package com.example.latriumback.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_board")
    private Long idBoard;
    private String name;
    private String description;
    @Column(name = "created_at")
    private Date createdAt;

    @OneToMany(mappedBy = "board")
    private Set<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "membership",
            joinColumns = @JoinColumn(name = "id_board"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    private Set<User> users;

    @ManyToMany
    @JoinTable(
            name = "board_theme",
            joinColumns = @JoinColumn(name = "id_board"),
            inverseJoinColumns = @JoinColumn(name = "id_theme"))
    private Set<Theme> themes;

    public Board() {}

    public Long getIdBoard() {
        return idBoard;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
