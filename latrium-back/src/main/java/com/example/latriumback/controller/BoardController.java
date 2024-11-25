package com.example.latriumback.controller;

import com.example.latriumback.dto.board.BoardWithPostsDTO;
import com.example.latriumback.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/api/board/{name}")
    public BoardWithPostsDTO getBoardByName(@PathVariable String name) {
        return boardService.findBoardById(name);
    }
}
