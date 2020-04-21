package com.example.demo.repository;

import javax.transaction.Transactional;

import com.example.demo.Entities.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {
    SiteUser findByUsername(String username);

}
