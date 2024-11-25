package com.example.latriumback.repository;

import com.example.latriumback.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    @Override
    List<Post> findAll();
}
