package com.example.latriumback.controller;

import com.example.latriumback.dto.board.BoardDTO;
import com.example.latriumback.dto.board.BoardWithPostsDTO;
import com.example.latriumback.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/api/board/{name}")
    public BoardWithPostsDTO getBoardByName(@PathVariable String name) {
        return boardService.findBoardById(name);
    }

    @PostMapping("/api/board")
    public void saveBoard(@RequestBody BoardDTO board) {
        boardService.saveBoard(board);
    }
}
