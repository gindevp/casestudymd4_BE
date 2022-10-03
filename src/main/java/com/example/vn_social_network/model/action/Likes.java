package com.example.vn_social_network.model.action;

import com.example.vn_social_network.model.users.Users;
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

    @OneToMany(targetEntity = Users.class)
    private List<Users> users;

    @ManyToOne
    @JoinColumn(name = "posts_id" )
    private Posts posts;
}
