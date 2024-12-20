package com.example.latriumback.dto.board;

import com.example.latriumback.dto.post.PostDTO;
import com.example.latriumback.entity.Board;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BoardWithPostsDTO extends BoardDTO {
    private List<PostDTO> posts;

    public BoardWithPostsDTO(Long idBoard, String name, String description, Date createdAt , List<ThemeDTO> themes, List<PostDTO> posts) {
        super(idBoard, name, description, createdAt, themes);
        this.posts = posts;
    }

    public static BoardWithPostsDTO convertToDTO(Board board) {
        return new BoardWithPostsDTO(
                board.getIdBoard(),
                board.getName(),
                board.getDescription(),
                board.getCreatedAt(),
                board.getThemes().stream().map(ThemeDTO::convertToDTO).collect(Collectors.toList()),
                board.getPosts().stream().map(PostDTO::convertToDTO).collect(Collectors.toList())
        );
    }

    public List<PostDTO> getPosts() {
        return posts;
    }
}
