package com.example.blogApp.requestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import  lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDTO {
      @NotBlank(message = "User name is Required")
      @Size(min = 3, max = 10, message = "User Name must be between 3 and 10 characterd")
      private String userName;
      private String password;
      @Email
      private String email;


}
