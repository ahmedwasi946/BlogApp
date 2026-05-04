package com.example.blogApp.service;

import com.example.blogApp.requestDTO.UserRequestDTO;
import com.example.blogApp.responseDTO.UsersResponseDTO;

import java.util.List;

public interface UserService {

    UsersResponseDTO createUsers(UserRequestDTO request);


    UsersResponseDTO getById(Long id);


    List<UsersResponseDTO> getAll();


    UsersResponseDTO updateUsers(Long id, UserRequestDTO request);

    String deleteUser(Long id);
}
