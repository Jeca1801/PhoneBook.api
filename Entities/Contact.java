package com.example.demo.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor @Getter @Setter
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String phoneNumber;
    private String description;
    private String hobbies;
    private Date createdAt;

    @ManyToOne
    private SiteUser siteuser;

    public Contact(String name, String phoneNumber, String description, Date createdAt){
        this.createdAt = createdAt;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }
}
