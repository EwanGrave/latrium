package com.example.latriumback.dto;


import java.util.Date;

public class PostDTO {
    private String score;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    public PostDTO(String score, String title, String content, Date createdAt, Date updatedAt) {
        this.score = score;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
}
