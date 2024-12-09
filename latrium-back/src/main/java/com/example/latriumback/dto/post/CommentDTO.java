package com.example.latriumback.dto.post;

import com.example.latriumback.dto.user.UserDTO;
import com.example.latriumback.entity.Comment;

import java.util.Date;

public class CommentDTO extends CommentWithoutPostDTO {
    private PostDTO post;

    public CommentDTO(Long idComment, String content, Date createdAt, Date updatedAt, UserDTO user, PostDTO post) {
        super(idComment, content, createdAt, updatedAt, user);
        this.post = post;
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
