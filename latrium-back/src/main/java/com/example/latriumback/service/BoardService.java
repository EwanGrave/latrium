package com.example.latriumback.service;

import com.example.latriumback.dto.board.BoardDTO;
import com.example.latriumback.dto.board.BoardWithPostsDTO;
import com.example.latriumback.dto.user.UserDTO;
import com.example.latriumback.entity.Board;
import com.example.latriumback.entity.User;
import com.example.latriumback.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public BoardWithPostsDTO findBoardById(String name) {
        Board board = boardRepository.findBoardByName(name);
        return BoardWithPostsDTO.convertToDTO(board);
    }

    public void createBoard(BoardDTO boardDTO) {
        Board board = BoardDTO.convertToEntity(boardDTO);
        boardRepository.save(board);
    }

    public void membership(UserDTO user, BoardDTO board) {
        User userEntity = UserDTO.convertToEntity(user);
        Board boardEntity = BoardDTO.convertToEntity(board);
        boardEntity.addUsers(userEntity);
        boardRepository.save(boardEntity);
    }
}
