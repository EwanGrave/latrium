package com.example.latriumback.controller;

import com.example.latriumback.dto.PostDTO;
import com.example.latriumback.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
