package com.example.latriumback.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Long idPost;
    private String score;
    private String title;
    private String content;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="idUser", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="idBoard", nullable=false)
    private Board board;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    public Post() {
    }

    public String getScore() {
        return score;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Long getIdPost() {
        return idPost;
    }

    public User getUser() {
        return user;
    }

    public Board getBoard() {
        return board;
    }

    public Set<Comment> getComments() {
        return comments;
    }
}
