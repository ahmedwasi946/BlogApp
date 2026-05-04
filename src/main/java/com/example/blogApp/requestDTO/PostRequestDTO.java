package com.example.blogApp.requestDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDTO {

    private String content;
    private Long authorId;


}
