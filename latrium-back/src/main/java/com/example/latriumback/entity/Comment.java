package com.example.latriumback.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private Long idComment;
    private String content;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="idUser", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="idPost", nullable=false)
    private Post post;

    public Comment() {}

    public Comment(Long idComment, String content, Date createdAt, Date updatedAt, User user, Post post) {
        this.idComment = idComment;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.post = post;
    }

    public Long getIdComment() {
        return idComment;
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

    public User getUser() {
        return user;
    }

    public Post getPost() {
        return post;
    }
}
