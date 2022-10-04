package com.example.vn_social_network.model.action;

import com.example.vn_social_network.model.app_users.AppUsers;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = AppUsers.class)
    @JsonManagedReference
    private List<AppUsers> users;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "posts_id" )
    private Posts posts;
}
