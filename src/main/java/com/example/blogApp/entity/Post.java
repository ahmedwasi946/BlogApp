package com.example.blogApp.entity;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Post {


     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private String content;


     @CreationTimestamp
     private LocalDateTime postedAt ;
     @ManyToOne
    private Users author;
}
