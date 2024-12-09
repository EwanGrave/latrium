package com.example.latriumback.dto.post;

import com.example.latriumback.dto.user.UserDTO;
import com.example.latriumback.entity.Comment;

import java.util.Date;

public class CommentWithoutPostDTO {
    private Long idComment;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private UserDTO user;

    public CommentWithoutPostDTO(Long idComment, String content, Date createdAt, Date updatedAt, UserDTO user) {
        this.idComment = idComment;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
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

    public UserDTO getUser() {
        return user;
    }

    public static CommentWithoutPostDTO convertToDTO(Comment comment) {
        return new CommentWithoutPostDTO(
                comment.getIdComment(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUpdatedAt(),
                UserDTO.convertToDTO(comment.getUser())
        );
    }
}
