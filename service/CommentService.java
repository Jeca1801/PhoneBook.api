package com.example.demo.service;

import com.example.demo.Entities.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

}
