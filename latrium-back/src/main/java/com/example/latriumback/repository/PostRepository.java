package com.example.latriumback.repository;

import com.example.latriumback.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    @Override
    List<Post> findAll();

    @Query("select p from Post p inner join p.board b where b.name = :boardName")
    List<Post> findByBoardName(@Param("boardName") String boardName);

    Post findPostByIdPost(Long id);
}
