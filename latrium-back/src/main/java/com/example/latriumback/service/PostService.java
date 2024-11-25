package com.example.latriumback.service;

import com.example.latriumback.dto.post.PostDTO;
import com.example.latriumback.dto.post.PostWithCommentsDTO;
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
        return posts.stream().map(PostDTO::convertToDTO).collect(Collectors.toList());
    }

    public List<PostDTO> findByBoardName(String name) {
        List<Post> posts = postRepository.findByBoardName(name);
        return posts.stream().map(PostDTO::convertToDTO).collect(Collectors.toList());
    }

    public PostWithCommentsDTO findPostById(Long id) {
        Post post = postRepository.findPostByIdPost(id);
        return PostWithCommentsDTO.convertToDTO(post);
    }
}
