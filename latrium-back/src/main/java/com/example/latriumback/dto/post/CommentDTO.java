package com.example.latriumback.dto.post;

import com.example.latriumback.dto.user.UserDTO;
import com.example.latriumback.entity.Comment;

import java.util.Date;

public class CommentDTO {
    private Long idComment;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private UserDTO user;
    private PostDTO post;

    public CommentDTO(Long idComment, String content, Date createdAt, Date updatedAt, UserDTO user, PostDTO post) {
        this.idComment = idComment;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.post = post;
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

    public PostDTO getPost() {
        return post;
    }

    public static CommentDTO convertToDTO(Comment comment) {
        return new CommentDTO(
                comment.getIdComment(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUpdatedAt(),
                UserDTO.convertToDTO(comment.getUser()),
                PostDTO.convertToDTO(comment.getPost())
        );
    }

    public static Comment convertToEntity(CommentDTO comment) {
        return new Comment(
                comment.getIdComment(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUpdatedAt(),
                UserDTO.convertToEntity(comment.getUser()),
                PostDTO.convertToEntity(comment.getPost())
        );
    }
}
