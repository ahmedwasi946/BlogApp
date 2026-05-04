package com.example.blogApp.service;

import com.example.blogApp.requestDTO.PostRequestDTO;
import com.example.blogApp.responseDTO.PostResponseDTO;

import java.util.List;

public interface PostService {

    PostResponseDTO createPost(PostRequestDTO requestDTO);

    List<PostResponseDTO> findPostByAuthorId(Long id);

    List<PostResponseDTO> getAllPost();

    PostResponseDTO updatePost(Long postId, PostRequestDTO requestDTO);

    String deletePostById(Long id);
}
