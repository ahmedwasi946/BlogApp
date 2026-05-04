package com.example.blogApp.service;

import com.example.blogApp.requestDTO.CommentRequestDTO;
import com.example.blogApp.responseDTO.CommentResponseDTO;

import java.util.List;

public interface CommentService {

    CommentResponseDTO createComment(CommentRequestDTO requestDTO);

    List<CommentResponseDTO> getAllCommentByAuthor(Long authorId);

    CommentResponseDTO commentUpdate(Long commentId, CommentRequestDTO requestDTO);

    List<CommentResponseDTO> getAllComment();

    String deleteComment(Long commentId);
}
