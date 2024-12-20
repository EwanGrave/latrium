package com.example.latriumback.dto.post;

import com.example.latriumback.dto.board.BoardDTO;
import com.example.latriumback.dto.user.UserDTO;
import com.example.latriumback.entity.Post;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PostDTO {
    private Long idPost;
    private String score;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private UserDTO user;
    private List<CommentWithoutPostDTO> comments;
    private BoardDTO board;

    public PostDTO(
            Long idPost,
            String score,
            String title,
            String content,
            Date createdAt,
            Date updatedAt,
            UserDTO user,
            List<CommentWithoutPostDTO> comments,
            BoardDTO board
    ) {
        this.idPost = idPost;
        this.score = score;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.comments = comments;
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
                post.getComments().stream().map(CommentWithoutPostDTO::convertToDTO).collect(Collectors.toList()),
                BoardDTO.convertToDTO(post.getBoard())
        );
    }

    public static Post convertToEntity(PostDTO post) {
        return new Post(
                post.getIdPost(),
                post.getScore(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                UserDTO.convertToEntity(post.getUser()),
                BoardDTO.convertToEntity(post.getBoard())
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

    public Long getIdPost() {
        return idPost;
    }

    public List<CommentWithoutPostDTO> getComments() {
        return comments;
    }

    public BoardDTO getBoard() {
        return board;
    }
}
