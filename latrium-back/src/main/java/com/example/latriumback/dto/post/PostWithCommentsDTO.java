package com.example.latriumback.dto.post;

import com.example.latriumback.dto.BoardDTO;
import com.example.latriumback.dto.UserDTO;
import com.example.latriumback.entity.Post;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PostWithCommentsDTO extends PostDTO {
    private List<CommentDTO> comments;

    public PostWithCommentsDTO(
            Long idPost,
            String score,
            String title,
            String content,
            Date createdAt,
            Date updatedAt,
            UserDTO user,
            BoardDTO board,
            List<CommentDTO> comments
    ) {
        super(idPost, score, title, content, createdAt, updatedAt, user, board);
        this.comments = comments;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public static PostWithCommentsDTO convertToDTO(Post post) {
        return new PostWithCommentsDTO(
                post.getIdPost(),
                post.getScore(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                UserDTO.convertToDTO(post.getUser()),
                BoardDTO.convertToDTO(post.getBoard()),
                post.getComments().stream().map(CommentDTO::convertToDTO).collect(Collectors.toList())
        );
    }
}
