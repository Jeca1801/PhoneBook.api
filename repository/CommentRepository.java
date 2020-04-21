package com.example.demo.repository;

import javax.transaction.Transactional;

import com.example.demo.Entities.Comment;
import com.example.demo.Entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CommentRepository extends JpaRepository<Contact, Long>{
    void save(Comment comment);
}
