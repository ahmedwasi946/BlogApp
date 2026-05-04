package com.example.blogApp.serviceImpl;

import com.example.blogApp.entity.Post;
import com.example.blogApp.entity.Users;
import com.example.blogApp.exception.ResourceNotFoundException;
import com.example.blogApp.repository.PostRepository;
import com.example.blogApp.repository.UsersRepository;
import com.example.blogApp.requestDTO.PostRequestDTO;
import com.example.blogApp.responseDTO.PostResponseDTO;
import com.example.blogApp.responseDTO.UsersResponseDTO;
import com.example.blogApp.service.PostService;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private UsersRepository usersRepository;

    public PostServiceImpl(PostRepository postRepository, UsersRepository usersRepository){
        this.postRepository= postRepository;
        this.usersRepository= usersRepository;
    }


    @Override
    public PostResponseDTO createPost(PostRequestDTO requestDTO) {
        Users user = usersRepository.findById(requestDTO.getAuthorId()).orElseThrow(
                () -> new ResourceNotFoundException("User id not found  : "
                        + requestDTO.getAuthorId()));

        Post post = new Post();
        post.setContent(requestDTO.getContent());
        post.setAuthor(user);
        Post savePost = postRepository.save(post);
        return new PostResponseDTO(savePost);

    }



    @Override
    public List<PostResponseDTO> findPostByAuthorId(Long id) {

        List<Post> allPostOfUser = postRepository
                .findByAuthor_id(id);

        if (allPostOfUser.isEmpty())
            throw new ResourceNotFoundException("No Post Exist with This User/Author in DB");

        return allPostOfUser.stream().map(PostResponseDTO::new).toList();
    }


    @Override
    public List<PostResponseDTO> getAllPost(){

        List<Post> all = postRepository.findAll();

        if (all.isEmpty())
            throw new ResourceNotFoundException("No Post Exist in DB");

        return all.stream().map(PostResponseDTO::new).toList();
    }



    @Override
    public PostResponseDTO updatePost(Long postId, PostRequestDTO requestDTO){

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post id not found : " + postId));

        post.setContent(requestDTO.getContent());
        Post save = postRepository.save(post);
        return new PostResponseDTO(save);

    }




    @Override
    public String deletePostById(Long id){

        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post id not found : " + id));

        postRepository.delete(post);
        return "Deleted post...!";
    }


}

