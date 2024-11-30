package com.example.latriumback.dto.post;

import com.example.latriumback.entity.Comment;

import java.util.Date;

public class CommentDTO {
    private Long idComment;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    public CommentDTO(Long idComment, String content, Date createdAt, Date updatedAt) {
        this.idComment = idComment;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getContent() {
        return content;
    }

    public Long getIdComment() {
        return idComment;
    }

    public static CommentDTO convertToDTO(Comment comment) {
        return new CommentDTO(comment.getIdComment(), comment.getContent(), comment.getCreatedAt(), comment.getUpdatedAt());
    }
}
