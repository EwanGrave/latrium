package com.example.latriumback.controller;

import com.example.latriumback.dto.post.CommentDTO;
import com.example.latriumback.dto.post.PostDTO;
import com.example.latriumback.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createPost(@RequestBody PostDTO post) {
        try {
            postService.createPost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body("Post created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating post : " + e.getMessage());
        }
    }

    @PostMapping("/comment/create")
    public ResponseEntity<String> createComment(@RequestBody CommentDTO comment) {
        try {
            postService.createComment(comment);
            return ResponseEntity.status(HttpStatus.CREATED).body("Comment created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating comment : " + e.getMessage());
        }
    }
}
