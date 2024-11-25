package com.example.latriumback.dto;

import com.example.latriumback.entity.Board;

import java.util.Date;

public class BoardDTO {
    private String name;
    private String description;
    private Date createdAt;

    public BoardDTO(String name, String description, Date createdAt) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

    public static BoardDTO convertToDTO(Board board) {
        return new BoardDTO(board.getName(), board.getDescription(), board.getCreatedAt());
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
}
