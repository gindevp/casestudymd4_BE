package com.example.vn_social_network.model.account;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public AppUser() {
    }

    public AppUser(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
