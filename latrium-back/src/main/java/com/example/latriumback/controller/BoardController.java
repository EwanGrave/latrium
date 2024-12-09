package com.example.latriumback.controller;

import com.example.latriumback.dto.board.BoardDTO;
import com.example.latriumback.dto.board.BoardWithPostsDTO;
import com.example.latriumback.dto.user.UserDTO;
import com.example.latriumback.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/board", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/{name}")
    public BoardWithPostsDTO getBoardByName(@PathVariable String name) {
        return boardService.findBoardById(name);
    }

    @PostMapping("/create")
    public void createBoard(@RequestBody BoardDTO board) {
        boardService.createBoard(board);
    }

    @PostMapping("/membership")
    public void addMembership(@RequestBody UserDTO user, @RequestBody BoardDTO board) {
        boardService.membership(user, board);
    }
}
