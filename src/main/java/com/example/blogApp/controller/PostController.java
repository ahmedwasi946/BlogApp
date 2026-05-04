package com.example.blogApp.controller;

import com.example.blogApp.requestDTO.PostRequestDTO;
import com.example.blogApp.responseDTO.PostResponseDTO;
import com.example.blogApp.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PostController {

    private PostService postService;

    private PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/getAuthorById/{authorId}")
    public List<PostResponseDTO> getPostByAuthorId(@PathVariable Long authorId){
        return postService.findPostByAuthorId(authorId);
    }

    @GetMapping("/getAll")
    public List<PostResponseDTO> getAllPost(){
        return postService.getAllPost();
    }

    @PostMapping("/create")
    public PostResponseDTO createPost(@RequestBody PostRequestDTO requestDTO){
        return postService.createPost(requestDTO);
    }
}
