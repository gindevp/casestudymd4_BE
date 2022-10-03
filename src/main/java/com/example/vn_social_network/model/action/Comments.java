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
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private AppUsers users;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Posts posts;

    private String cmtContent;

}
