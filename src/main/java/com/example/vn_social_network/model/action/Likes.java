package com.example.vn_social_network.model.action;

import com.example.vn_social_network.model.app_users.AppUsers;
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
    private List<AppUsers> users;

    @ManyToOne
    @JoinColumn(name = "posts_id" )
    private Posts posts;
}
