package com.example.latriumback.controller;

import com.example.latriumback.dto.post.CommentDTO;
import com.example.latriumback.dto.post.PostDTO;
import com.example.latriumback.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/post", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public List<PostDTO> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{postId}")
    public PostDTO getPostById(@PathVariable Long postId) {
        return postService.findPostById(postId);
    }

    @PostMapping("/create")
    public void createPost(@RequestBody PostDTO post) {
        postService.createPost(post);
    }

    @PostMapping("/comment/create")
    public void createComment(@RequestBody CommentDTO comment) {
        postService.createComment(comment);
    }
}
