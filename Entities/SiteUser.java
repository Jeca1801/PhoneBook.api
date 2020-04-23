package com.example.demo.Entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor @Getter @Setter
public class SiteUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private int active;
    private String roles = "ROLE_USER";

    @OneToMany
    List<Contact> contacts;

    @OneToOne
    Comment comments;

    public SiteUser(String name, String username, String password, String roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
