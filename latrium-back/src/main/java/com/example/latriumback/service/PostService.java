package com.example.latriumback.service;

import com.example.latriumback.dto.PostDTO;
import com.example.latriumback.entity.Post;
import com.example.latriumback.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<PostDTO> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private PostDTO convertToDTO(Post post) {
        if (post == null) return null;
        return new PostDTO(
                post.getScore(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }
}
