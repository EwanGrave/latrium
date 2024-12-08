package com.example.latriumback.dto.post;

import com.example.latriumback.dto.board.BoardDTO;
import com.example.latriumback.dto.user.UserDTO;
import com.example.latriumback.entity.Post;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PostDTO extends PostWithoutBoardDTO {
    private BoardDTO board;

    public PostDTO(
            Long idPost,
            String score,
            String title,
            String content,
            Date createdAt,
            Date updatedAt,
            UserDTO user,
            List<CommentDTO> comments,
            BoardDTO board
    ) {
        super(idPost, score, title, content, createdAt, updatedAt, user, comments);
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
                post.getComments().stream().map(CommentDTO::convertToDTO).collect(Collectors.toList()),
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

    public BoardDTO getBoard() {
        return board;
    }
}
