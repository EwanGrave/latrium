package com.example.latriumback.dto.board;

import com.example.latriumback.entity.Board;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BoardDTO {
    private Long idBoard;
    private String name;
    private String description;
    private Date createdAt;
    private List<ThemeDTO> themes;

    public BoardDTO(
            Long idBoard,
            String name,
            String description,
            Date createdAt,
            List<ThemeDTO> themes
    ) {
        this.idBoard = idBoard;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.themes = themes;
    }

    public static BoardDTO convertToDTO(Board board) {
        return new BoardDTO(
                board.getIdBoard(),
                board.getName(),
                board.getDescription(),
                board.getCreatedAt(),
                board.getThemes().stream().map(ThemeDTO::convertToDTO).collect(Collectors.toList())
        );
    }

    public static Board convertToEntity(BoardDTO boardDTO) {
        return new Board(
                boardDTO.createdAt,
                boardDTO.description,
                boardDTO.name,
                boardDTO.getThemes().stream().map(ThemeDTO::convertToEntity).collect(Collectors.toSet())
        );
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Long getIdBoard() {
        return idBoard;
    }

    public List<ThemeDTO> getThemes() {
        return themes;
    }
}
