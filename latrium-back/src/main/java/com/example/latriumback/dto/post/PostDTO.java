package com.example.latriumback.dto.post;

import com.example.latriumback.dto.board.BoardDTO;
import com.example.latriumback.dto.UserDTO;
import com.example.latriumback.entity.Post;

import java.util.Date;

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
            BoardDTO board
    ) {
        super(idPost, score, title, content, createdAt, updatedAt, user);
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

    public BoardDTO getBoard() {
        return board;
    }
}
