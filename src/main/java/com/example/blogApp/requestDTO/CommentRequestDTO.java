package com.example.blogApp.requestDTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {

       @NotBlank(message = "commentString is Required")
       private String commentString;
       @NotNull(message = "Post id must not be null")
       private Long postId;
       @NotNull(message = "user id must not be null")
       private Long authorId;

}
