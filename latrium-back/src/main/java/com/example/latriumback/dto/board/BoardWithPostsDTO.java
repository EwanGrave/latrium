package com.example.latriumback.dto.board;

import com.example.latriumback.dto.post.PostWithoutBoardDTO;
import com.example.latriumback.entity.Board;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BoardWithPostsDTO extends BoardDTO{
    private List<PostWithoutBoardDTO> posts;

    public BoardWithPostsDTO(Long idBoard, String name, String description, Date createdAt, List<PostWithoutBoardDTO> posts) {
        super(idBoard, name, description, createdAt);
        this.posts = posts;
    }

    public static BoardWithPostsDTO convertToDTO(Board board) {
        return new BoardWithPostsDTO(
                board.getIdBoard(),
                board.getName(),
                board.getDescription(),
                board.getCreatedAt(),
                board.getPosts().stream().map(PostWithoutBoardDTO::convertToDTO).collect(Collectors.toList())
        );
    }

    public List<PostWithoutBoardDTO> getPosts() {
        return posts;
    }
}
