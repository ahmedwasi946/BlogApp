package com.example.blogApp.serviceImpl;


import com.example.blogApp.entity.Users;
import com.example.blogApp.exception.ResourceNotFoundException;
import com.example.blogApp.repository.UsersRepository;
import com.example.blogApp.requestDTO.UserRequestDTO;
import com.example.blogApp.responseDTO.UsersResponseDTO;
import com.example.blogApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    private UsersRepository usersRepository;
    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }



    @Override
    public UsersResponseDTO createUsers(UserRequestDTO request) {


        Users users = new Users();

        users.setUserName(request.getUserName());
        users.setEmail(request.getEmail());
        users.setPassword(request.getPassword());
        users.setRole("NormalUser");

        Users save = usersRepository.save(users);

        return  new UsersResponseDTO(save);


    }




    @Override
    public UsersResponseDTO getById(Long id) {

        Users users = usersRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User id not found : " + id));
        return new UsersResponseDTO(users);
    }



    @Override
    public List<UsersResponseDTO> getAll() {

        List<Users> all = usersRepository.findAll();

        if (all.isEmpty())
            throw new ResourceNotFoundException("No User Exist in DB");

        return all.stream().map(UsersResponseDTO::new).toList(); // same work (loops)

    }



    @Override
    public UsersResponseDTO updateUsers(Long id, UserRequestDTO request) {

        Users users = usersRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User id not found : " + id));

        // .isEmpty() or .isBlank()

        if (request.getUserName() != null && !request.getUserName().isBlank())
            users.setUserName(request.getUserName());


        if(request.getEmail() != null && !request.getEmail().isBlank())
            users.setEmail(request.getEmail());

        if (request.getPassword() != null && ! request.getPassword().isBlank())
            users.setPassword(request.getPassword());


        Users save = usersRepository.save(users);

        return new UsersResponseDTO(save);
    }




    @Override
    public String deleteUser(Long id) {

        Users users = usersRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User id not found : " + id));

        usersRepository.delete(users);
        return "User Deleted Successfully!";
    }




}

