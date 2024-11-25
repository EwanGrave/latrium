package com.example.latriumback.dto.board;

import com.example.latriumback.entity.Board;

import java.util.Date;

public class BoardDTO {
    private Long idBoard;
    private String name;
    private String description;
    private Date createdAt;

    public BoardDTO(Long idBoard, String name, String description, Date createdAt) {
        this.idBoard = idBoard;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

    public static BoardDTO convertToDTO(Board board) {
        return new BoardDTO(
                board.getIdBoard(),
                board.getName(),
                board.getDescription(),
                board.getCreatedAt()
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
}
