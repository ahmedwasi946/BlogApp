package com.example.blogApp.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;



    public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        private String commentString;

        @ManyToOne
        private Post post;

        @ManyToOne
        private Users author;

        private LocalDateTime commentAt = LocalDateTime.now();

        public void setCommentString(@NotBlank(message = "commentString is Required") String commentString) {
        }

        public Long getId() {
            return null;
        }

        public String getCommentString() {
        }

        public Comment getPost() {
            return null;
        }

        public Comment getAuthor() {
            return null;
        }
    }
