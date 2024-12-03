package com.example.latriumback.controller;

import com.example.latriumback.dto.post.PostDTO;
import com.example.latriumback.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/api/posts")
    public List<PostDTO> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/api/posts/{postId}")
    public PostDTO getPostById(@PathVariable Long postId) {
        return postService.findPostById(postId);
    }

    @PostMapping("/api/post")
    public void savePost(@RequestBody PostDTO post) {
        postService.savePost(post);
    }
}
