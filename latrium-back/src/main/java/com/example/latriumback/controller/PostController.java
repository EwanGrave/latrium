package com.example.latriumback.controller;

import com.example.latriumback.dto.post.PostDTO;
import com.example.latriumback.dto.post.PostWithCommentsDTO;
import com.example.latriumback.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/api/posts")
    public List<PostDTO> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/api/posts/board/{boardName}")
    public List<PostDTO> getPostsByBoardName(@PathVariable String boardName) {
        return postService.findByBoardName(boardName);
    }

    @GetMapping("/api/posts/{postId}")
    public PostWithCommentsDTO getPostById(@PathVariable Long postId) {
        return postService.findPostById(postId);
    }
}
