package com.example.latriumback.controller;

import com.example.latriumback.dto.board.BoardDTO;
import com.example.latriumback.dto.board.BoardWithPostsDTO;
import com.example.latriumback.dto.user.UserDTO;
import com.example.latriumback.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createBoard(@RequestBody BoardDTO board) {
        try {
            boardService.createBoard(board);
            return ResponseEntity.status(HttpStatus.CREATED).body("Board created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating board : " + e.getMessage());
        }
    }

    @PostMapping("/membership")
    public ResponseEntity<String> addMembership(@RequestBody UserDTO user, @RequestBody BoardDTO board) {
        try {
            boardService.membership(user, board);
            return ResponseEntity.status(HttpStatus.CREATED).body("Membership created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating membership : " + e.getMessage());
        }
    }
}
