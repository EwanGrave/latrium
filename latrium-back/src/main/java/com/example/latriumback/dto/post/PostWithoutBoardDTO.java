package com.example.latriumback.dto.post;

import com.example.latriumback.dto.user.UserDTO;
import com.example.latriumback.entity.Post;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PostWithoutBoardDTO {
    private Long idPost;
    private String score;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private UserDTO user;
    private List<CommentWithoutPostDTO> comments;

    public PostWithoutBoardDTO(
            Long idPost,
            String score,
            String title,
            String content,
            Date createdAt,
            Date updatedAt,
            UserDTO user,
            List<CommentWithoutPostDTO> comments)
    {
        this.idPost = idPost;
        this.score = score;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.comments = comments;
    }

    public static PostWithoutBoardDTO convertToDTO(Post post) {
        return new PostWithoutBoardDTO(
                post.getIdPost(),
                post.getScore(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                UserDTO.convertToDTO(post.getUser()),
                post.getComments().stream().map(CommentWithoutPostDTO::convertToDTO).collect(Collectors.toList())
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
}
