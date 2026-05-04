package com.example.blogApp.responseDTO;

import com.example.blogApp.entity.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersResponseDTO {

         private Long id;
         private String userName;
         private String email;

    public UsersResponseDTO(Users users){
        this.id = users.getId();
        this.userName = users.getUserName();
        this.email = users.getEmail();
    }
}
