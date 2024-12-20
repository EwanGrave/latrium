package com.example.latriumback.repository;

import com.example.latriumback.entity.Board;
import com.example.latriumback.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Override
    List<Board> findAll();

    Board findBoardByName(String name);
}
