package com.example.latriumback.dto.post;

import com.example.latriumback.dto.BoardDTO;
import com.example.latriumback.dto.UserDTO;
import com.example.latriumback.entity.Post;

import java.util.Date;

public class PostDTO {
    private Long idPost;
    private String score;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private UserDTO user;
    private BoardDTO board;

    public PostDTO(
            Long idPost,
            String score,
            String title,
            String content,
            Date createdAt,
            Date updatedAt,
            UserDTO user,
            BoardDTO board)
    {
        this.idPost = idPost;
        this.score = score;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.board = board;
    }

    public static PostDTO convertToDTO(Post post) {
        return new PostDTO(
                post.getIdPost(),
                post.getScore(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                UserDTO.convertToDTO(post.getUser()),
                BoardDTO.convertToDTO(post.getBoard())
        );
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

    public UserDTO getUser() {
        return user;
    }

    public BoardDTO getBoard() {
        return board;
    }

    public Long getIdPost() {
        return idPost;
    }
}
