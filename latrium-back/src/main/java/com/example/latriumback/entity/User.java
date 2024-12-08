package com.example.latriumback.entity;

import com.example.latriumback.utils.UserRole;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private long idUser;
    @Column(unique=true)
    private String username;
    private String password;
    private UserRole role;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts;

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

    @ManyToMany(mappedBy = "users")
    private Set<Board> board;

    public User() {}

    public User(Long idUser, String username, UserRole role) {
        this.idUser = idUser;
        this.username = username;
        this.role = role;
    }

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public long getIdUser() {
        return idUser;
    }

    public UserRole getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }
}
